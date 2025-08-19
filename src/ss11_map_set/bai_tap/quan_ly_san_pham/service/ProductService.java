package ss11_map_set.bai_tap.quan_ly_san_pham.service;

import ss11_map_set.bai_tap.quan_ly_san_pham.entity.Product;
import ss11_map_set.bai_tap.quan_ly_san_pham.repository.IProductRepository;
import ss11_map_set.bai_tap.quan_ly_san_pham.repository.ProductRepository;

import java.util.Comparator;
import java.util.List;

public class ProductService implements IProductService{
    private IProductRepository productRepository = new ProductRepository();
    @Override
    public void addProduct(Product product) {
        productRepository.addProduct(product);
    }

    @Override
    public void updateProduct(int id, Product newProduct) {
        productRepository.updateProduct(id, newProduct);
    }

    @Override
    public boolean deleteProduct(int id) {
        productRepository.deleteProduct(id);
        return false;
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.getAllProducts();
    }

    @Override
    public Product findById(int id) {
        return productRepository.findById(id);
    }

    @Override
    public void sortByPriceAscending() {
        List<Product> products = productRepository.getAllProducts();
        products.sort(new Comparator<Product>() {
            @Override
            public int compare(Product p1, Product p2) {
                return (int)(p1.getPrice() - p2.getPrice());
            }
        });
    }

    @Override
    public void sortByPriceDescending() {
        List<Product> products = productRepository.getAllProducts();
        products.sort(new Comparator<Product>() {
            @Override
            public int compare(Product p1, Product p2) {
                return (int)(p2.getPrice() - p1.getPrice());
            }
        });
    }
}
