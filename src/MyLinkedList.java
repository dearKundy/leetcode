/**
 * 链表
 *
 * @author kundy
 * @date 2022/3/28 10:27 PM
 */
public class MyLinkedList {

    class Node {

        // 下一节点的引用
        Node next = null;

        // 结点的值
        int data;

        public Node(int element) {
            data = element;
        }

    }

    /**
     * 头结点
     */
    Node head;

    /**
     * 往链表尾部添加元素
     */
    public int addNode(int element) {

        // 初始化头结点
        if (head == null) {
            head = new Node(element);
            return element;
        }

        Node tmpHead = head;
        while (tmpHead.next != null) {
            tmpHead = tmpHead.next;
        }

        tmpHead.next = new Node(element);

        return element;
    }

    /**
     * 删除第index个节点
     */
    public boolean deleteNode(int index) {

        if (head == null) {
            throw new RuntimeException("链表为空");
        }

        if (index == 0) {
            head = head.next;
            return true;
        }

        int currentPos = 1;
        Node tmpPre = head;
        Node tmpHead = head.next;
        while (tmpHead.next != null && currentPos != index) {
            currentPos++;
            tmpPre = tmpHead;
            tmpHead = tmpHead.next;
        }

        tmpPre.next = tmpHead.next;
        return true;

    }

    /**
     * 反转链表【将每个节点指向前驱结点，每次只处理一个节点，用pre指针保存前驱结点信息，用after指针保存后继节点信息】
     */
    public void reverse() {

        if (head == null) {
            throw new RuntimeException("链表为空");
        }

        Node tmpPre = null;
        // 这里不能用一个指针代替head，因为head是确实要被一直置换，直到成为反转之后的头结点，如果使用指针代替，那么在下面引用后移中 tmpHead=tmpAfter，就会失去了和head的关联，导致head断开
//        Node tmpHead = head;
        Node tmpAfter = head.next;

        while (tmpAfter != null) {

            // 反转指针
            head.next = tmpPre;

            // 引用后移
            tmpPre = head;
            head = tmpAfter;
            tmpAfter = tmpAfter.next;

        }

        // 记得反转最后一个节点
        head.next = tmpPre;

    }

    /**
     * 找出链表中间结点【快慢指针，快指针一次走两步，慢指针一次走一步，当快指针走完时，慢指针刚好到达中间节点】
     */
    public Node findMid() {

        Node fast = head;
        Node slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

    /**
     * 倒数第k个结点【两个指针，快指针先走（k-1）步，然后两个指针同时往后移动，当第一个结点到达末尾的时候，第二个结点所在位置就是倒数第k个节点了】
     * 倒数第k个数，其实就是与尾部距离为K的元素，那么我们先让两个指针一开始就差距K，当快指针到达尾部的时候，与尾部相距K的不就恰巧是慢指针了
     */
    public Node findToTail(int k) {

        Node fast = head;
        Node slow = head;

        // 快指针先走 K-1 步
        for (int i = 0; i < k - 1; i++) {
            fast = fast.next;
        }

        // 一起走，直到快指针走到尽头
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }

    /**
     * 删除重复节点【由于给定的链表是排好序的，因此重读的元素在链表中出现的位置是连续的，因此我们只需要对链表进行一次遍历，就可以删除重复的元素】
     */
    public void deleteDuplicate() {

        if (head == null) {
            throw new RuntimeException("链表为空");
        }

        Node tmpHead = head;
        while (tmpHead.next != null) {

            if (tmpHead.data == tmpHead.next.data) {
                tmpHead.next = tmpHead.next.next;
            } else {
                tmpHead = tmpHead.next;
            }
        }

    }

    /**
     * 递归打印链表【从头到尾】
     */
    public void printListRecursionHeadToTail(Node tmpHead) {
        if (tmpHead == null) {
            return;
        }
        System.out.println(tmpHead.data);
        printListRecursionHeadToTail(tmpHead.next);
    }

    /**
     * 递归打印链表【从尾到头】
     */
    public void printListRecursionTailToHead(Node tmpHead) {

        if (tmpHead == null) {
            return;
        }

        printListRecursionTailToHead(tmpHead.next);
        System.out.println(tmpHead.data);

    }

    /**
     * 是否有环【使用快慢指针，就像两个人赛跑且一个人跑得快一个人跑得慢。如果赛道是直的，那么快人跑到终点时慢人还未到；如果赛道是环形，则快人和慢人总会相遇】
     */
    public Boolean isLoop() {

        Node fast = head;
        Node slow = head;

        boolean isLoop = false;

        while (fast.next != null && fast.next.next != null) {

            // 先跑
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                isLoop = true;
                break;
            }
        }

        return isLoop;
    }

    /**
     * 找出链表环的入口【在确定链表有环之后，慢指针重新指向链表头，快指针留在相遇处；然后快慢指针再以每次移动1个节点的速度前进，最终他们在入环节点相遇。】
     */
    public Node findLoopPort() {

        Node fast = head;
        Node slow = head;

        boolean isLoop = false;

        while (fast.next != null && fast.next.next != null) {

            // 先跑
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                isLoop = true;
                break;
            }
        }

        if (!isLoop) {
            return null;
        }

        // slow回到起点
        slow = head;

        // 再次相遇
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }

    /**
     * 返回链表的长度
     */
    public int length() {

        if (head == null) {
            return 0;
        }

        int length = 1;
        Node tmpHead = head;
        while (tmpHead.next != null) {
            length++;
            tmpHead = tmpHead.next;
        }

        return length;
    }

    /**
     * 打印链表
     */
    public void printList() {
        Node tmpHead = head;
        while (tmpHead != null) {
            System.out.print(tmpHead.data + " ");
            tmpHead = tmpHead.next;
        }
    }

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addNode(1);
        myLinkedList.addNode(2);
        myLinkedList.addNode(2);
        myLinkedList.addNode(4);
        myLinkedList.addNode(5);

//        myLinkedList.deleteNode(3);

//        myLinkedList.reverse();

//        System.out.println(myLinkedList.findMid().data);
//        System.out.println(myLinkedList.findToTail(1).data);
//        System.out.println(myLinkedList.findToTail(2).data);
//        System.out.println(myLinkedList.findToTail(3).data);
//        System.out.println(myLinkedList.findToTail(4).data);

//        myLinkedList.deleteDuplicate();

        myLinkedList.printListRecursionTailToHead(myLinkedList.head);


    }

}
