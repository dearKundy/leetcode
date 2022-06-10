import java.util.List;

/**
 * 120 三角形最小路径和
 *
 * @author kundy
 * @date 2022/6/9 22:40
 */
public class MinimumTotal {

    public int minimumTotal(List<List<Integer>> triangle) {

        // dp[i][i] = 从最下面一层走到 [i,j] 路径的最小值
        int[][] dp = new int[triangle.size()][triangle.size()];

        // 初始化dp数组
        List<Integer> lowestList = triangle.get(triangle.size() - 1);
        for (int i = 0; i < lowestList.size(); i++) {
            dp[triangle.size() - 1][i] = lowestList.get(i);
        }

        for (int i = triangle.size() - 2; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle.get(i).get(j);
            }
        }

        return dp[0][0];
    }

}
