/**
 * 完全二叉树节点的数量
 *
 * @author kundy
 * @date 2023/12/1 15:10
 */
public class CountCompleteTreeNodes {

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

    public int countNodes(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int leftDepth = 0;
        int rightDepth = 0;
        TreeNode leftNode = root.left;
        TreeNode rightNode = root.right;

        // ----------------------- 退出条件 -----------------------

        // 计算左右子树的最小深度
        while (root.left != null) {
            leftDepth++;
            root.left = root.left.left;
        }
        while (root.right != null) {
            rightDepth++;
            root.right = root.right.right;
        }

        // 如果是满二叉树，可以计算结果啦
        // 如果该子树的左右子树的最小深度相等，则为满二叉树，是二叉树就利用公式计算节点数量
        if (leftDepth == rightDepth) {
            // 满二叉树，节点数量计算公式：2^n - 1
            // 这里的 leftDepth 要+1，因为该公式是从跟节点开始算深度，而 leftDepth 表示的是改子树的左节点做大深度
            return (int) Math.pow(2, leftDepth + 1) - 1;
        }

        //   ----------------------- 递归逻辑 -----------------------

        // 如果不是满二叉树，就继续递归，直到你是满二叉树为止（最终总得是一棵满二叉树）
        // 从总体上看，左子树的节点数+右子树的节点数 +1 =整棵树的节点数
        return countNodes(leftNode) + countNodes(rightNode) + 1;
    }


}
