/**
 * 48. 旋转图像
 *
 * @author kundy
 * @date 2022/9/1 22:21
 */
public class Rotate {

    /**
     * 使用辅助数组
     */
    public void rotate(int[][] matrix) {

        int row = matrix.length;
        int col = matrix[0].length;
        int[][] newMatrix = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
//                newMatrix[i][j] = matrix[j][row - i - 1];
                newMatrix[j][row - i - 1] = matrix[i][j];
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrix[i][j] = newMatrix[i][j];
            }
        }

    }

    /**
     * 翻转代替旋转【水平翻转+主对角线翻转】
     */
    public void rotate2(int[][] matrix) {

        int row = matrix.length;
        int col = matrix[0].length;

        // 水平翻转【因为是swap，所以对半】
        for (int i = 0; i < row / 2; i++) {
            for (int j = 0; j < col; j++) {
                // swap
                int tmp = matrix[row - i - 1][j];
                matrix[row - i - 1][j] = matrix[i][j];
                matrix[i][j] = tmp;
            }
        }

        // 主对角线翻转【swap，斜下方部分进行swap】
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < i; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }

    }

}
