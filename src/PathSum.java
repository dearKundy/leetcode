/**
 * 112. 路径总和
 *
 * @author kundy
 * @date 2023/12/7 11:35
 */
public class PathSum {

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

    public boolean hasPathSum(TreeNode root, int targetSum) {

        if (root == null) {
            return false;
        }

        // 这里先要减去根节点的值
        return recur(root, targetSum - root.val);
    }

    public boolean recur(TreeNode root, int targetSum) {

        // 如果一条路径已经走到底了，如果这条路径之等于 targetSum，此时的 targetSum是等于0的
        if (root.left == null && root.right == null && 0 == targetSum) {
            return true;
        }
        // 如果一条路径已经走到底了，但是 targetSum 不等于0，证明这条路径节点之和不等于 targetSum
        if (root.left == null && root.right == null) {
            return false;
        }

        // 先看左节点
        if (root.left != null) {
            // 已经遍历到左节点，当然是减去左节点的值，【如果已经是叶子节点，且路径符合，这里减完了左节点之后，targetNum就等于0了，下面继续递归，就可以返回true了】
            targetSum -= root.left.val;
            // 这里return会是整个堆栈一直return、return、return，且不往下走了，清醒一点弟弟
            if (recur(root.left, targetSum)) {
                return true;
            }
            // 回溯
            targetSum += root.left.val;
        }

        // 再看右节点
        if (root.right != null) {
            targetSum -= root.right.val;
            if (recur(root.right, targetSum)) {
                return true;
            }
            // 回溯
            targetSum += root.right.val;
        }

        return false;
    }

}
