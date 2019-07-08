import java.util.Arrays;

/**
 * 高度检查器
 * <p>
 * 需求：按照非递减的规则，返回没有站在正确位置的学生的数量
 * <p>
 * 解题思路：
 * - copy 一份原来的队列，排序后与原队列比较差异个数。
 *
 * @author kundy
 * @date 2019/7/8 5:21 PM
 */
public class HeightChecker {


    public static void main(String[] args) {

        System.out.println(heightChecker(new int[]{1, 1, 4, 2, 1, 3}));
    }

    public static int heightChecker(int[] heights) {
        int[] tmp = heights.clone();
        Arrays.sort(tmp);

        int num = 0;
        for (int i = 0; i < tmp.length; i++) {
            if (tmp[i] != heights[i]) {
                num++;
            }
        }

        return num;
    }

}
