package DataStructure.linkedlist;

public class Josepfu {
    public static void main(String[] args) {
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.addBoy(125);//加入125个小孩节点
//        circleSingleLinkedList.showBoy();

        //测试一把小孩出圈是否正确
        circleSingleLinkedList.countBoy(10, 20, 125); // 2->4->1->5->3

    }
}


class CircleSingleLinkedList {

    //链表头指针 标记链表的头
    private  Boy first = new Boy(-1);

    //添加特定数量的小孩
    public void addBoy(int num) {
        if (num < 1) {
            System.out.println("Wrong num");
        }
        //通过一个指针 总是指向环形链表的最后一个位置
        Boy curBoy = null;

        for (int i = 1; i <= num; i++) {
            Boy boy = new Boy(i);

            //if the first boy
            if(i == 1) {
                first = boy;
                first.setNext(first);
                curBoy = first;
            } else {
                curBoy.setNext(boy);
                boy.setNext(first);
                curBoy = boy;
            }
        }
    }

    public void showBoy() {
        if (first == null) {
            System.out.println("no boy here.");
            return;
        }

        Boy curBoy = first;
        while (true) {
            System.out.printf("Boy's no: %d \n", curBoy.getNo());
            if(curBoy.getNext() == first) {
                break;
            }
            curBoy = curBoy.getNext();
        }
    }

    /**
     *
     * @param startNo 表示从第几个小孩开始数数
     * @param countNum 表示数几下
     * @param total 表示最初有多少小孩在圈中
     */
    public void countBoy(int startNo, int countNum, int total) {

        if (first == null || startNo < 1 || startNo > total) {
            System.out.println("参数输入有误， 请重新输入");
            return;
        }

        Boy helper = first;

        while (true) {
            if (helper.getNext() == first) {
                break;
            }
            helper = helper.getNext();
        }

        //小孩报数前，先让 first 和  helper 移动 startNo - 1次
        for (int j = 0; j < countNum - 1; j++) {
            first = first.getNext();
            helper = helper.getNext();
        }

        //当小孩报数时，让first 和 helper 指针同时 的移动  countNum  - 1 次, 然后出圈
        //这里是一个循环操作，直到圈中只有一个节点

        while (true) {
            if (helper == first) {  //说明圈中只有一个节点
                break;
            }

            //让 first 和 helper 指针同时 的移动 countNum - 1
            for (int j = 0; j < countNum - 1; j++) {
                first = first.getNext();
                helper = helper.getNext();
            }

            //此时first指向的节点，就是要出圈的小孩节点
            System.out.printf("小孩 %d 出圈\n", first.getNo());

            //这时将first指向的小孩节点出圈
            first = first.getNext();
            helper.setNext(first);
        }

        System.out.printf("最后留在圈中的小孩编号%d \n", first.getNo());
    }

}

class Boy {
    private  int no;
    private Boy next;

    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}
