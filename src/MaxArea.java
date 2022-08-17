/**
 * 11. 盛最多水的容器
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
            // 若向内 移动短板，下个水槽的面积 可能增大 。
            // 若向内 移动长板 ，因此下个水槽的面积 一定变小 。（短板变短或者不变，但是宽变窄了）
            // 所以只能移动短板
            res = height[left] < height[right] ? Math.max(res, (right - left) * height[left++]) : Math.max(res, (right - left) * height[right--]);
        }

        return res;

    }

}
