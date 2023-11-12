/**
 * 11. 双指针-盛最多水的容器
 * <p>
 * 两个柱能围成的最大面积取决于短的那根柱子
 * 如果移动短的那根柱子，围成的面积有可能变大（因为短柱有可能变长）
 * 如果移动长的那根柱子，围成为面积一定变小（因为短柱没动，就算原先的长柱变长（不影响，因为最大面积取决于短柱），而宽度变窄了，所以面积一定变小。【如果长柱子变短了字段就更加短了】）
 * <p>
 * 综上所述，从左右两边开始，移动每一轮【短】的那根柱子，计算每一轮的面积，然后取最大面积
 *
 * @author kundy
 * @date 2022/8/17 20:33
 */
public class MaxArea {

    public int maxArea(int[] height) {


        int left = 0;
        int right = height.length - 1;
        int res = 0;
        while (left < right) {

            // 计算当前这轮的面积
            res = Math.max(res, (right - left) * Math.min(height[left], height[right]));

            // 移动短柱
            if (height[left] < height[right]) {
                left++;
            }
            else {
                right--;
            }

        }

        return res;

    }

}
