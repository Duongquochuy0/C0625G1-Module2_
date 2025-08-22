package ss17_io_binary_file.bai_tap.quan_ly_san_pham.repository;

import ss17_io_binary_file.bai_tap.quan_ly_san_pham.entity.Product;

import java.util.Comparator;

public class SortByPriceDescending implements Comparator<Product> {
    @Override
    public int compare(Product o1, Product o2) {
        return Integer.compare((int) o2.getPrice(), (int) o1.getPrice());
    }

}
