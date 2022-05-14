package offer;

/**
 * 连续子数组的最大和
 *
 * @author kundy
 * @date 2022/5/14 12:37 PM
 */
public class MaxSubArray {

    public int maxSubArray(int[] nums) {

        // 定义dp数组 -> dp[i]=以nums[i]结尾的子数组的最大和
        int[] dp = new int[nums.length];

        // dp数组初始化
        dp[0] = nums[0];

        int res = nums[0];

        // dp数组遍历
        for (int i = 1; i < nums.length; i++) {
            // 递推公式
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            res = Math.max(res, dp[i]);
        }

        return res;

    }

}
