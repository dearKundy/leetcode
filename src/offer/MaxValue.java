package offer;

/**
 * 剑指 Offer 47. 礼物的最大价值
 * <p>
 * 将原矩阵 grid用作 dp 矩阵，即直接在 grid 上修改即可。
 *
 * @author kundy
 * @date 2022/8/10 21:35
 */
public class MaxValue {

    public static void main(String[] args) {
        System.out.println(new MaxValue().maxValue(new int[][]
                {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}}));
    }

    public int maxValue(int[][] grid) {

        int row = grid.length;
        int col = grid[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {

                // 起点
                if (i == 0 && j == 0) {
                    continue;
                }

                // 首行，最大值只能从左边来
                if (i == 0) {
                    grid[i][j] = grid[i][j - 1] + grid[i][j];
                    continue;
                }

                // 首列，最大值只能从上边来
                if (j == 0) {
                    grid[i][j] = grid[i - 1][j] + grid[i][j];
                    continue;
                }

                grid[i][j] = Math.max(grid[i][j - 1], grid[i - 1][j]) + grid[i][j];


            }
        }

        return grid[row - 1][col - 1];


    }


}
