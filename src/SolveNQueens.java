import java.util.*;

/**
 * 51 N皇后
 *
 * @author kundy
 * @date 2022/6/8 16:31
 */
public class SolveNQueens {

    public static void main(String[] args) {
        new SolveNQueens().solveNQueens(4);
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        int[] queues = new int[n];
        Arrays.fill(queues, -1);
        bracktrack(res, queues, n, 0, new HashSet<>(), new HashSet<>(), new HashSet<>());
        return res;
    }

    /**
     * @param res       有多种解，每一种解是一个List<String>
     * @param n         棋盘大小 n*n
     * @param row       当前这个解决方案处理正在处理的行数
     * @param columns   columns.contain(1) 表示第1列放置了皇后
     * @param diagonal1 diagonal1.contain(1) 表示 row - n = 1的位置被皇后占据
     * @param diagonal2 diagonal2.contain(1) 表示 row + n = 1的位置被皇后占据
     */
    public void bracktrack(List<List<String>> res, int[] queues, int n, int row, Set<Integer> columns, Set<Integer> diagonal1, Set<Integer> diagonal2) {

        // 递归退出条件，row==n，证明每一行都能成功找到适合的位置放置皇后
        if (n == row) {
            res.add(generateBoard(queues, n));
        } else {

            // 遍历列
            for (int i = 0; i < n; i++) {

                if (columns.contains(i)) {
                    continue;
                }

                if (diagonal1.contains(row - i)) {
                    continue;
                }

                if (diagonal2.contains(row + i)) {
                    continue;
                }

                // 放置皇后
                queues[row] = i;
                columns.add(i);
                diagonal1.add(row - i);
                diagonal2.add(row + i);
                // 处理下一行
                bracktrack(res, queues, n, row + 1, columns, diagonal1, diagonal2);

                // 回溯
                queues[row] = -1;
                columns.remove(i);
                diagonal1.remove(row - i);
                diagonal2.remove(row + i);

            }


        }

    }

    /**
     * @param queues queues[i]=4 第i行的第4列放置了皇后
     * @param n      棋盘大小为n*n
     */
    public List<String> generateBoard(int[] queues, int n) {

        List<String> res = new ArrayList<>();
        for (int queue : queues) {

            char[] chars = new char[n];
            Arrays.fill(chars, '.');
            chars[queue] = 'Q';
            res.add(new String(chars));

        }

        return res;

    }

}
