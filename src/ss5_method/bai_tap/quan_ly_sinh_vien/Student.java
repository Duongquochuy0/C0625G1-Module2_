package ss5_method.bai_tap.quan_ly_sinh_vien;

public class Student {
    private int id;
    String name;
    public static String school ="CodeGym";

    public Student() {

    }
    public Student(int id, String name) {
        this.id =id;
        this.name = name;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", school:" + school+
                '}';
    }
}
