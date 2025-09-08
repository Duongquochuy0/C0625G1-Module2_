package furama_manage.service;

import furama_manage.entity.Booking;
import furama_manage.entity.Contract;
import furama_manage.entity.KhachHang;
import furama_manage.repository.BookingRepository;
import furama_manage.repository.HopDongRepository;
import furama_manage.repository.KhachHangRepository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class BookingService implements IBookingService {
    private final BookingRepository bookingRepository;
    private final HopDongRepository hopDongRepository;
    private final KhachHangRepository khachHangRepository;
    private final Scanner scanner = new Scanner(System.in);
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public BookingService(BookingRepository bookingRepository,
                          HopDongRepository hopDongRepository,
                          KhachHangRepository khachHangRepository) {
        this.bookingRepository = bookingRepository;
        this.hopDongRepository = hopDongRepository;
        this.khachHangRepository = khachHangRepository;
    }

    @Override
    public void addNewBooking(Booking booking) {
        bookingRepository.addNewBooking(booking);
    }
    public void createBookingInteractive() {
        System.out.println("--- DANH SÁCH KHÁCH HÀNG ---");
        List<KhachHang> customers = khachHangRepository.getAllCustomer();
        for (KhachHang kh : customers) {
            System.out.println(kh.getId() + " - " + kh.getHoTen());
        }

        String customerId;
        while (true) {
            System.out.print("Nhập ID khách hàng: ");
            customerId = scanner.nextLine();
            if (khachHangRepository.existsById(customerId)) {
                break;
            }
            System.out.println(" ID khách hàng không tồn tại, vui lòng nhập lại!");
        }

        LocalDate startDate;
        LocalDate endDate;
        while (true) {
            try {
                System.out.print("Nhập ngày bắt đầu (dd/MM/yyyy): ");
                startDate = LocalDate.parse(scanner.nextLine(), formatter);

                System.out.print("Nhập ngày kết thúc (dd/MM/yyyy): ");
                endDate = LocalDate.parse(scanner.nextLine(), formatter);

                if (!endDate.isAfter(startDate)) {
                    System.out.println(" Ngày kết thúc phải sau ngày bắt đầu!");
                    continue;
                }
                break;
            } catch (Exception e) {
                System.out.println(" Sai định dạng ngày, vui lòng nhập lại!");
            }
        }
        List<String> availableServices = bookingRepository.getAvailableServices(startDate, endDate);

        if (availableServices.isEmpty()) {
            System.out.println("⚠ Không có dịch vụ nào còn trống trong khoảng thời gian này.");
            return;
        }

        System.out.println("--- DANH SÁCH DỊCH VỤ CÒN TRỐNG ---");
        for (String serviceId : availableServices) {
            System.out.println(" - " + serviceId);
        }

        String serviceId;
        while (true) {
            System.out.print("Chọn mã dịch vụ từ danh sách trên: ");
            serviceId = scanner.nextLine();
            if (availableServices.contains(serviceId)) {
                break;
            }
            System.out.println("Mã dịch vụ không hợp lệ, vui lòng chọn lại!");
        }

        Booking newBooking = new Booking(null, customerId, serviceId, startDate, endDate);
        addNewBooking(newBooking);
    }
    @Override
    public void createContractFromQueue() {
        Booking earliestBooking = bookingRepository.pollEarliestBooking();

        if (earliestBooking != null) {
            System.out.println("Đang tạo hợp đồng cho booking: " + earliestBooking.getMaBooking());

            String contractId = generateContractId();
            Contract contract = new Contract(
                    contractId,
                    earliestBooking.getMaBooking(),
                    earliestBooking.getMaKhachHang(),
                    earliestBooking.getMaDichVu()
            );

            hopDongRepository.addContract(contract);
            System.out.println(" Đã tạo và lưu hợp đồng thành công với mã: " + contractId);
        } else {
            System.out.println(" Không còn booking nào trong hàng đợi để tạo hợp đồng.");
        }
    }

    private String generateContractId() {
        List<Contract> allContracts = hopDongRepository.getAllContracts();
        int max = 0;
        for (Contract c : allContracts) {
            try {
                String[] parts = c.getMaHopDong().split("-");
                int num = Integer.parseInt(parts[1]);
                if (num > max) max = num;
            } catch (Exception ignored) {
            }
        }
        return String.format("HD-%04d", max + 1);
    }

    @Override
    public void displayAllBookings() {
        Set<Booking> allBookings = bookingRepository.getAllBookings();
        if (allBookings.isEmpty()) {
            System.out.println(" Hiện không có booking nào trong hệ thống.");
            return;
        }
        System.out.println("--- DANH SÁCH TẤT CẢ BOOKING ---");
        for (Booking booking : allBookings) {
            System.out.println(booking);
        }
        System.out.println("-----------------------------------");
    }

    @Override
    public void displayAllContracts() {
        List<Contract> allContracts = hopDongRepository.getAllContracts();
        if (allContracts.isEmpty()) {
            System.out.println(" Hiện không có hợp đồng nào được tạo.");
            return;
        }
        System.out.println("--- DANH SÁCH TẤT CẢ HỢP ĐỒNG ĐÃ TẠO ---");
        for (Contract contract : allContracts) {
            System.out.println(contract);
        }
        System.out.println("-----------------------------------");
    }
}
