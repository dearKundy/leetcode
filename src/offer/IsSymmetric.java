package offer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 对称的二叉树
 * <p>
 * 为什么要一边offer一边pull呢？因为这样就可以保证下一个需要操作的元素就是队头，免去了维护当前指针的复杂性
 *
 * @author kundy
 * @date 2022/4/28 8:33 AM
 */
public class IsSymmetric {

    public static void main(String[] args) {
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isSymmetric(TreeNode root) {

        if (root == null) {
            return true;
        }

        return recur(root.left, root.right);
    }

    /**
     * 这里要从节点的角度去思考这个递归，不能从整棵树的角度出发
     */
    public boolean recur(TreeNode left, TreeNode right) {

        // 左右都为空，对称
        if (left == null && right == null) {
            return true;
        }
        // 能走到这儿，证明左右肯定有一个不为空，那么此时其中一个为空，则不对称。另外，如果左右节点的值不相等，则不对称。
        if (left == null || right == null || left.val != right.val) {
            return false;
        }

        // 左孩子的左节点要与右孩子的右节点相等
        boolean leftSymmetric = recur(left.left, right.right);
        // 左孩子的右节点要与右孩子的左节点相等
        boolean rightSymmetric = recur(left.right, right.left);

        // 左右节点都相等，则对称
        return leftSymmetric && rightSymmetric;

    }

}
