package binarytree;

/**
 * 654.最大二叉树
 *
 * @author kundy
 * @date 2023/12/8 10:36
 */
public class ConstructMaximumBinaryTree {

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

    // 测试 constructMaximumBinaryTree
    public static void main(String[] args) {

        int[] nums = {3, 2, 1, 6, 0, 5};
        ConstructMaximumBinaryTree constructMaximumBinaryTree = new ConstructMaximumBinaryTree();
        TreeNode root = constructMaximumBinaryTree.constructMaximumBinaryTree(nums);
        System.out.println(root);
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {

        return constructMaximumBinaryTree(nums, 0, nums.length - 1);
    }


    public TreeNode constructMaximumBinaryTree(int[] nums, int start, int end) {

        // 当 start == end 时，那个唯一的节点就是maxValue，没有左右孩子
        if (start > end) {
            return null;
        }

        int maxValue = 0;
        int maxIndex = 0;
        // 计算当前区间的最大值
        for (int i = start; i <= end; i++) {
            if (nums[i] >= maxValue) {
                maxValue = nums[i];
                maxIndex = i;
            }
        }

        TreeNode root = new TreeNode(maxValue);
        // 最大值的左区间构建左子树，区间不要取重复【maxIndex - 1】
        root.left = constructMaximumBinaryTree(nums, start, maxIndex - 1);
        // 最大值的右区间构建右子树，区间不要取重复【maxIndex + 1】
        root.right = constructMaximumBinaryTree(nums, maxIndex + 1, end);

        return root;

    }
}
