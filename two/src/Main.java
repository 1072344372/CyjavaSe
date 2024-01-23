/**
 * @author :罗汉
 * @date : 2024/1/6
 */
public class Main {
    public static void main(String[] args) {
        //例1
        Student student = new Student("张三");
        Student student2 = new Student("李四");
        System.out.println("初始化的student："+student.name);
        System.out.println("初始化的student2："+student2.name);
        System.out.println("-----------------------------------------");
        swap(student,student2);
        System.out.println("交换后的student："+student.name);
        System.out.println("交换后的student2："+student2.name);
        System.out.println("-----------------------------------------");

    }

    private static void swap(Student student, Student student2) {
        System.out.println("方法中交换前的student："+student.name);
        System.out.println("方法中交换前的student2："+student2.name);
        Student temp=student;
        student=student2;
        student2=temp;
        System.out.println("-----------------------------------------");
        System.out.println("方法中交换后的student："+student.name);
        System.out.println("方法中交换后的student2："+student2.name);
        System.out.println("-----------------------------------------");
    }
}

/**
 * 学生
 */
class Student{
   String name;

    public Student(String name) {
        this.name = name;
    }
}
