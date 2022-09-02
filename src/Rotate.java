/**
 * 48. 旋转图像
 *
 * @author kundy
 * @date 2022/9/1 22:21
 */
public class Rotate {

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

}
