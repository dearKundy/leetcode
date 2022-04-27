package offer;

/**
 * 二叉树的镜像
 *
 * @author kundy
 * @date 2022/4/27 5:43 PM
 */
public class MirrorTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public TreeNode mirrorTree(TreeNode root) {

        if (root == null) {
            return null;
        }

        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        // 递归
        mirrorTree(root.left);
        mirrorTree(root.right);

        return root;
    }

}
