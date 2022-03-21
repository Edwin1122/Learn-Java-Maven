package CollectionDemo.StreamDemo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class reduceDemo {
    public static void main(String[] args) {
//        List<Person> personList = new ArrayList<Person>();
//        personList.add(new Person("Tom", 8900, 23, "male", "New York"));
//        personList.add(new Person("Jack", 7000, 25, "male", "Washington"));
//        personList.add(new Person("Lily", 7800, 21, "female", "Washington"));
//        personList.add(new Person("Anni", 8200, 24, "female", "New York"));
//        personList.add(new Person("Owen", 9500, 25, "male", "New York"));
//        personList.add(new Person("Alisa", 7900, 26, "female", "New York"));
//
//        // 求工资之和方式1：
//        Optional<Integer> sumSalary = personList.stream().map(Person::getSalary).reduce(Integer::sum);
//
//        // 求工资之和方式2：
//        Integer sumSalary2 = personList.stream()
//                .reduce(0, (sum, p) -> sum += p.getSalary(), (sum1, sum2) -> sum1 + sum2);
//
//        // 求工资之和方式3：
//        Integer sumSalary3 = personList.stream().reduce(0, (sum, p) -> sum += p.getSalary(), Integer::sum);
//
//        // 求最高工资方式1：
//        Integer maxSalary = personList.stream().reduce(0, (max, p) -> max > p.getSalary() ? max : p.getSalary(),
//                Integer::max);
//
//        // 求最高工资方式2：
//        Integer maxSalary2 = personList.stream().reduce(0, (max, p) -> max > p.getSalary() ? max : p.getSalary(),
//                (max1, max2) -> max1 > max2 ? max1 : max2);
//
//        System.out.println("工资之和：" + sumSalary.get() + "," + sumSalary2 + "," + sumSalary3);
//        System.out.println("最高工资：" + maxSalary + "," + maxSalary2);

        String str1 = new String("hello");
        String str2 = new String("hello");
        String str3 = "hello";
        String str4 = "hello";

        System.out.println(str4.hashCode());
        System.out.println(str3.hashCode());
        System.out.println(str2.hashCode());

        if (str2 == str4) {
//        if (str1.equals(str4)) {
            System.out.println("equal");
        } else {
            System.out.println("not equal");
        }



//        String a = "200";
//        String b = "200";
//
//        if(a.equals(b)){
//            System.out.println("Equal variables:");
//            System.out.println(a.hashCode() + "\n" + b.hashCode());
//        }
//
//        String c = "10";
//        String d = "50";
//
//        if(!c.equals(d)){
//            System.out.println("\nUn-equal variables:");
//            System.out.println(c.hashCode() + "\n" + d.hashCode());
//        }

    }
}