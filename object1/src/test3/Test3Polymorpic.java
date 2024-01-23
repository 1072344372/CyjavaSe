package test3;

class Fu {
    public void show(){
        System.out.println("Fu..show...");
    }
}

class Zi extends Fu {
    @Override
    public void show() {
        System.out.println("Zi..show...");
    }

    public void method(){
        System.out.println("我是子类特有的方法, method");
    }
}

public class Test3Polymorpic {
    public static void main(String[] args) {
        // 1. 向上转型 : 父类引用指向子类对象
        Fu f = new Zi();
        f.show();
        // 多态的弊端: 不能调用子类特有的成员
        // f.method();

        // 2. 向下转型 : 从父类类型, 转换回子类类型
        Zi z = (Zi) f;
        z.method();
    }
}
