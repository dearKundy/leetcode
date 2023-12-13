package binarytree;

/**
 * 翻转二叉树
 *
 * @author kundy
 * @date 2023/11/28 14:58
 */
public class InvertTree {

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

    public TreeNode invertTree(TreeNode root) {

        if (root == null) {
            return root;
        }

        // 反转左右孩子
        swap(root);
        // 对每一棵左孩子反转
        invertTree(root.left);
        // 对每一棵右孩子反转
        invertTree(root.right);

        return root;


    }

    /**
     * 交换当前节点的左右子树
     * 必须把node传进来，再交换左右孩子。不能直接把左右孩子传进来，再进行交换，这样会丢失引用
     */
    public void swap(TreeNode root) {
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }


}
