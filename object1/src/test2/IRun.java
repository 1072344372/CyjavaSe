package test2;

/**
 * @author :罗汉
 * @date : 2024/1/17
 */
public interface IRun {
    public static void main(String[] args) {
        new Student().run();
        Car car = new Car();
        car.run();
        car.cry();
    }
    public String place = null;
    void run();
}
class Student implements IRun {

    @Override
    public void run() {
        System.out.println("学生正在跑步");
    }
}
class Car implements IRun,Cry {

    @Override
    public void run() {
        System.out.println("小汽车正在运行");
    }
    @Override
    public void cry() {System.out.println("嗡嗡嗡");}
}
interface Cry{ void cry();}