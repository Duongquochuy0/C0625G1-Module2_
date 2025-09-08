package furama_manage.controller;

import furama_manage.entity.Booking;
import furama_manage.entity.KhachHang;
import furama_manage.repository.BookingRepository;
import furama_manage.repository.HopDongRepository;
import furama_manage.repository.KhachHangRepository;
import furama_manage.service.BookingService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

public class BookingController {
    private static final Scanner scanner = new Scanner(System.in);

    private static final BookingRepository bookingRepository = new BookingRepository();
    private static final HopDongRepository hopDongRepository = new HopDongRepository();
    private static final KhachHangRepository khachHangRepository = new KhachHangRepository();

    private static final BookingService bookingService =
            new BookingService(bookingRepository, hopDongRepository, khachHangRepository);

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
                        break;
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
        String maBooking = generateBookingId();
        System.out.println("Mã booking được cấp: " + maBooking);
        System.out.println("--- DANH SÁCH KHÁCH HÀNG ---");
        for (KhachHang c : khachHangRepository.getAllCustomer()) {
            System.out.println(c.getId() + " - " + c.getHoTen());
        }
        String maKhachHang;
        while (true) {
            System.out.print("Chọn mã khách hàng từ danh sách: ");
            maKhachHang = scanner.nextLine().trim();
            if (khachHangRepository.existsById(maKhachHang)) {
                break;
            } else {
                System.err.println("Mã khách hàng không tồn tại, vui lòng nhập lại.");
            }
        }
        LocalDate ngayBatDau;
        LocalDate ngayKetThuc;
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
                System.err.println("Lỗi: Định dạng ngày không hợp lệ. Vui lòng nhập theo định dạng dd/MM/yyyy");
            }
        }
        List<String> availableServices = bookingRepository.getAvailableServices(ngayBatDau, ngayKetThuc);
        if (availableServices.isEmpty()) {
            System.err.println("Không có dịch vụ nào trống trong khoảng thời gian này");
            return;
        }

        System.out.println("--- DANH SÁCH DỊCH VỤ CÒN TRỐNG ---");
        for (String s : availableServices) {
            System.out.println("- " + s);
        }
        String maDichVu;
        while (true) {
            System.out.print("Chọn mã dịch vụ: ");
            maDichVu = scanner.nextLine().trim();
            if (availableServices.contains(maDichVu)) {
                break;
            } else {
                System.err.println("Mã dịch vụ không hợp lệ, vui lòng chọn lại");
            }
        }
        bookingService.addNewBooking(new Booking(maBooking, maKhachHang, maDichVu, ngayBatDau, ngayKetThuc));
        System.out.println("Đặt phòng thành công");
    }

    private String generateBookingId() {
        int max = 0;
        for (Booking b : bookingRepository.getAllBookings()) {
            try {
                String[] parts = b.getMaBooking().split("-");
                int num = Integer.parseInt(parts[1]);
                if (num > max) max = num;
            } catch (Exception ignored) {
            }
        }
        return String.format("BK-%04d", max + 1);
    }
}
