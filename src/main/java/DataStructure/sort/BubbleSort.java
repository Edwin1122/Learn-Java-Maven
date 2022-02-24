package DataStructure.sort;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BubbleSort {

    public static void main(String[] args) {
//        int arr[] = {3, 9, -1, 10, 20};
//
//        bubbleSort(arr);
//
//        System.out.println(Arrays.toString(arr));

        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 80000); //生成一个[0, 8000000) 数
        }

        Date startTime = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String startTimeString = simpleDateFormat.format(startTime);
        System.out.println("before: " + startTimeString);

        bubbleSort(arr);

        Date endTime = new Date();
        String endTimeString = simpleDateFormat.format(endTime);
        System.out.println("after: " + endTimeString);


    }


    // 冒泡排序 的时间复杂度 O(n^2), 自己写出

    public static void bubbleSort(int[] arr) {
        int temp = 0;

        boolean flag = false; //是否进行过交换

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j+1]) {
                    flag = true;
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }

            if (!flag) { // 在一趟排序中，一次交换都没有发生过
                break;
            } else {
                flag = false; // 重置flag!!!, 进行下次判断
            }
        }


    }
}
