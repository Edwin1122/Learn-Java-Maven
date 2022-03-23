package CollectionDemo.hashCodeDemo;

import java.util.Objects;

public class hashCodeDemo {

    // 科学设计了hashCode的类
    static class GoodExample {
        private String name;
        private int age;

    public GoodExample(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, age);
        }
    }

    // 不科学的hashCode写法
    static class BadExample {
        private String fakeName;
        private int age;

    public BadExample(String fakeName, int age) {
            this.fakeName = fakeName;
            this.age = age;
        }

        @Override
        public int hashCode() {
            // 这里我们没有用
            return fakeName.hashCode();
        }
    }
}
