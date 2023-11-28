import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树的前序遍历-栈实现
 *
 * @author kundy
 * @date 2023/11/27 20:05
 */
public class PreorderTraversal {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    // 中左右
    public List<Integer> preorderTraversal(TreeNode root) {

        if (root == null) {
            return new ArrayList<>();
        }

        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();

        // 初始化stack
        stack.push(root);

        while (!stack.isEmpty()) {

            // 当前出栈元素加入结果列表
            TreeNode pop = stack.pop();

            if (pop == null) {
                continue;
            }
            res.add(pop.val);

            // 每pop出一个节点，需要把左右节点入栈（先右后左，因为栈是后进先出），从而实现了无论是从局部还是整体，都是先处理完中间节点，再处理左节点，最后处理右节点
            // 实质上就是手动模拟递归的压栈过程
            stack.push(pop.right);
            stack.push(pop.left);

        }


        return res;

    }


}
