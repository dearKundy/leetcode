/**
 * 152. 乘积最大子数组
 *
 * @author kundy
 * @date 2022/6/13 20:45
 */
public class MaxProduct {

    public static void main(String[] args) {
        System.out.println(new MaxProduct().maxProduct(new int[]{0, 2}));
    }

    public int maxProduct(int[] nums) {

        // dp[i][0]=从最左边一个元素起到nums[i]这个元素的最大乘积
        // dp[i][1]=从最左边一个元素起到nums[i]这个元素的最小乘积
        int[][] dp = new int[nums.length][2];

        dp[0][0] = nums[0];
        dp[0][1] = nums[0];

        int res = nums[0];

        for (int i = 1; i < nums.length; i++) {
            // 乘 or 不乘
            dp[i][0] = nums[i] > 0 ? Math.max(dp[i - 1][0] * nums[i], nums[i]) : Math.max(dp[i - 1][1] * nums[i], nums[i]);
            dp[i][1] = nums[i] > 0 ? Math.min(dp[i - 1][1] * nums[i], nums[i]) : Math.min(dp[i - 1][0] * nums[i], nums[i]);

            res = Math.max(res, dp[i][0]);
        }

        return res;
    }

    public void way2(int[] nums) {

        int[][] dp = new int[2][2];
        int res = nums[0];

        for (int i = 1; i < nums.length; i++) {

            // 0 1 0 1 0 1
            int x = i % 2;
            // 1 0 1 0 1 0
            int y = (i - 1) % 2;

            // 每次循环，我们只需要上一次的结果，所以长度为的数组
            // 取三者中最大的一个
            dp[x][0] = Math.max(dp[y][0] * nums[i], Math.max(dp[y][1] * nums[i], nums[i]));
            dp[x][1] = Math.min(dp[y][0] * nums[i], Math.min(dp[y][1] * nums[i], nums[i]));

            res = Math.max(res, dp[x][0]);
        }
    }

}
