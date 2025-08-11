package ss6_ke_thua.bai_tap.bai_1;

public class Cylinder extends Circle {
    private double height;
    public Cylinder() {
    }
    public Cylinder(double radius, String color, double height){
        super(radius, color);
        this.height =height;
    }
    public double getHeight() {
        return height;
    }
    public void setHeight(double height) {
        this.height = height;
    }
    public double getVolume(){
        return getArea()*height;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", height=" + height +
                ", volume=" + getVolume();
    }
}
