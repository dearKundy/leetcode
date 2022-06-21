package stock;

/**
 * 122. 买卖股票的最佳时机 II【可以买卖无数次】
 *
 * @author kundy
 * @date 2022/5/26 15:24
 */
public class Stock122 {

    public int maxProfit(int[] prices) {

        // 定义dp数组
        // dp[i][0] -> 第i天交易结束后，未持有股票的最大利润
        // dp[i][1] -> 第I天交易结束后，持有股票的最大利润
        int[][] dp = new int[prices.length][2];

        // 初始化dp数组
        // 第1天，未持有股票，利润为0
        dp[0][0] = 0;
        // 第1天，持有股票，利润为-prices[0]
        dp[0][1] = -prices[0];

        // 循环
        for (int i = 1; i < prices.length; i++) {
            // 未持有最大利润，当天交易结束之后，未持有，要么昨天就没有持有，要么昨天持有，今天卖出了。
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            // 持有最大利润，当天交易结束之后，持有，要么昨天就持有，要么今天买进。
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }

        // 最后一天，不持有任何股票肯定比持有股票利润大（只要股票的价格是正的，卖出多少能收回一点资金）
        return dp[prices.length - 1][0];

    }

}
