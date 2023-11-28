package offer;

import java.util.*;

/**
 * 从上到下打印二叉树 II【与I不同的是，我们不能一直从队列中poll了，而是要记录下来每一轮要poll出来几个元素，对结果进行切割】
 * 借助队列实现层序遍历
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

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> res = new ArrayList<>();
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        // 每一层的节点数量
        int curLevelNodeNum = 1;

        // 遍历队列
        while (!queue.isEmpty()) {

            List<Integer> tmpList = new ArrayList<>();
            // 这一层应该遍历多少个节点
            for (int i = 0; i < curLevelNodeNum; i++) {
                TreeNode poll = queue.poll();

                // 当前节点加入结果集合
                tmpList.add(poll.val);
                // 当前节点的左右节点加入队列，从而实现一层一层地遍历
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
            }

            if (tmpList.size() > 0) {
                res.add(tmpList);
            }
            curLevelNodeNum = queue.size();

        }

        return res;

    }

}
