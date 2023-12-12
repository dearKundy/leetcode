/**
 * 617.合并二叉树
 *
 * @author kundy
 * @date 2023/12/11 18:35
 */
public class MergeTrees {

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

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {

        // 两个节点都为空不用合并了
        if (root1 == null && root2 == null) {
            return null;
        }

        int curVal = 0;
        // 都不为空，累加
        if (root1 != null && root2 != null) {
            curVal = root1.val + root2.val;
        }
        // 否则取不为空的那个
        else {
            curVal = root1 == null ? root2.val : root1.val;
        }

        TreeNode treeNode = new TreeNode(curVal);
        // 递归构建左右子树
        treeNode.left = mergeTrees(root1 == null ? null : root1.left, root2 == null ? null : root2.left);
        treeNode.right = mergeTrees(root1 == null ? null : root1.right, root2 == null ? null : root2.right);

        return treeNode;

    }

}
