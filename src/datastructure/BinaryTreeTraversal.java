package datastructure;

/**
 * 二叉树遍历
 *
 * @author kundy
 * @date 2022/4/11 5:50 PM
 */
public class BinaryTreeTraversal {

    class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;
    }

    /**
     * 先序遍历【根-左-右】
     */
    public void preOrder(TreeNode root) {

        if (root == null) {
            return;
        }

        System.out.println(root.data);
        preOrder(root.left);
        preOrder(root.right);
    }

    /**
     * 中序遍历【左-根-右】
     */
    public void inOrder(TreeNode root) {

        if (root == null) {
            return;
        }

        inOrder(root.left);
        System.out.println(root.data);
        inOrder(root.right);
    }

    /**
     * 后序遍历【左-右-根】
     */
    public void postOrder(TreeNode root) {

        if (root == null) {
            return;
        }

        inOrder(root.left);
        inOrder(root.right);
        System.out.println(root.data);

    }

}
