package CollectionDemo.hashCodeDemo;

import java.util.Objects;

public class equalsDemo {

    // 重写了equals方法的类
    static class GoodExample {
        private String name;
        private int age;

        public GoodExample(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public boolean equals(Object o) {
            
            if (this == o) return true;//内存地址一样
            
            if (o == null || getClass() != o.getClass()) return false;//比较类型

            GoodExample that = (GoodExample) o;
            //比较值
            //注意这里使用了null安全的方法Objects.hashCode（注意不是Object而是java.util.Objects）方法
            return age == that.age && Objects.equals(name, that.name);
        }

    }

    // 没有重写equals方法的类
    static class BadExample {
        private String fakeName;
        private int age;

        public BadExample(String fakeName, int age) {
            this.fakeName = fakeName;
            this.age = age;
        }
    }

    public static void main(String[] args) {

        System.out.println(new GoodExample("Richard", 36).equals(new GoodExample("Richard", 36)));

        System.out.println(new BadExample("Richard", 36).equals(new BadExample("Richard", 36)));
    }
}
