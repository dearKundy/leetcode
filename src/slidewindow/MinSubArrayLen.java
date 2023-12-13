package slidewindow;

/**
 * 滑动窗口-长度最小的子数组
 * 遍历窗口的尾部，如果窗口内的和大于等于目标值，则更新最小长度，然后缩小窗口的左边界，直到窗口内的和小于目标值
 * 【遍历窗口尾部，符合预期更新结果，并且移动左窗口，看看还有没有其他同样符合预期的结果】
 *
 * @author kundy
 * @date 2023/11/19 10:12
 */
public class MinSubArrayLen {

    public int minSubArrayLen(int target, int[] nums) {

        int res = Integer.MAX_VALUE;
        int left = 0;
        int sum = 0;

        // 注意，这里是移动窗口的尾部
        for (int i = 0; i < nums.length; i++) {

            sum += nums[i];
            while (sum >= target) {
                res = Math.min(res, i - left + 1);
                sum -= nums[left];
                left++;
            }

        }

        return res == Integer.MAX_VALUE ? 0 : res;


    }

    // minSubArrayLen 单元测试
    public static void main(String[] args) {

        int[] nums = {2, 3, 1, 2, 4, 3};
        int target = 7;
        int res = new MinSubArrayLen().minSubArrayLen(target, nums);
        System.out.println(res);

    }

}
