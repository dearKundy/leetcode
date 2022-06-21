package stock;

/**
 * 188. 买卖股票的最佳时机 IV【只能进行K笔交易（一买一卖算一笔交易）】
 *
 * @author kundy
 * @date 2022/6/15 20:53
 */
public class Stock188 {

    public static void main(String[] args) {
        System.out.println(new Stock188().maxProfit(2, new int[]{3, 2, 6, 5, 0, 3}));
    }

    public int maxProfit(int k, int[] prices) {

        if (prices.length == 0) {
            return 0;
        }

        int day = prices.length;
        // day天 `最多` 能进行 day/2 笔交易，最终的k取两者中较小者
        k = Math.min(k, day / 2);
        int res = 0;

        // dp[i][k][0] = 第i天刚好进行了k笔交易，且当天没有持有股票，最大利润
        // dp[i][k][1] = 第i天刚好进行了k笔交易，且当天持有股票，最大利润
        int[][][] dp = new int[day][k + 1][2];

        // 初始化dp数组
        for (int i = 1; i < k; i++) {
            // 第一天，能进行k>0笔交易的，都是非法数据
            dp[0][k][0] = Integer.MIN_VALUE / 2;
            dp[0][k][1] = Integer.MIN_VALUE / 2;
        }
        // 第一天，没有任何交易
        dp[0][0][0] = 0;
        // 第一天，买入一股
        dp[0][0][1] = -prices[0];

        for (int i = 1; i < day; i++) {
            // 第i天，持有股票，但是没有完成一笔交易的最大利润
            dp[i][0][1] = Math.max(dp[i - 1][0][1], dp[i - 1][0][0] - prices[i]);
            for (int j = 1; j <= k; j++) {
                // 不持有股票，要么当天卖掉了，要么前一天也没有【卖会导致j+1，促成一笔交易】
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j - 1][1] + prices[i]);
                // 持有股票，要么当天买入，要么前一天买入【买不会会导致j+1，因为没有促成一笔交易】
                dp[i][j][1] = Math.max(dp[i - 1][j][0] - prices[i], dp[i - 1][j][1]);

                res = Math.max(res, dp[i][j][0]);
            }
        }

        return res;

    }

}
