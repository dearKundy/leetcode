package binarytree;

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

    /**
     * 搜索树的特性就是左子树的值都小于根节点的值，右子树的值都大于根节点的值，所以这里我们在中序遍历的过程中，判断一下元素是不是单调递增即可
     */
    public boolean isValidBST(TreeNode root) {

        if (root == null) {
            return true;
        }

        if (!isValidBST(root.left)) {
            return false;
        }

        if (root.val <= pre) {
            return false;
        }

        // 判断完之后，将pre值置为当前节点的值
        pre = root.val;

        return isValidBST(root.right);

    }

}
