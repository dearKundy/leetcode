/**
 * 300. 最长递增子序列
 *
 * @author kundy
 * @date 2022/6/21 22:07
 */
public class LengthOfLIS {

    public int lengthOfLIS(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }

        // dp[5]=从第0个元素到底5个元素，的最长增长子序列的长度【第5个要选上】
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int res = 1;

        for (int i = 0; i < nums.length; i++) {
            // 每个位置的最长子序列都有可能是1
            dp[i] = 1;

            int tmpMax = 1;
            // 第i个位置的最长子序列长度是 `前面` 所有位置的最长子序列 中的最大值
            for (int j = 0; j < i; j++) {
                // 当前要求解的元素必须要比 nums[j] 大，要不然就不是递增序列了，也就是说，要求到最终的解，也必须是从比num[i]小对应的解中得来
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }

        return res;

    }

}
