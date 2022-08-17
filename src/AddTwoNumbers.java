/**
 * 两数相加
 * <p>
 * 就是数学运算，因为结果是反转的，所以计算的时候也是反着算没有问题，刚刚好
 *
 * @author kundy
 * @date 2022/8/17 09:00
 */
public class AddTwoNumbers {

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


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode tmpHeadL1 = l1;
        ListNode tmpHeadL2 = l2;
        ListNode head = null;
        ListNode tail = null;
        // 进位
        int carry = 0;

        while (tmpHeadL1 != null || tmpHeadL2 != null) {

            int l1Val = tmpHeadL1 == null ? 0 : tmpHeadL1.val;
            int l2Val = tmpHeadL2 == null ? 0 : tmpHeadL2.val;

            int sum = l1Val + l2Val + carry;
            int curRes = sum >= 10 ? sum % 10 : sum;

            // 啊！怎么将新链表连起来啊
            if (head == null) {
                head = new ListNode(curRes);
                tail = head;
            } else {
                tail.next = new ListNode(curRes);
                tail = tail.next;
            }

            tmpHeadL1 = tmpHeadL1 == null ? null : tmpHeadL1.next;
            tmpHeadL2 = tmpHeadL2 == null ? null : tmpHeadL2.next;

            carry = sum / 10;
        }

        // 最后的进位要补上
        if (carry > 0) {
            tail.next = new ListNode(carry);
        }

        return head;
    }

}
