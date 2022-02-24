package DataStructure.sort;

import java.text.SimpleDateFormat;
import java.util.Date;

public class InsertionSort {

    /*Function to sort array using insertion sort*/
    void sort(int arr[])
    {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;

            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
//            printArray(arr);
        }
    }

    /* A utility function to print array of size n*/
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");

        System.out.println();
    }

    // Driver method
    public static void main(String args[])
    {
//        int arr[] = { 14, 12, 11, 13, 5, 6 };
        int[] arr = new int[80000];
        for (int i =0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 8000000);
        }

        System.out.println("排序前：");
        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(date1);
        System.out.println("排序前的时间：" + date1Str);

        InsertionSort ob = new InsertionSort();
        ob.sort(arr);

        Date date2 = new Date();
        String date2Str = simpleDateFormat.format(date1);
        System.out.println("排序后的时间：" + date2Str);

//        printArray(arr);
    }
}
