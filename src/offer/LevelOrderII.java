package offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 从上到下打印二叉树 II【与I不同的是，我们不能一直从队列中poll了，而是要记录下来每一轮要poll出来几个元素，对结果进行切割】
 *
 * @author kundy
 * @date 2022/4/29 5:55 PM
 */
public class LevelOrderII {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> go(TreeNode root) {

        if (root == null) {
            return new ArrayList<>();
        }

        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();

        queue.offer(root);

        while (!queue.isEmpty()) {

            //【关键点】 根据当前queue的大小，决定这一轮要poll多少个元素出来
            int currentSize = queue.size();
            List<Integer> tmpResult = new ArrayList<>();
            for (int i = 0; i < currentSize; i++) {
                TreeNode poll = queue.poll();
                if (poll != null) {
                    tmpResult.add(poll.val);
                    if (poll.left != null) {
                        queue.offer(poll.left);
                    }
                    if (poll.right != null) {
                        queue.offer(poll.right);
                    }
                }
            }

            result.add(tmpResult);

        }

        return result;

    }

}
