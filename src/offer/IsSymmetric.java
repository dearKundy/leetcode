package offer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 对称的二叉树
 * <p>
 * 为什么要一边offer一边pull呢？因为这样就可以保证下一个需要操作的元素就是队头，免去了维护当前指针的复杂性
 *
 * @author kundy
 * @date 2022/4/28 8:33 AM
 */
public class IsSymmetric {

    public static void main(String[] args) {
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isSymmetric(TreeNode root) {

        if (root == null) {
            return false;
        }

        Queue<TreeNode> queue = new LinkedList<>();

        // 初始化队列，塞两个头结点进去
        queue.offer(root);
        queue.offer(root);

        while (!queue.isEmpty()) {

            // 每次推两个元素出来
            TreeNode node1 = queue.poll();
            TreeNode node2 = queue.poll();

            // 两者都为null，跳过
            if (node1 == null && node2 == null) {
                continue;
            }

            // 代码能够执行到这里，表明node1、node2至少有一个不为空
            // 那么当其中一个为空时，node1、node2必然不相等
            if (node1 == null || node2 == null) {
                return false;
            }

            // 两个节点的值不相等，退出
            if ((node1.val != node2.val)) {
                return false;
            }

            // 两个结点的左右子结点按相反的顺序插入队列中
            queue.offer(node1.left);
            queue.offer(node2.right);

            queue.offer(node1.right);
            queue.offer(node2.left);

        }


        return true;
    }

}
