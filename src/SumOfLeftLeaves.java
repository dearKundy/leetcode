/**
 * 404.左叶子之和
 *
 * @author kundy
 * @date 2023/12/6 16:05
 */
public class SumOfLeftLeaves {

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

    public int sum = 0;

    public int sumOfLeftLeaves(TreeNode root) {
        recur(root);
        return sum;
    }

    public void recur(TreeNode root) {

        if (root == null) {
            return;
        }

        // 遇到叶子结点，累加左叶子结点的值
        if (root.left != null && root.left.left == null && root.left.right == null) {
            sum += root.left.val;
        }

        // 左右子树的左叶子结点之和就是整棵树的左叶子节点之和
        recur(root.left);
        recur(root.right);
    }

}
