package offer;

/**
 * 矩阵中的路径
 *
 * @author kundy
 * @date 2022/4/19 9:31 PM
 */
public class MatrixRoad {


    public static void main(String[] args) {

        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };

        String word = "SFCS";

        System.out.println(exist(board, word));

    }

    public static boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                // 没找到，就换一个坐标，继续干
                if (dfs(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        // 全部坐标都干一遍了，还是没有找到
        return false;
    }

    public static Boolean dfs(char[][] board, String word, int x, int y, int k) {

        int height = board.length;
        int width = board[0].length;

        // 如果横坐标、纵坐标越界，退出
        if (x < 0 || x > height - 1 || y < 0 || y > width - 1) {
            return false;
        }

        // 当前坐标不等于目标字符，退出
        if (board[x][y] != word.charAt(k)) {
            return false;
        }

        // 如果k已经到达字符串最后一个位置，证明全部匹配上了，返回【全局唯一有可能返回true的地方】
        if (k == word.length() - 1) {
            return true;
        }

        char tmp = board[x][y];

        // 标记为已读，防止走回头路，因为肯定没有字符会和#相等，所以肯定不会再次访问到
        board[x][y] = '#';
        // 能走到这里，证明当前坐标与目标字符相等，那么继续往四周探索，只要有一个方向的元素等于当前的目标字符，就能成功继续递归，不会触发 return false
        if (
            // 左边，注意这里是 k+1，因为现在是要去寻找下一个目标字符了
                dfs(board, word, x - 1, y, k + 1) ||
                        // 右边
                        dfs(board, word, x + 1, y, k + 1) ||
                        // 上边
                        dfs(board, word, x, y - 1, k + 1) ||
                        // 下边
                        dfs(board, word, x, y + 1, k + 1)
        ) {
            return true;
        }

        // 如果上面没有返回ture，证明从x、y作为起点的路不通，恢复board，换一个坐标，再冲重新来
        board[x][y] = tmp;

        return false;
    }

}
