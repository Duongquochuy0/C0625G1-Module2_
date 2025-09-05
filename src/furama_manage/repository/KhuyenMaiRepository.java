package furama_manage.repository;

import furama_manage.entity.Booking;
import furama_manage.entity.KhuyenMai;

import java.time.LocalDate;
import java.util.*;

public class KhuyenMaiRepository {
    private static final Set<Booking> bookingSet = new TreeSet<>();

    static {
        bookingSet.addAll(new BookingRepository().getAllBookings());
    }

    public Set<String> getCustomersByYear(int year) {
        Set<String> customers = new TreeSet<>();
        for (Booking b : bookingSet) {
            if (b.getNgayBatDau().getYear() == year || b.getNgayKetThuc().getYear() == year) {
                customers.add(b.getMaKhachHang());
            }
        }
        return customers;
    }

    public List<String> getCustomersInCurrentMonth() {
        List<String> customers = new ArrayList<>();
        int currentMonth = LocalDate.now().getMonthValue();
        int currentYear = LocalDate.now().getYear();

        for (Booking b : bookingSet) {
            if (b.getNgayBatDau().getMonthValue() == currentMonth &&
                    b.getNgayBatDau().getYear() == currentYear) {
                customers.add(b.getMaKhachHang());
            }
        }
        return customers;
    }

    public Stack<KhuyenMai> distributeVouchers(int v10, int v20, int v50) {
        List<Booking> list = new ArrayList<>(bookingSet);
        Collections.sort(list);

        Stack<KhuyenMai> stack = new Stack<>();
        int total = v10 + v20 + v50;

        if (list.size() < total) {
            System.out.println("Số khách hàng booking < tổng số voucher. Chỉ phát cho " + list.size() + " khách.");
            total = list.size();
        }

        for (int i = list.size() - 1; i >= list.size() - total; i--) {
            String c = list.get(i).getMaKhachHang();
            if (v10 > 0) {
                stack.push(new KhuyenMai(c, "10%"));
                v10--;
            } else if (v20 > 0) {
                stack.push(new KhuyenMai(c, "20%"));
                v20--;
            } else if (v50 > 0) {
                stack.push(new KhuyenMai(c, "50%"));
                v50--;
            }
        }
        return stack;
    }
}
