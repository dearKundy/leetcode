package offer;

/**
 * 剑指 Offer 52. 两个链表的第一个公共节点
 *
 * @author kundy
 * @date 2022/8/15 20:42
 */
public class GetIntersectionNode {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        ListNode tmpHeadA = headA;
        ListNode tmpHeadB = headB;

        // 假设链表 headA 的不相交部分有 a 个节点，链表 headB 的不相交部分有 b 个节点，两个链表相交的部分有 c 个节点
        // 1. 假如两个链表相交，最终一定是在 a+b+c步之后相遇
        // 2. 如果两个链表不相交，两个指针会同时变成空值 null
        while (tmpHeadA != tmpHeadB) {

            if (tmpHeadA == null) {
                tmpHeadA = headB;
            } else {
                tmpHeadA = tmpHeadA.next;
            }

            if (tmpHeadB == null) {
                tmpHeadB = headA;
            } else {
                tmpHeadB = tmpHeadB.next;
            }

        }

        return tmpHeadA;
    }
}
