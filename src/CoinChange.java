import java.util.Arrays;

/**
 * 322. 零钱兑换
 *
 * @author kundy
 * @date 2022/6/21 22:35
 */
public class CoinChange {

    public static void main(String[] args) {
        System.out.println(new CoinChange().coinChange(new int[]{3, 5}, 11));
    }

    public int coinChange(int[] coins, int amount) {

        if (coins.length == 0 || amount == 0) {
            return 0;
        }

        // dp[i]=爬到底i级台阶，最少的步数
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {

            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i ){
                    // 上一步有可能是用 i- (coins[0...j]过来的)，这里我们选步数最少的
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }

            }
        }

        // 如果无解，则dp[i]不会被更新，总是amout+1
        return dp[amount] > amount ? -1 : dp[amount];
    }

}
