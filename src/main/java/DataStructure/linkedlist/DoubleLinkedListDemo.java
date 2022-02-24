package DataStructure.linkedlist;

public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        //进行测试
        //先创建节点
        DoubleLinkHeroNode hero1 = new DoubleLinkHeroNode(1, "宋江", "及时雨");
        DoubleLinkHeroNode hero2 = new DoubleLinkHeroNode(2, "卢俊义", "玉麒麟");
        DoubleLinkHeroNode hero3 = new DoubleLinkHeroNode(3, "吴用", "智多星");
        DoubleLinkHeroNode hero4 = new DoubleLinkHeroNode(4, "林冲", "豹子头");

        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.add(hero1);
        doubleLinkedList.add(hero2);
        doubleLinkedList.add(hero3);
        doubleLinkedList.add(hero4);

        doubleLinkedList.list();

        //update
        DoubleLinkHeroNode newHeroNode =  new DoubleLinkHeroNode(4, "公孙胜", "入云龙");
        doubleLinkedList.update(newHeroNode);

        System.out.println("List after modify: ");
        doubleLinkedList.list();

        doubleLinkedList.del(3);
        System.out.println("List after delete: ");
        doubleLinkedList.list();

    }
}

class DoubleLinkedList {
    private DoubleLinkHeroNode head = new DoubleLinkHeroNode(0, "", "");

    public DoubleLinkHeroNode getHead() {
        return head;
    }

    // 遍历双向链表的方法
    // 显示链表[遍历]
    public void list() {
        // 判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        // 因为头节点，不能动，因此我们需要一个辅助变量来遍历
        DoubleLinkHeroNode temp = head.next;
        while (true) {
            // 判断是否到链表最后
            if (temp == null) {
                break;
            }
            // 输出节点的信息
            System.out.println(temp);
            // 将temp后移， 一定小心
            temp = temp.next;
        }
    }

    // 添加一个节点到双向链表的最后.
    public void add(DoubleLinkHeroNode heroNode) {

        // 因为head节点不能动，因此我们需要一个辅助遍历 temp
        DoubleLinkHeroNode temp = head;
        // 遍历链表，找到最后
        while (true) {
            // 找到链表的最后
            if (temp.next == null) {//
                break;
            }
            // 如果没有找到最后, 将将temp后移
            temp = temp.next;
        }
        // 当退出while循环时，temp就指向了链表的最后
        // 形成一个双向链表
        temp.next = heroNode;
        heroNode.pre = temp;
    }

    // 修改一个节点的内容, 可以看到双向链表的节点内容修改和单向链表一样
    // 只是 节点类型改成 DoubleLinkHeroNode
    public void update(DoubleLinkHeroNode newHeroNode) {
        //判断是否空
        if(head.next == null) {
            System.out.println("链表为空~");
            return;
        }
        //找到需要修改的节点, 根据no编号
        //定义一个辅助变量
        DoubleLinkHeroNode temp = head.next;
        boolean flag = false; //表示是否找到该节点
        while(true) {
            if (temp == null) {
                break; //已经遍历完链表
            }
            if(temp.no == newHeroNode.no) {
                //找到
                flag = true;
                break;
            }
            temp = temp.next;
        }
        //根据flag 判断是否找到要修改的节点
        if(flag) {
            temp.name = newHeroNode.name;
            temp.nickname = newHeroNode.nickname;
        } else { //没有找到
            System.out.printf("没有找到 编号 %d 的节点，不能修改\n", newHeroNode.no);
        }
    }

    // 从双向链表中删除一个节点,
    // 说明
    // 1 对于双向链表，我们可以直接找到要删除的这个节点, 而不需要非要找到它的前一个节点
    // 2 找到后，自我删除即可
    public void del(int no) {

        if (head.next == null) {
            System.out.println("链表为空, 无法删除");
            return;
        }

        DoubleLinkHeroNode temp = head;
        boolean flag = false; // 标志是否找到待删除节点的
        while(true) {
            if (temp == null) { //已经到链表的最后
                break;
            }
            if(temp.no == no) {
                //找到的待删除节点的前一个节点temp
                flag = true;
                break;
            }
            temp = temp.next; //temp后移，遍历
        }
        //判断flag
        if (flag) { //找到
            //可以删除
            temp.pre.next = temp.next;

            //注意这里如果是最后一个节点, 可能会出现空指针异常
            if (temp.next != null) {
                temp.next.pre = temp.pre;
            }
        }else {
            System.out.printf("要删除的 %d 节点不存在\n", no);
        }
    }



}

class DoubleLinkHeroNode {
    public int no;
    public String name;
    public String nickname;
    public DoubleLinkHeroNode next; // 指向下一个节点, 默认为null
    public DoubleLinkHeroNode pre; // 指向前一个节点, 默认为null

    public DoubleLinkHeroNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "DoubleLinkHeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
