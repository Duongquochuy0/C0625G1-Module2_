package furama_manage.util;

import furama_manage.entity.Booking;

import java.util.Comparator;

public class BookingDateComparator implements Comparator<Booking> {
    @Override
    public int compare(Booking b1, Booking b2) {
        int result = b1.getNgayBatDau().compareTo(b2.getNgayBatDau());
        if (result == 0) {
            result = b1.getNgayKetThuc().compareTo(b2.getNgayKetThuc());
        }
        return result;
    }
}

