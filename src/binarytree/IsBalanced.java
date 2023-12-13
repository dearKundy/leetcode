package binarytree;

/**
 * 平衡二叉树
 *
 * @author kundy
 * @date 2023/12/1 17:13
 */
public class IsBalanced {

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

    public boolean isBalanced(TreeNode root) {
        return getHeight(root) != -1;
    }

    public int getHeight(TreeNode root) {

        if (root == null) {
            return 0;
        }

        // 递归获取左子树的高度
        int leftHeight = getHeight(root.left);
        // 如果此时的左子树已经不平衡了，直接返回-1，不用继续了
        if (leftHeight == -1) {
            return -1;
        }

        // 递归获取右子树的高度
        int rightHeight = getHeight(root.right);
        // 如果此时的右子树已经不平衡了，直接返回-1，不用继续了
        if (rightHeight == -1) {
            return -1;
        }

        // 如果一旦发现不平衡了，直接返回 -1，不用再算具体的数高度了
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }

        // 计算树高度
        return Math.max(leftHeight, rightHeight) + 1;
    }

}
