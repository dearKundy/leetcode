/**
 * 62. 不同路径
 *
 * @author kundy
 * @date 2022/9/6 21:58
 */
public class UniquePaths {

    public int uniquePaths(int m, int n) {

        // dp[i][j] 表示 走到 [i,j] 格子一共有多少种路径
        int[][] dp = new int[m][n];

        // 第一列的所有格子，都只有一种路径
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }

        // 第一行的所有格子，都只有一种路径
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }

        // 注意 i、j 都是从1开始，因为上面已经初始化好了第一行、第一列
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                // 到达当前格子的路径数=到达上方格子的路径数+到达左侧格子的路径数
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m - 1][n - 1];

    }

}
