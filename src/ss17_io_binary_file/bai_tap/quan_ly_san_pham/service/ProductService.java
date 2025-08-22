package ss17_io_binary_file.bai_tap.quan_ly_san_pham.service;

import ss17_io_binary_file.bai_tap.quan_ly_san_pham.entity.Product;
import ss17_io_binary_file.bai_tap.quan_ly_san_pham.repository.IProductRepository;
import ss17_io_binary_file.bai_tap.quan_ly_san_pham.repository.ProductRepository;

import java.util.List;

public class ProductService implements IProductService {
    private final IProductRepository productRepository = new ProductRepository();

    @Override
    public void addProduct(Product product) {
        productRepository.addProduct(product);
    }

    @Override
    public void updateProduct(int id, Product newProduct) {
        productRepository.updateProduct(id, newProduct);
    }

    @Override
    public void deleteProduct(int id) {
        productRepository.deleteProduct(id);
    }
    @Override
    public List<Product> getAllProducts() {
        return productRepository.getAllProducts();
    }

    @Override
    public Product findById(int id) {
        return productRepository.findById(id);
    }


    public void sortByPriceAscending() {
        productRepository.sortByPriceAscending();
    }


    public void sortByPriceDescending() {
        productRepository.sortByPriceDescending();
    }
}
