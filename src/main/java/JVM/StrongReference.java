package JVM;

public class StrongReference {

        public static void main(String[] args) {
            //强引用
            Student student = new Student();
            //中断强引用
            student = null;
            //手动调用GC
            System.gc();
        }

}

class Student {
    //Java Object finalize() 方法用于实例被垃圾回收器回收的时触发的操作 JVM不保证此方法总被调用
    @Override
    protected void finalize() throws Throwable {
        System.out.println("Student 被回收了");
    }
}
