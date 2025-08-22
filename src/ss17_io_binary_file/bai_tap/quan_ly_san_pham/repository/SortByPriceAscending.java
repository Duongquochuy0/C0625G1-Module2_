package ss17_io_binary_file.bai_tap.quan_ly_san_pham.repository;

import ss17_io_binary_file.bai_tap.quan_ly_san_pham.entity.Product;

import java.util.Comparator;

public class SortByPriceAscending implements Comparator<Product> {


    @Override
    public int compare(Product o1, Product o2) {
        return (int) (o1.getPrice() - o2.getPrice());
    }
}
