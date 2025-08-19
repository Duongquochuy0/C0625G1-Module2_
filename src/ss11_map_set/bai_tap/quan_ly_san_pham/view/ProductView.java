package ss11_map_set.bai_tap.quan_ly_san_pham.view;

import ss11_map_set.bai_tap.quan_ly_san_pham.entity.Product;
import java.util.ArrayList;
import java.util.Scanner;

public class ProductView {
    static Scanner scanner = new Scanner(System.in);
    public static void disPlay(ArrayList<Product> ArrayList){
        for (Product product: ArrayList) {
            System.out.println(product);
        }
    }
    public static Product inputDataForProduct() {
        System.out.print("Nhập id: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhập tên: ");
        String name = scanner.nextLine();
        System.out.print("Nhập giá: ");
        double price = Double.parseDouble(scanner.nextLine());
        Product product = new Product(id,name,price);
        return product;
    }
    public static void display(Product product) {
        System.out.println(product);
    }
}
