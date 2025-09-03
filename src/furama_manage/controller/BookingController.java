package furama_manage.controller;

import furama_manage.entity.Booking;
import furama_manage.repository.BookingRepository;
import furama_manage.repository.HopDongRepository;
import furama_manage.service.BookingService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class BookingController {
    private static final Scanner scanner = new Scanner(System.in);
    private static final BookingRepository bookingRepository = new BookingRepository();
    private static final HopDongRepository contractRepository = new HopDongRepository();
    private static final BookingService bookingService = new BookingService(bookingRepository, contractRepository);
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public void menu() {
        int choice;
        do {
            System.out.println("\n---- Quản Lý Đặt Phòng ----");
            System.out.println("1. Đặt phòng mới");
            System.out.println("2. Hiển thị danh sách booking");
            System.out.println("3. Tạo hợp đồng mới (từ booking sớm nhất)");
            System.out.println("4. Hiển thị danh sách hợp đồng");
            System.out.println("5. Quay lại menu chính");
            System.out.print("Chọn chức năng: ");
            try {
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        addNewBooking();
                        break;
                    case 2:
                        bookingService.displayAllBookings();
                        break;
                    case 3:
                        bookingService.createContractFromQueue();
                        break;
                    case 4:
                        bookingService.displayAllContracts();
                        break;
                    case 5:
                        System.out.println("Đang quay lại menu chính...");
                        return;
                    default:
                        System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
                }
            } catch (NumberFormatException e) {
                System.err.println("Lỗi: Dữ liệu đầu vào không hợp lệ. Vui lòng nhập một số.");
                choice = 0;
            }
        } while (choice != 5);
    }

    private void addNewBooking() {
        System.out.println("\n--- THÊM BOOKING MỚI ---");

        System.out.print("Nhập mã booking: ");
        String maBooking = scanner.nextLine();

        System.out.print("Nhập mã khách hàng: ");
        String maKhachHang = scanner.nextLine();

        System.out.print("Nhập mã dịch vụ: ");
        String maDichVu = scanner.nextLine();

        LocalDate ngayBatDau = null;
        LocalDate ngayKetThuc = null;
        while (true) {
            try {
                System.out.print("Nhập ngày bắt đầu (dd/MM/yyyy): ");
                ngayBatDau = LocalDate.parse(scanner.nextLine(), formatter);

                System.out.print("Nhập ngày kết thúc (dd/MM/yyyy): ");
                ngayKetThuc = LocalDate.parse(scanner.nextLine(), formatter);
                if (ngayBatDau.isBefore(ngayKetThuc)) {
                    break;
                } else {
                    System.err.println("Lỗi: Ngày bắt đầu phải trước ngày kết thúc. Vui lòng nhập lại.");
                }
            } catch (DateTimeParseException e) {
                System.err.println("Lỗi: Định dạng ngày không hợp lệ. Vui lòng nhập theo định dạng dd/MM/yyyy.");
            }
        }
        bookingService.addNewBooking(new Booking(maBooking, maKhachHang, maDichVu, ngayBatDau, ngayKetThuc));
    }
}
