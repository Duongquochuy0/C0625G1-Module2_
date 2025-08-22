package ss17_io_binary_file.bai_tap.quan_ly_san_pham.view;

import ss17_io_binary_file.bai_tap.quan_ly_san_pham.entity.Product;

import java.util.List;
import java.util.Scanner;

public class ProductView {
    static Scanner scanner = new Scanner(System.in);
    public static Product inputDataForProduct() {
        System.out.print("Nhập id: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhập tên: ");
        String name = scanner.nextLine();
        System.out.print("Nhập giá: ");
        double price = Double.parseDouble(scanner.nextLine());
        System.out.print("Nhập nơi xuất xứ: ");
        String manufacturer = scanner.nextLine();
        System.out.print("Nhập mô tả: ");
        String description = scanner.nextLine();
        return new Product(id, name, price, manufacturer, description);
    }
    public static void display(Product product) {
        System.out.println(product);
    }
}
