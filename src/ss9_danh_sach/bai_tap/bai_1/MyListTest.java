package ss9_danh_sach.bai_tap.bai_1;

public class MyListTest {
    public static class Student {
        private int id;
        private String name;

        public Student(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public Student() {
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
    }

    public static void main(String[] args) {
        Student a = new Student(1, "Huy1");
        Student b = new Student(2, "Huy2");
        Student c = new Student(3, "Huy3");
        Student d = new Student(4, "Huy4");
        Student e = new Student(5, "Huy5");
        MyList<Student> studentMyList = new MyList<>();
        MyList<Student> newArrayList = new MyList<>();
        studentMyList.add(a);
        studentMyList.add(b);
        studentMyList.add(c);
        studentMyList.add(d);
        studentMyList.add(e);
        studentMyList.size();
        System.out.println("Độ dài của List: ");
        System.out.println(studentMyList.size());
        for (int i = 0; i < studentMyList.size(); i++) {
            Student student = (Student) studentMyList.elements[i];
            System.out.println(student.getId());
            System.out.println(student.getName());
        }
        studentMyList.get(2);
        System.out.println(studentMyList.get(2).getName());
        System.out.println(studentMyList.indexOf(d));
        System.out.println(studentMyList.contains(c));
        newArrayList = studentMyList.clone();
        newArrayList.remove(0);
        for (int i = 0; i < newArrayList.size(); i++) {
            System.out.println(newArrayList.get(i).getName());
        }
    }
}
