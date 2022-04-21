package offer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 机器人的运动范围【将矩阵铺开，视为一张图，通过右下节点连接各个元素，然后使用BFS，考虑行坐标和列坐标的数位之和大于k的格子同为边界】
 * <p>
 * 利用队列实现BFS
 *
 * @author kundy
 * @date 2022/4/19 10:53 PM
 */
public class MovingCount {

    public static int movingCount(int m, int n, int k) {

        Queue<int[]> queue = new LinkedList<>();
        // 已访问元素数组
        boolean[][] visited = new boolean[m][n];

        // 将第一个坐标推入队列
        queue.offer(new int[]{0, 0});
        // 标记为已读
        visited[0][0] = true;

        int result = 0;

        while (!queue.isEmpty()) {
            int[] currentEle = queue.poll();
            result++;

            // 当前推出元素的XY坐标
            int currentEleX = currentEle[0];
            int currentEleY = currentEle[1];

            // 控制方向
            int[] dx = new int[]{1, 0};
            int[] dy = new int[]{0, 1};

            // 将当前元素的右边元素和下边元素推进队列
            for (int i = 0; i < 2; i++) {

                int nextX = currentEleX + dx[i];
                int nextY = currentEleY + dy[i];

                // 如果下一元素已经触碰到边界，就不需要再往 queue 中推了
                if (nextX > m - 1 || nextY > n - 1 || visited[nextX][nextY] || calSum(nextX) + calSum(nextY) > k) {
                    continue;
                }
                queue.offer(new int[]{nextX, nextY});

                // 已读
                visited[nextX][nextY] = true;
            }

        }

        return result;
    }

    /**
     * 坐标求和
     */
    private static int calSum(int num) {
        int sum = 0;
        while (num != 0) {
            sum += num % 10;
            num = num / 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(movingCount(2, 3, 1));
        System.out.println(movingCount(3, 1, 0));
    }

}
