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

            TreeNode pop = stack.pop();

            if (pop == null) {
                continue;
            }

            res.add(pop.val);

            stack.push(pop.right);
            stack.push(pop.left);

        }



        return res;

    }


}
