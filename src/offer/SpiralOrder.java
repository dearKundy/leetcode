package offer;

import java.util.HashMap;
import java.util.Map;

/**
 * 顺时针打印矩阵
 *
 * @author kundy
 * @date 2022/4/28 9:13 PM
 */
public class SpiralOrder {

    private static final String UP = "UP";
    private static final String DOWN = "DOWN";
    private static final String LEFT = "LEFT";
    private static final String RIGHT = "RIGHT";

    /**
     * 根据key的方向，坐标应该如何移动
     */
    private static final Map<String, int[]> CURRENT_DIRECTION_MAP = new HashMap() {{
        // row,col
        put(UP, new int[]{-1, 0});
        put(DOWN, new int[]{1, 0});
        put(LEFT, new int[]{0, -1});
        put(RIGHT, new int[]{0, 1});
    }};

    /**
     * 根据当前key的方向，应该转向value的方向
     */
    private static final Map<String, String> NEXT_DIRECTION_MAP = new HashMap() {{
        put(UP, RIGHT);
        put(DOWN, LEFT);
        put(LEFT, UP);
        put(RIGHT, DOWN);
    }};

    public static int[] go(int[][] matrix) {
        int rowNum = matrix.length;
        if (rowNum <= 0) {
            return new int[]{};
        }
        int colNum = matrix[0].length;
        String currentDirection = RIGHT;

        int[] result = new int[rowNum * colNum];
        int[][] visited = new int[rowNum][colNum];

        int currentCol = 0;
        int currentRow = 0;
        for (int i = 0; i < rowNum * colNum; i++) {

            result[i] = matrix[currentRow][currentCol];
            visited[currentRow][currentCol] = 1;

            int[] ints = CURRENT_DIRECTION_MAP.get(currentDirection);

            int tmpCurrentRow = currentRow + ints[0];
            int tmpCurrentCol = currentCol + ints[1];

            // 遇到边界，转方向
            if (tmpCurrentCol >= colNum || tmpCurrentRow >= rowNum || tmpCurrentCol < 0 || tmpCurrentRow < 0 || visited[tmpCurrentRow][tmpCurrentCol] == 1) {
                currentDirection = NEXT_DIRECTION_MAP.get(currentDirection);
                ints = CURRENT_DIRECTION_MAP.get(currentDirection);

                currentRow += ints[0];
                currentCol += ints[1];
                continue;
            }

            currentRow += ints[0];
            currentCol += ints[1];

        }

        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };
        int[] go = go(matrix);
        for (int i : go) {
            System.out.print(i + " ");
        }
    }

}
