package Interfacedemo;
/*
interface Action {
    void execute();
}

class Some implements Action {
    void execute() {
        System.out.println("do something");
    }
}
public class InterfaceModifier {
    public static void main(String[] args) {
        Action action = new Some();
        action.execute();
    }
}
*/
//当我们想在一个Java文件里定义多个类的时候，肯定只有一个public类，此时可以定义一个没有用的Main()类，里面专门放main()方法
//这里由于没有public的Some会给本身public的execute赋错误的private权限，编译不会通过