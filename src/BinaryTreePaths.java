import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 257. 二叉树的所有路径
 *
 * @author kundy
 * @date 2023/12/6 10:39
 */
public class BinaryTreePaths {

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

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        recur(root, new LinkedList<>(), res);
        return res;
    }

    /**
     * 其实这个方法跟二叉树中的前序遍历是一样的，但是这里多了一个 path，这个path我们是一直复用的，所以在找到一个结果的时候，我们需要重置一下path，仅此而已【这就是回溯】
     *
     * @param root 当前待处理的节点
     * @param path 当前路径
     * @param res  结果
     */
    public void recur(TreeNode root, LinkedList<String> path, List<String> res) {

        // 当前处理的节点加入到path中，path用来记录一条可能的路径
        path.add(String.valueOf(root.val));

        // 当前这个节点如果既没有左孩子也没有右孩子，证明这条路径遍历到底了，可以将该path加入到结果集中了
        if (root.left == null && root.right == null) {
            res.add(formatPath(path));
        }

        // ----------------------------- 递归逻辑处理 -----------------------------
        // 实际的效果就是先遍历所有的左孩子，找到了一条路径，回溯。之后处理右孩子，找到了一条路径，回溯。这时候回溯就会导致父节点继续回溯
        // 回溯到父节点的父节点，从而会处理父节点的父节点的右孩子

        if (root.left != null) {
            // 对于每一颗树来说，先扫描完左孩子
            recur(root.left, path, res);
            // 回溯，这个节点走到底了，已经无路可走了，需要将path回退
            path.removeLast();
        }

        if (root.right != null) {
            // 对于每一颗树来说，扫描完左孩子之后就可以处理右孩子了
            recur(root.right, path, res);
            // 回溯，这个节点走到底了，已经无路可走了，需要将path回退
            path.removeLast();
        }

    }

    public String formatPath(List<String> path) {
        return String.join("->", path);
    }

}
