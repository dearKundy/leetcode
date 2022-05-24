/**
 * 98. 验证二叉搜索树
 *
 * @author kundy
 * @date 2022/5/24 20:43
 */
public class IsValidBST {

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

    private long pre = Long.MIN_VALUE;

    public boolean isValidBST(TreeNode root) {

        if (root == null) {
            return true;
        }

        boolean left = isValidBST(root.left);

        if (root.val <= pre) {
            return false;
        }
        pre = root.val;

        boolean right = isValidBST(root.right);

        return left && right;
    }

}
