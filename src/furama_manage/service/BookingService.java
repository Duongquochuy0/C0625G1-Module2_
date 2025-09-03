package furama_manage.service;

import furama_manage.entity.Booking;
import furama_manage.entity.Contract;
import furama_manage.repository.BookingRepository;
import furama_manage.repository.HopDongRepository;

import java.util.List;
import java.util.Set;
import java.util.UUID;

public class BookingService {
    private final BookingRepository bookingRepository;
    private final HopDongRepository contractRepository;
    public BookingService(BookingRepository bookingRepository, HopDongRepository contractRepository) {
        this.bookingRepository = bookingRepository;
        this.contractRepository = contractRepository;
    }

    public void addNewBooking(Booking booking) {
        if (bookingRepository.getAllBookings().contains(booking)) {
            System.out.println("Lỗi: Booking với mã " + booking.getMaBooking() + " đã tồn tại.");
            return;
        }
        bookingRepository.addNewBooking(booking);
        System.out.println("Đã thêm booking mới thành công.");
    }

    public void createContractFromQueue() {
        Booking earliestBooking = bookingRepository.getEarliestBooking();

        if (earliestBooking != null) {
            System.out.println("Đang tạo hợp đồng cho booking sớm nhất: " + earliestBooking.getMaBooking());
            String contractId = "HD-" + UUID.randomUUID().toString().substring(0, 8);
            Contract contract = new Contract(
                    contractId,
                    earliestBooking.getMaBooking(),
                    earliestBooking.getMaKhachHang(),
                    earliestBooking.getMaDichVu()
            );
            contractRepository.addContract(contract);
            System.out.println("Đã tạo và lưu hợp đồng thành công với mã: " + contractId);
        } else {
            System.out.println("Không còn booking nào trong hàng đợi để tạo hợp đồng.");
        }
    }

    public void displayAllBookings() {
        Set<Booking> allBookings = bookingRepository.getAllBookings();
        if (allBookings.isEmpty()) {
            System.out.println("Hiện không có booking nào trong hệ thống.");
            return;
        }
        System.out.println("--- DANH SÁCH TẤT CẢ BOOKING ---");
        allBookings.forEach(System.out::println);
        System.out.println("-----------------------------------");
    }

    public void displayAllContracts() {
        List<Contract> allContracts = contractRepository.getAllContracts();
        if (allContracts.isEmpty()) {
            System.out.println("Hiện không có hợp đồng nào được tạo.");
            return;
        }
        System.out.println("--- DANH SÁCH TẤT CẢ HỢP ĐỒNG ĐÃ TẠO ---");
        allContracts.forEach(System.out::println);
        System.out.println("-----------------------------------");
    }
}
