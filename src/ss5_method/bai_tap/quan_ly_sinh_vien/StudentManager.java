package ss5_method.bai_tap.quan_ly_sinh_vien;

public class StudentManager {
    private static Student[] studentList = new Student[100];

    static {
        Student student1 = new Student(1, "Dương Quốc Huy");
        Student student2 = new Student(2, "Nguyễn Văn B");
        studentList[0] = student1;
        studentList[1] = student2;
    }

    public Student[] getAll() {
        int count = 0;
        for (int i = 0; i < studentList.length; i++) {
            if (studentList[i] != null) {
                count++;
            } else {
                break;
            }
        }

        Student[] students = new Student[count];
        for (int i = 0; i < count; i++) {
            students[i] = studentList[i];
        }
        return students;
    }

    public void add(Student student) {
        for (int i = 0; i < studentList.length; i++) {
            if (studentList[i] == null) {
                studentList[i] = student;
                break;
            }
        }
    }
    public void deleteStudentById(int id) {
        for (int i = 0; i < studentList.length; i++) {
            if (studentList[i] != null && studentList[i].getId() == id) {
                for (int j = i; j < studentList.length - 1; j++) {
                    studentList[j] = studentList[j + 1];
                }
                studentList[studentList.length - 1] = null;
                System.out.println("Đã xóa học sinh có ID = " + id);
                return;
            }
        }
        System.out.println("Không tìm thấy học sinh có ID = " + id);
    }

    public Student findStudentById(int id) {
        for (int i = 0; i < studentList.length; i++) {
            if (studentList[i] != null && studentList[i].getId() == id) {
                return studentList[i];
            }
        }
        return null;
    }
}
