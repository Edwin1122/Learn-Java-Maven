package CollectionDemo;

import java.util.LinkedList;
import java.util.List;

public class ListToArrayDemo {
    public static void main(String[] args) {
        List<Integer> list= new LinkedList<>();
        System.out.println("List of odd numbers in our list.");
        for (int i=1;i<=10;i++) {
            list.add(i);
        }


        Integer[] a = new Integer[5];
        //把list放到一个a这样的数组里
        Integer[] b =  list.toArray(a);

//  针对数组转list, 可以学习以下固定写法
//        List<String> list1 = Arrays.asList("item11", "item12", "item13", "item14");
//        List<String> list2 = Arrays.asList("item21", "item22", "item23", "item24");
//        List<String> list3 = Arrays.asList("item31", "item32", "item33", "item34");
//
//        List<List<String>> listOfLists = Arrays.asList(list1, list2, list3);

        for (int i = 0; i <b.length; i++) {
            if (b[i] %2!=0) {
                System.out.println(b[i]+" ");
            }
        }
    }
}
