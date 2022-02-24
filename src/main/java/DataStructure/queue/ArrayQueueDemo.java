package DataStructure.queue;

import java.util.Scanner;

public class ArrayQueueDemo {
    public static void main(String[] args) {

    ArrayQueue queue = new ArrayQueue(3);
    char key = ' ';

    Scanner scanner = new Scanner(System.in);
    boolean loop = true;

    while(loop) {
        System.out.println("s(show): 显示队列");
        System.out.println("e(exit): 退出程序");
        System.out.println("a(add): 添加数据到队列");
        System.out.println("g(get): 从队列取出数据");
        System.out.println("h(head): 查看队列头的数据");

        key = scanner.next().charAt(0);
        switch (key) {
            case 's':
                queue.showQueue();
                break;
            case 'a':
                System.out.println("Please input a number: ");
                int value = scanner.nextInt();
                queue.aadQueue(value);
                break;
            case 'g':
                try {
                    int res = queue.getQueue();
                    System.out.printf("The data is %d\n", res);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                break;
            case 'h':
                try {
                    int res = queue.headQueue();
                    System.out.printf("The head data is %d\n", res);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                break;
            case 'e':
                scanner.close();
                loop = false;
                break;
            default:
                break;
        }
    }
        System.out.println("Exited.");
    }

}

class ArrayQueue {
    private int maxSize; // 表示数组的最大容量
    private int front; // 队列头
    private int rear; // 队列尾
    private int[] arr; // 该数据用于存放数据, 模拟队列

    public ArrayQueue(int arrMaxSize) {
        maxSize  = arrMaxSize;
        arr = new int[maxSize];
        front = -1;
        rear = -1;
    }

    public boolean isFull () {
        return rear == maxSize - 1;
    }

    public boolean isEmpty () {
        return  rear == front;
    }

    public void aadQueue(int n) {
        if (isFull()) {
            System.out.println("队列已满");
            return;
        }
        rear++;
        arr[rear] = n;
    }

    // 获取队列的数据, 出队列
    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列空, 不能取数据");
        }
        front++;
        return arr[front];
    }

    public void showQueue() {
        if(isEmpty()) {
            System.out.println("Empty queue, nothing to show");
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d]=%d\n", i, arr[i]);
        }
    }

    // 显示队列的头数据， 注意不是取出数据
    public int headQueue () {
        if(isEmpty()) {
            throw new RuntimeException("Empty queue, nothing to show");
        }
        return arr[front + 1];
    }

}