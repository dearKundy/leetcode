package offer;

/**
 * 割绳子
 * <p>
 * 其实就是暴力穷举，穷举所有的方案（当然动态规划可以复用已经算出来的结果），再从所有的方案中取最优的【in my opinion】
 * <p>
 * 我们想要求长度为n的绳子剪掉后的最大乘积，可以从前面比n小的绳子转移而来
 * 【长度为i的绳子，剪一出一根长度为j的绳子，是否全局最优，取决于 i-j 长度的最优解，】
 *
 * @author kundy
 * @date 2022/4/22 3:08 PM
 */
public class CuttingRope {

    public static int go(int n) {

        // 定义 dp 数组，表示将长度为n的绳子，剪成m段的最大值。为什么数组的长度为n+1呢？
        // 因为长度为n的数组索引只能到n-1，如果我们要使用到dp[n]，那么数组的长度就需要定义成n+1
        int[] dp = new int[n + 1];

        // 初始化 dp 数组
        dp[2] = 1;

        // 当绳子的长度为3、4 ... n 时，从3开始，因为如果为2，直接可以返回结果了
        for (int i = 3; i <= n; i++) {
            // 分别减去长度为 2、3、4... i 时，减去的长度不能比绳子本身还长，且要比1大
            for (int j = 2; j < i; j++) {
                // 为什么还要和 dp[i] 取 max呢，因为这样才能保证一轮下来，dp[i]取的是每一轮中的最大值
                // j * (i - j)：剪完j长度之后，剩下的不剪
                //  j * dp[i - j])：剪完j长度之后，剩下的继续剪
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
            }
        }

        return dp[n];

    }

    public static void main(String[] args) {
        System.out.println(go(2));
        System.out.println(go(10));
    }

}
