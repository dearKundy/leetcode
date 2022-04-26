package offer;

/**
 * 合并两个排序的链表
 *
 * @author kundy
 * @date 2022/4/26 9:24 PM
 */
public class MergeTwoLists {

    public static void main(String[] args) {
    }

    public ListNode go(ListNode l1, ListNode l2) {

        // 伪头节点，保存头结点，因为实际的头结点会随着循环的进行而丢失
        ListNode dum = new ListNode(0);
        ListNode l3 = dum;

        // l1或者l2其中一个为空时，退出，此时大概率是没有遍历完全的，下面有解决方案
        while (l1 != null && l2 != null) {

            if (l1.val <= l2.val) {
                l3.next = l1;
                l1 = l1.next;
            } else {
                l3.next = l2;
                l2 = l2.next;
            }
            // l3要向前移动一位
            l3 = l3.next;
        }

        // 当前的结果直接指向不为空的链表即将，因为一个链表已经遍历完成了，而另外一个链表剩余的元素肯定都比遍历完成的链表大，直接接上
        l3.next = l1 == null ? l2 : l1;

        // 返回伪头结点的next
        return dum.next;
    }


    public class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
