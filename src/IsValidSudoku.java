/**
 * 36. 有效的数独
 *
 * @author kundy
 * @date 2022/6/7 22:10
 */
public class IsValidSudoku {

    public static void main(String[] args) {
        System.out.println((int) '9');
        System.out.println((int) '1');
    }

    public boolean isValidSudoku(char[][] board) {

        // columns[1][3] = 第1列上数字3出现的次数
        int[][] columns = new int[9][9];
        // columns[1][3] = 第1行上数字3出现的次数
        int[][] rows = new int[9][9];
        // 将整个棋盘看做是一个 3*3的九宫格，subBoxes[1][1][4]=在第1行第1列的九宫格中出现数字4的次数
        int[][][] subBoxes = new int[3][3][9];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {

                if (board[i][j] != '.') {

                    // 溢出-1
                    int index = board[i][j] - '1';
                    columns[i][index]++;
                    rows[j][index]++;
                    subBoxes[i / 3][j / 3][index]++;

                    if (columns[i][index] > 1 || rows[j][index] > 1 || subBoxes[i / 3][j / 3][index] > 1) {
                        return false;
                    }

                }
            }
        }

        return true;
    }

}
