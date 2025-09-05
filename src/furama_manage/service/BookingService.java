package furama_manage.service;

import furama_manage.entity.Booking;
import furama_manage.entity.Contract;
import furama_manage.repository.BookingRepository;
import furama_manage.repository.HopDongRepository;

import java.util.List;
import java.util.Set;
import java.util.UUID;

public class BookingService implements IBookingService {
    private final BookingRepository bookingRepository;
    private final HopDongRepository hopDongRepository;

    public BookingService(BookingRepository bookingRepository, HopDongRepository hopDongRepository) {
        this.bookingRepository = bookingRepository;
        this.hopDongRepository = hopDongRepository;
    }

    @Override
    public void addNewBooking(Booking booking) {
        if (bookingRepository.getAllBookings().contains(booking)) {
            System.out.println("Lỗi: Booking với mã " + booking.getMaBooking() + " đã tồn tại.");
            return;
        }
        bookingRepository.addNewBooking(booking);
        System.out.println("Đã thêm booking mới thành công.");
    }

    private static int contractCounter = 1;
    @Override
    public void createContractFromQueue() {
        Booking earliestBooking = bookingRepository.getEarliestBooking();

        if (earliestBooking != null) {
            System.out.println("Đang tạo hợp đồng cho booking sớm nhất: " + earliestBooking.getMaBooking());
            String contractId = String.format("HD-%04d", contractCounter++);

            Contract contract = new Contract(
                    contractId,
                    earliestBooking.getMaBooking(),
                    earliestBooking.getMaKhachHang(),
                    earliestBooking.getMaDichVu()
            );
            hopDongRepository.addContract(contract);
            System.out.println("Đã tạo và lưu hợp đồng thành công với mã: " + contractId);
        } else {
            System.out.println("Không còn booking nào trong hàng đợi để tạo hợp đồng.");
        }
    }

    @Override
    public void displayAllBookings() {
        Set<Booking> allBookings = bookingRepository.getAllBookings();
        if (allBookings.isEmpty()) {
            System.out.println("Hiện không có booking nào trong hệ thống.");
            return;
        }
        System.out.println("--- DANH SÁCH TẤT CẢ BOOKING ---");
        for (Booking booking : allBookings) {
            System.out.println(booking);
        }
        System.out.println("-----------------------------------");
    }

    @Override
    public void displayAllContracts() {
        List<Contract> allContracts = hopDongRepository.getAllContracts();
        if (allContracts.isEmpty()) {
            System.out.println("Hiện không có hợp đồng nào được tạo.");
            return;
        }
        System.out.println("--- DANH SÁCH TẤT CẢ HỢP ĐỒNG ĐÃ TẠO ---");
        for (Contract contract : allContracts) {
            System.out.println(contract);
        }
        System.out.println("-----------------------------------");
    }
}
