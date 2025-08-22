package ss17_io_binary_file.bai_tap.quan_ly_san_pham.service;


import ss17_io_binary_file.bai_tap.quan_ly_san_pham.entity.Product;

import java.util.List;

public interface IProductService {
    void addProduct(Product product);
    void updateProduct(int id, Product newProduct);
    void deleteProduct(int id);
    List<Product> getAllProducts();
    Product findById(int id);
    void sortByPriceAscending();
    void sortByPriceDescending();
}
