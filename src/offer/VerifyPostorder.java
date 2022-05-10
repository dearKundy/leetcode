package offer;

/**
 * 二叉搜索树的后序遍历序列
 *
 * @author kundy
 * @date 2022/5/10 8:00 PM
 */
public class VerifyPostorder {

    public static void main(String[] args) {
        System.out.println(verifyPostorder(new int[]{1, 3, 2, 6, 5}));
    }

    public static boolean verifyPostorder(int[] postorder) {
        return verify(postorder, 0, postorder.length - 1);
    }

    /**
     * 校验是否是二叉搜索树
     *
     * @param left  待校验数组左端点
     * @param right 待校验数组右端点
     */
    public static boolean verify(int[] postorder, int left, int right) {

        if (right <= left) {
            return true;
        }

        int root = postorder[right];
        int currentPos = left;
        int leftRightBoundary;

        // 确定左子树边界
        while (postorder[currentPos] < root) {
            currentPos++;
        }
        leftRightBoundary = currentPos;

        // 校验右子树
        while (postorder[currentPos] > root) {
            currentPos++;
        }

        // 注意右半部分的右端点是 right-1，因为right是根节点，不需要再参与校验，我们只需要继续校验我们所划分出来的左右子树是否是二叉搜索树即可
        return currentPos == right && verify(postorder, left, leftRightBoundary - 1) && verify(postorder, leftRightBoundary, right - 1);
    }

}
