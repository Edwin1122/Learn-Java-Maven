package DataStructure.sort;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SelectionSort {

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

        selectionSort(arr);

        Date endTime = new Date();
        String endTimeString = simpleDateFormat.format(endTime);
        System.out.println("after: " + endTimeString);
    }
    
    public static void selectionSort(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {

            int minIndex = i;
            int min = arr[i];
        
            for (int j = 0; j < arr.length - 1; j++) {
                if (min > arr[j]) {
                    min = arr[j];
                    minIndex = j;
                }
            }

            if (minIndex != i) {
                arr[minIndex] = arr[i];//每一轮要交换的数的下标是固定的
                arr[i] = min;
            }

        }


        
    }
}
