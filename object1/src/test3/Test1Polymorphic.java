package test3;

class Animal {
    public void eat(){
        System.out.println("动物吃饭");
    }
}

class Cat extends Animal {
    @Override
    public void eat() {
        System.out.println("猫吃鱼");
    }
}

public class Test1Polymorphic {
    /*
        多态的前提:

            1. 要有(继承 \ 实现)关系
            2. 要有方法重写
            3. 要有父类引用, 指向子类对象
     */
    public static void main(String[] args) {
        Animal a = new Cat();//向上转型
        a.eat();

    }
}
