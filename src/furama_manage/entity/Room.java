package furama_manage.entity;

public class Room extends CoSoVatChat {
    private String dichVuMienPhi;

    public Room() {
    }

    public Room(String dichVuMienPhi) {
        this.dichVuMienPhi = dichVuMienPhi;
    }

    public Room(String maDichVu, String tenDichVu, double dienTich, double chiPhi, int soLuongNguoi, String kieuThue, String dichVuMienPhi) {
        super(maDichVu, tenDichVu, dienTich, chiPhi, soLuongNguoi, kieuThue);
        this.dichVuMienPhi = dichVuMienPhi;
    }

    public String getDichVuMienPhi() {
        return dichVuMienPhi;
    }

    public void setDichVuMienPhi(String dichVuMienPhi) {
        this.dichVuMienPhi = dichVuMienPhi;
    }
    @Override
    public String toString() {
        return "--- Thông tin phòng ---\n" +
                super.toString() + "\n" +
                "Dịch vụ miễn phú: " + dichVuMienPhi;
    }
}
