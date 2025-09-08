package furama_manage.repository;

import furama_manage.entity.Booking;
import furama_manage.entity.CoSoVatChat;
import furama_manage.util.BookingDateComparator;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

public class BookingRepository implements IBookingRepository {
    private static final String FILE_PATH = "furama_manage/data/booking.csv";
    private static Set<Booking> bookingSet;
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private final KhachHangRepository khachHangRepository = new KhachHangRepository();

    static {
        bookingSet = new TreeSet<>(new BookingDateComparator());
        readBookingsFromFile();
    }
    private static void readBookingsFromFile() {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 5) {
                    try {
                        LocalDate ngayBatDau = LocalDate.parse(data[3], formatter);
                        LocalDate ngayKetThuc = LocalDate.parse(data[4], formatter);
                        Booking booking = new Booking(data[0], data[1], data[2], ngayBatDau, ngayKetThuc);
                        bookingSet.add(booking);
                    } catch (DateTimeParseException e) {
                        System.err.println("Lỗi định dạng ngày cho dòng: " + line);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Không thể đọc file booking.csv: " + e.getMessage());
        }
    }
    private String generateNewBookingId() {
        int maxId = 0;
        for (Booking booking : bookingSet) {
            String idNumber = booking.getMaBooking().replace("BK-", "");
            try {
                int num = Integer.parseInt(idNumber);
                if (num > maxId) {
                    maxId = num;
                }
            } catch (NumberFormatException ignored) {}
        }
        return String.format("BK-%04d", maxId + 1);
    }
    private boolean isConflict(Booking newBooking) {
        for (Booking b : bookingSet) {
            if (b.getMaDichVu().equals(newBooking.getMaDichVu())) {
                boolean overlap = !(newBooking.getNgayKetThuc().isBefore(b.getNgayBatDau())
                        || newBooking.getNgayBatDau().isAfter(b.getNgayKetThuc()));
                if (overlap) {
                    return true;
                }
            }
        }
        return false;
    }
    public void addNewBooking(Booking booking) {
        if (!khachHangRepository.existsById(booking.getMaKhachHang())) {
            System.err.println("Không tồn tại khách hàng với ID: " + booking.getMaKhachHang());
            return;
        }
        booking.setMaBooking(generateNewBookingId());
        if (isConflict(booking)) {
            System.err.println(" Trùng lịch booking cho dịch vụ " + booking.getMaDichVu());
            return;
        }

        if (bookingSet.add(booking)) {
            saveBookingsToFile();
            System.out.println("Đã thêm booking: " + booking.getMaBooking());
        } else {
            System.err.println("Booking đã tồn tại (mã trùng)");
        }
    }

    public Set<Booking> getAllBookings() {
        return new LinkedHashSet<>(bookingSet);
    }

    public void displayAllBookings() {
        if (bookingSet.isEmpty()) {
            System.out.println("Danh sách đặt phòng trống");
        } else {
            bookingSet.forEach(System.out::println);
        }
    }

    public Booking getEarliestBooking() {
        return bookingSet.isEmpty() ? null : bookingSet.iterator().next();
    }

    private void saveBookingsToFile() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Booking booking : bookingSet) {
                bw.write(booking.toCSV());
                bw.newLine();
            }
        } catch (IOException e) {
            System.err.println("Không thể ghi file booking.csv: " + e.getMessage());
        }
    }
    public boolean existsById(String id) {
        return khachHangRepository.existsById(id);
    }
    public Set<String> getAllServiceIds() {
        Set<String> serviceIds = new HashSet<>();
        for (Booking b : bookingSet) {
            serviceIds.add(b.getMaDichVu());
        }
        return serviceIds;
    }
    public List<String> getAvailableServices(LocalDate start, LocalDate end) {
        CoSoVatChatRepository coSoVatChatRepository = new CoSoVatChatRepository();
        Map<CoSoVatChat, Integer> allFacilities = coSoVatChatRepository.getAllFacilities();

        Set<Booking> allBookings = getAllBookings();
        List<String> available = new ArrayList<>();
        for (CoSoVatChat facility : allFacilities.keySet()) {
            String serviceId = facility.getMaDichVu();
            boolean isBooked = false;
            for (Booking b : allBookings) {
                if (b.getMaDichVu().equals(serviceId)) {
                    if (!(end.isBefore(b.getNgayBatDau()) || start.isAfter(b.getNgayKetThuc()))) {
                        isBooked = true;
                        break;
                    }
                }
            }
            if (!isBooked) {
                available.add(serviceId);
            }
        }

        return available;
    }

    public Booking pollEarliestBooking() {
        if (bookingSet.isEmpty()) return null;

        Booking earliest = bookingSet.iterator().next();
        bookingSet.remove(earliest);
        saveBookingsToFile();
        return earliest;
    }
}
