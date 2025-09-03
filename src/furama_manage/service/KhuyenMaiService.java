package furama_manage.service;

import furama_manage.entity.KhuyenMai;
import furama_manage.repository.KhuyenMaiRepository;

import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

public class KhuyenMaiService {
    private final KhuyenMaiRepository khuyenMaiRepository = new KhuyenMaiRepository();
    private final Scanner scanner = new Scanner(System.in);
    public void displayCustomersUseService() {
        System.out.print("Nhập năm cần tìm: ");
        int year = Integer.parseInt(scanner.nextLine());
        Set<String> customers = khuyenMaiRepository.getCustomersByYear(year);
        if (customers.isEmpty()) {
            System.out.println("Không có khách hàng nào sử dụng dịch vụ trong năm " + year);
        } else {
            System.out.println("--- DANH SÁCH KHÁCH HÀNG NĂM " + year + " ---");
            customers.forEach(System.out::println);
        }
    }
    public void displayCustomersGetVoucher() {
        System.out.print("Nhập số lượng voucher 10%: ");
        int v10 = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhập số lượng voucher 20%: ");
        int v20 = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhập số lượng voucher 50%: ");
        int v50 = Integer.parseInt(scanner.nextLine());

        Stack<KhuyenMai> vouchers = khuyenMaiRepository.distributeVouchers(v10, v20, v50);
        if (vouchers.isEmpty()) {
            System.out.println("Không có voucher nào được phân phát.");
        } else {
            System.out.println("--- DANH SÁCH KHÁCH HÀNG NHẬN VOUCHER ---");
            vouchers.forEach(System.out::println);
        }
    }
}
