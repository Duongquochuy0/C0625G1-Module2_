package ss17_io_binary_file.bai_tap.quan_ly_san_pham.repository;

import ss17_io_binary_file.bai_tap.quan_ly_san_pham.entity.Product;
import ss17_io_binary_file.bai_tap.quan_ly_san_pham.util.ReadAndWriteFile;

import java.util.Comparator;
import java.util.List;

public class ProductRepository implements IProductRepository {
    private final String PRODUCT_FILE = "src/ss17_io_binary_file/bai_tap/quan_ly_san_pham/data/fruit.dat";
    @Override
    public void addProduct(Product product) {
        List<Product> productList = ReadAndWriteFile.readListObjectFromDat(PRODUCT_FILE);
        productList.add(product);
        ReadAndWriteFile.writeListObjectToDat(PRODUCT_FILE, productList);
    }
    @Override
    public void updateProduct(int id, Product newProduct) {
        List<Product> productList = ReadAndWriteFile.readListObjectFromDat(PRODUCT_FILE);
        boolean found = false;
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId() == id) {
                productList.set(i, newProduct);
                found = true;
                break;
            }
        }
        if (found) {
            ReadAndWriteFile.writeListObjectToDat(PRODUCT_FILE, productList);
        } else {
            System.out.println("Không tìm thấy sản phẩm có id: " + id);
        }
    }
    @Override
    public void deleteProduct(int id) {
        List<Product> productList = ReadAndWriteFile.readListObjectFromDat(PRODUCT_FILE);
        boolean found = false;

        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId() == id) {
                productList.remove(i);
                found = true;
                break;
            }
        }
        if (found) {
            ReadAndWriteFile.writeListObjectToDat(PRODUCT_FILE, productList);
            System.out.println("Đã xóa sản phẩm có id: " + id);
        } else {
            System.out.println("Không tìm thấy sản phẩm có id: " + id);
        }
    }

    @Override
    public List<Product> getAllProducts() {
        return ReadAndWriteFile.readListObjectFromDat(PRODUCT_FILE);
    }
    @Override
    public Product findById(int id) {
        List<Product> productList = ReadAndWriteFile.readListObjectFromDat(PRODUCT_FILE);
        for (Product product : productList) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }


    @Override
    public void sortByPriceAscending() {
        List<Product> productList = ReadAndWriteFile.readListObjectFromDat(PRODUCT_FILE);
        productList.sort(new Comparator<Product>() {
            @Override
            public int compare(Product p1, Product p2) {
                return Double.compare(p1.getPrice(), p2.getPrice());
            }
        });

        ReadAndWriteFile.writeListObjectToDat(PRODUCT_FILE, productList);
    }

    @Override
    public void sortByPriceDescending() {
        List<Product> productList = ReadAndWriteFile.readListObjectFromDat(PRODUCT_FILE);
        productList.sort(new Comparator<Product>() {
            @Override
            public int compare(Product p1, Product p2) {
                return Double.compare(p2.getPrice(), p1.getPrice());
            }
        });
        ReadAndWriteFile.writeListObjectToDat(PRODUCT_FILE, productList);
    }


}
