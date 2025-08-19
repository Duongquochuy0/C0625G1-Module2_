package ss11_map_set.bai_tap.quan_ly_san_pham.service;

import ss11_map_set.bai_tap.quan_ly_san_pham.entity.Product;


import java.util.List;

public interface IProductService {
    void addProduct(Product product);
    void updateProduct(int id, Product newProduct);
    boolean deleteProduct(int id);
    List<Product> getAllProducts();
    Product findById(int id);
    void sortByPriceAscending();
    void sortByPriceDescending();
}
