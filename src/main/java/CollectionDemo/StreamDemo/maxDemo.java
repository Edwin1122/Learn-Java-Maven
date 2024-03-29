package CollectionDemo.StreamDemo;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class maxDemo {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("adnm", "admmt", "pot", "xbangd", "weoujgsd");

        Optional<String> max = list.stream().max(Comparator.comparing(String::length));
        System.out.println("最长的字符串：" + max.get());
    }
}