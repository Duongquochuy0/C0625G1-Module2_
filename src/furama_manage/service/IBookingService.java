package furama_manage.service;

import furama_manage.entity.Booking;

public interface IBookingService {
    void addNewBooking(Booking booking);

    void createContractFromQueue();

    void displayAllBookings();

    void displayAllContracts();
}
