package ss11_map_set.bai_tap.quan_ly_san_pham.repository;

import ss11_map_set.bai_tap.quan_ly_san_pham.entity.Product;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ProductRepository implements IProductRepository {
    private List<Product> productList = new ArrayList<>();

    {
        Product product1 = new Product(1, "Iphone 15 ",17 );
        Product product2 = new Product(2,"Iphone 15 Pro",20);
        Product product4 = new Product(4,"Iphone 15 Plus",18);
        Product product3 = new Product(3,"Iphone 15 ProMax",23);
        productList.add(product1);
        productList.add(product2);
        productList.add(product3);
        productList.add(product4);
    }
    @Override
    public void addProduct(Product product) {
        productList.add(product);
    }

    @Override
    public void updateProduct(int id, Product newProduct) {
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId() == id) {
                productList.set(i, newProduct);
                return;
            }
        }
        System.out.println("Không tìm thấy sản phẩm có id: " + id);
    }

    @Override
    public void deleteProduct(int id) {
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId() == id) {
                productList.remove(i);
                System.out.println("Đã xóa sản phẩm có id: " + id);
                return;
            }
        }
        System.out.println("Không tìm thấy sản phẩm có id: " + id);
    }

    @Override
    public List<Product> getAllProducts() {
        return productList;
    }

    @Override
    public Product findById(int id) {
        for (Product p : productList) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    @Override
    public void sortByPriceAscending() {
        productList.sort(new Comparator<Product>() {
            @Override
            public int compare(Product p1, Product p2) {
                return (int) (p1.getPrice() - p2.getPrice());
            }
        });
    }


    @Override
    public void sortByPriceDescending() {
        productList.sort(new Comparator<Product>() {
            @Override
            public int compare(Product p1, Product p2) {
                return (int) (p2.getPrice() - p1.getPrice());
            }
        });
    }
}