package furama_manage.repository;

import furama_manage.entity.Booking;
import java.util.Set;

public interface IBookingRepository {
    void addNewBooking(Booking booking);

    Set<Booking> getAllBookings();

    void displayAllBookings();

    Booking getEarliestBooking();
}
