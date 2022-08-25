/**
 * 23. 合并K个升序链表【人生第一次不看题解 AC 的 困难题目】
 *
 * @author kundy
 * @date 2022/8/23 21:54
 */
public class MergeKLists {


    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        new MergeKLists().mergeKLists(null);
    }

    public ListNode mergeKLists(ListNode[] lists) {

        if (lists.length <= 0) {
            return null;
        }

        ListNode res = lists[0];

        for (int i = 1; i < lists.length; i++) {
            res = this.mergeTwoLists(res, lists[i]);
        }

        return res;
    }

    public ListNode mergeTwoLists(ListNode node1, ListNode node2) {

        ListNode head1 = node1;
        ListNode head2 = node2;
        ListNode resHead = null;
        ListNode resTail = new ListNode();

        while (head1 != null || head2 != null) {

            int data1 = head1 == null ? Integer.MAX_VALUE : head1.val;
            int data2 = head2 == null ? Integer.MAX_VALUE : head2.val;
            int curData = 0;

            if (data1 <= data2 && head1 != null) {
                curData = data1;
                head1 = head1.next;
            } else {
                curData = data2;
                head2 = head2.next;
            }

            // 添加元素到结果链表
            if (resHead == null) {
                resHead = new ListNode(curData);
                resTail = resHead;
            } else {
                resTail.next = new ListNode(curData);
                resTail = resTail.next;
            }
        }

        return resHead;
    }

}
