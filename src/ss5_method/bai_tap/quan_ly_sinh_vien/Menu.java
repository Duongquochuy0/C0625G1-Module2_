package ss5_method.bai_tap.quan_ly_sinh_vien;

import java.util.Scanner;

public class Menu {
    private StudentManager studentManager = new StudentManager();
    public void displayMainMenu(){
        Scanner scanner = new Scanner(System.in);
        final int DISPLAY = 1;
        final int ADD = 2;
        final int DELETE = 3;
        final int SEARCH = 4;
        boolean flag = true;
        while (flag) {
            System.out.println("Quản lý sinh viên");
            System.out.println("-------Chức năng------" +
                    "\n 1. Danh sách" +
                    "\n 2. Thêm mới" +
                    "\n 3. Xoá" +
                    "\n 4. Tìm kiếm" +
                    "\n 5. Thoát");

            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case DISPLAY:
                    System.out.println("----Đây là chức năng hiển thị----------");
                    Student[] students = this.studentManager.getAll();
                    for (Student student: students) {
                        System.out.println(student);
                    }
                    break;
                case ADD:
                    System.out.println("----Đây là chức năng thêm mới----------");
                    System.out.println("nhập id");
                    int id = Integer.parseInt(scanner.nextLine());
                    System.out.println("nhập tên");
                    String name = scanner.nextLine();
                    Student student = new Student(id,name);
                    studentManager.add(student);
                    System.out.println("- Thêm mới thành công");
                    break;
                case DELETE:
                    System.out.println("----Đây là chức năng xoá----------");
                    System.out.print("Nhập ID học sinh muốn xóa: ");
                    int deleteId = scanner.nextInt();
                    scanner.nextLine();
                    studentManager.deleteStudentById(deleteId);
                    break;
                case SEARCH:
                    System.out.println("----Đây là chức năng tìm kiếm----------");
                    System.out.println("Nhập id học sinh cần tìm kiếm: ");
                    int searchId = scanner.nextInt();
                    scanner.nextLine();
                    Student foundStudent = studentManager.findStudentById(searchId);
                    if (foundStudent != null) {
                        System.out.println("Tìm thấy: " + foundStudent);
                    } else {
                        System.out.println("Không tìm thấy học sinh có ID = " + searchId);
                    }
                    break;
                default:
                    flag = false;
            }
        }
    }
}
