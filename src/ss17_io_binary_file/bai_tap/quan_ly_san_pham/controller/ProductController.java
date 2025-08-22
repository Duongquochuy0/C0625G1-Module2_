package ss17_io_binary_file.bai_tap.quan_ly_san_pham.controller;

import ss17_io_binary_file.bai_tap.quan_ly_san_pham.entity.Product;
import ss17_io_binary_file.bai_tap.quan_ly_san_pham.service.IProductService;
import ss17_io_binary_file.bai_tap.quan_ly_san_pham.service.ProductService;
import ss17_io_binary_file.bai_tap.quan_ly_san_pham.view.ProductView;
import transportation_mannerger.entity.Oto;
import transportation_mannerger.view.OtoView;

import java.util.List;
import java.util.Scanner;

public class ProductController {
    private IProductService productService = new ProductService();

    public void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        final int DISPLAY = 1;
        final int ADD = 2;
        final int DELETE = 3;
        final int FIND = 4;
        final int SORT_ASC = 5;
        final int SORT_DESC = 6;
        final int EDIT =7;
        boolean flag = true;

        while (flag) {
            System.out.println("===== QUẢN LÝ SẢN PHẨM =====");
            System.out.println("1. Danh sách sản phẩm");
            System.out.println("2. Thêm mới sản phẩm");
            System.out.println("3. Xoá sản phẩm");
            System.out.println("4. Tìm kiếm theo id");
            System.out.println("5. Sắp xếp theo giá tăng dần");
            System.out.println("6. Sắp xếp theo giá giảm dần");
            System.out.println("7. Sửa sản phẩm theo id");
            System.out.println("8. Thoát");
            System.out.print("Chọn chức năng: ");

            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case DISPLAY:
                    System.out.println("---- Danh sách sản phẩm ----");
                    List<Product> productList = this.productService.getAllProducts();
                    for (Product p : productList) {
                        System.out.println(p);
                    }
                    break;

                case ADD:
                    System.out.println("---- Thêm sản phẩm ----");
                    System.out.print("Nhập id: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    System.out.print("Nhập tên: ");
                    String name = scanner.nextLine();
                    System.out.print("Nhập giá: ");
                    double price = Double.parseDouble(scanner.nextLine());
                    System.out.println("Nhập hãng sản xuất: ");
                    String manufacturer =scanner.nextLine();
                    System.out.println("Nhập mô tả sản phẩm: ");
                    String description = scanner.nextLine();

                    productService.addProduct(new Product(id, name, price,manufacturer,description));
                    System.out.println("Thêm mới thành công");
                    break;

                case DELETE:
                    System.out.println("---- Xoá sản phẩm ----");
                    System.out.print("Nhập id sản phẩm cần xoá: ");
                    int deleteId = Integer.parseInt(scanner.nextLine());
                    productService.deleteProduct(deleteId);
                    break;
                case FIND:
                    System.out.println("---- Tìm kiếm sản phẩm ----");
                    System.out.print("Nhập id sản phẩm cần tìm: ");
                    int findId = Integer.parseInt(scanner.nextLine());
                    Product found = productService.findById(findId);
                    if (found != null) {
                        System.out.println(found);
                    } else {
                        System.out.println(" Không có sản phẩm ");
                    }
                    break;


                case SORT_ASC:
                    System.out.println("---- Sắp xếp giá tăng dần ----");
                    productService.sortByPriceAscending();
                    for (Product p : productService.getAllProducts()) {
                        System.out.println(p);
                    }
                    break;
                case EDIT:
                    System.out.println("---- Sửa sản phẩm ----");
                    System.out.print("Nhập id sản phẩm cần sửa: ");
                    int editId = Integer.parseInt(scanner.nextLine());

                    Product existingProduct = productService.findById(editId);
                    if (existingProduct != null) {
                        System.out.println("Nhập thông tin mới cho sản phẩm:");
                        Product updatedProduct = ProductView.inputDataForProduct();
                        updatedProduct.setId(editId);

                        productService.updateProduct(editId, updatedProduct);
                        System.out.println("Cập nhật thành công!");
                    } else {
                        System.out.println("Không tìm thấy sản phẩm với id: " + editId);
                    }
                    break;
                case SORT_DESC:
                    System.out.println("---- Sắp xếp giá giảm dần ----");
                    productService.sortByPriceDescending();
                    for (Product p : productService.getAllProducts()) {
                        System.out.println(p);
                    }
                    break;

                default:
                    flag = false;
                    System.out.println("Thoát chương trình!");
            }
        }
    }
}
