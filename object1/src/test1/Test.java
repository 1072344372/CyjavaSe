package test1;


public class Test {
    public static void main(String[] args) {
        Cat cat = new Cat("小猫",2);
        cat.eat("猫粮");
        cat.run();
        Dog dog = new Dog("小猫",2);
        dog.eat("狗粮");
        dog.run();
    }
}
class Cat{
    private String name;
    private int age;

    public Cat() {
    }

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * 跑
     */
    public void run(){
        System.out.println(name+"在奔跑,速度是"+"3km/h...");
    }

    /**
     * 吃
     *
     * @param food 食物
     */
    public void eat(String food){
        System.out.println(name+"正在吃"+food);
    }
}
class Dog{
    private String name;
    private int age;

    public Dog() {
    }

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * 跑
     */
    public void run(){
        System.out.println(name+"在奔跑,速度是"+"5km/h...");
    }

    /**
     * 吃
     *
     * @param food 食物
     */
    public void eat(String food){
        System.out.println(name+"正在吃"+food);
    }
}