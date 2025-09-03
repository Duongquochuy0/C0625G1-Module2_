package furama_manage.repository;

import furama_manage.entity.Booking;
import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

public class BookingRepository {
    private static final String FILE_PATH = "furama_manage/data/booking.csv";

    private static Set<Booking> bookingSet;
    private static PriorityQueue<Booking> bookingQueue;
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    static {
        bookingSet = new TreeSet<>(new Booking.BookingComparator());
        bookingQueue = new PriorityQueue<>(new Booking.BookingComparator());
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
                        bookingQueue.add(booking);
                    } catch (DateTimeParseException e) {
                        System.err.println("Lỗi định dạng ngày cho dòng: " + line);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Không thể đọc file booking.csv: " + e.getMessage());
        }
    }
    public void addNewBooking(Booking booking) {
        if (!bookingSet.contains(booking)) {
            bookingSet.add(booking);
            bookingQueue.add(booking);
            saveBookingsToFile();
        } else {
            System.err.println("Booking đã tồn tại");
        }
    }
    public Set<Booking> getAllBookings() {
        return new TreeSet<>(bookingSet);
    }
    public void removeBooking(Booking booking) {
        if (bookingSet.contains(booking)) {
            bookingSet.remove(booking);
            bookingQueue.remove(booking);
            saveBookingsToFile();
        } else {
            System.err.println("Không tìm thấy booking để xóa.");
        }
    }
    public void displayAllBookings() {
        if (bookingSet.isEmpty()) {
            System.out.println("Danh sách đặt phòng trống.");
        } else {
            bookingSet.forEach(System.out::println);
        }
    }

    public Booking getEarliestBooking() {
        return bookingQueue.poll();
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
}
