package furama_manage.comparator;

import furama_manage.entity.Booking;

import java.util.Comparator;

public class BookingComparator implements Comparator<Booking> {
    @Override
    public int compare(Booking b1, Booking b2) {
        // So sánh theo ngày bắt đầu
        int result = b1.getNgayBatDau().compareTo(b2.getNgayBatDau());

        // Nếu ngày bắt đầu trùng nhau, so sánh theo ngày kết thúc
        if (result == 0) {
            result = b1.getNgayKetThuc().compareTo(b2.getNgayKetThuc());
        }

        return result;
    }
}

