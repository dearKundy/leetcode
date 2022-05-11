package offer;

import java.util.HashMap;
import java.util.Map;

/**
 * 复制复杂链表
 * <p>
 * 最直观的想法：
 * 1. 先遍历一遍原链表，可以把next指针问题解决。
 * 但是随机指针呢？再遍历一遍原始链表也无法解决随机指针的问题，因为原链表与复制链表没有对应关系
 * <p>
 * 所以，重点就是要解决原链表与复制链表的对应关系问题
 *
 * @author kundy
 * @date 2022/5/11 2:12 PM
 */
public class CopyRandomList {

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    /**
     * 哈希表
     */
    public Node wayOne(Node head) {
        Map<Node, Node> nodeMap = new HashMap<>();

        Node tmpHead = head;
        // 构建原链表->复制链表对应关系
        while (tmpHead != null) {
            nodeMap.put(tmpHead, new Node(tmpHead.val));
            tmpHead = tmpHead.next;
        }

        tmpHead = head;
        while (tmpHead != null) {
            // 构建 next 指针，错误示范：nodeMap.get(tmpHead).next = tmpHead.next，注意我们是需要将复制链表中零散的元素关联起来
            nodeMap.get(tmpHead).next = nodeMap.get(tmpHead.next);
            // 构建随机指针
            nodeMap.get(tmpHead).random = nodeMap.get(tmpHead.random);

            tmpHead = tmpHead.next;
        }

        return nodeMap.get(head);
    }

    /**
     * 拼接+拆分
     */
    public Node wayTwo(Node head) {

        if (head == null) {
            return null;
        }

        // 1. 构建拼接链表
        Node tmpHead = head;
        while (tmpHead != null) {
            Node tmp = new Node(tmpHead.val);
            tmp.next = tmpHead.next;
            tmpHead.next = tmp;
            tmpHead = tmp.next;
        }

        // 2. 构建新节点的random指针
        tmpHead = head;
        while (tmpHead != null) {
            if (tmpHead.random != null) {
                tmpHead.next.random = tmpHead.random.next;
            }
            // 跳过复制节点
            tmpHead = tmpHead.next.next;
        }

        // 3. 拆分链表

        // 保留复制链表头节点
        Node res = head.next;

        Node originHead = head;
        Node copyHead = head.next;
        // 退出条件一定是要copyHead.next不等于，而不能是originHead.next不等于空，因为copyHead.next不等于空证明还存在原始节点
        while (copyHead.next != null) {
            originHead.next = originHead.next.next;
            copyHead.next = copyHead.next.next;

            // 错误示范：originHead = originHead.next.next;【这样实质上跳了三步】
            originHead = originHead.next;
            copyHead = copyHead.next;
        }

        // 恢复原链表尾指针
        originHead.next = null;

        return res;
    }


}
