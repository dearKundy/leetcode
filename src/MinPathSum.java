/**
 * 64. 最小路径和
 *
 * @author kundy
 * @date 2022/9/6 22:19
 */
public class MinPathSum {

    public static void main(String[] args) {
        System.out.println(new MinPathSum().minPathSum(new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}}));
    }

    public int minPathSum(int[][] grid) {

        int row = grid.length;
        int col = grid[0].length;
        // dp[i][j] 走到[i,j]各自的最短路径
        int[][] dp = new int[row][col];
        dp[0][0] = grid[0][0];

        // 初始化第一行
        for (int i = 1; i < row; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }

        // 初始化第一列
        for (int j = 1; j < col; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }


        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                // 左侧或者上侧最短路径 + 当前格子的路径
                dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        return dp[row - 1][col - 1];
    }

}
