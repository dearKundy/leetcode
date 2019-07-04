import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 翻转图像
 * <p>
 * 需求：
 * 1. 将数组水平反转 [1,1,0] -> [0,1,1]
 * 2. 将数组全部取反 [0,0,1] -> [1,1,0]
 * <p>
 * 解题思路：
 * 1. 水平反转（两种方法）：第1种是直接将元素压栈，再出栈（击败10%）。第2种是对称位置（1-20、2-19、3-18 ....）不相等即交换值（击败70%）。
 * 2. 取反：数组的元素分别与 1 进行异或运算。
 *
 * @author kundy
 * @date 2019/7/4 7:38 PM
 */
public class FlipAndInvertImage {

    /**
     * 压栈反转
     */
    private int[][] wayOne(int a[][]) {
        for (int i = 0; i < a.length; i++) {
            Deque<Integer> tmp = new ArrayDeque<>();
            int length = a[i].length;
            for (int j = 0; j < length; j++) {
                // 压栈
                tmp.push(a[i][j]);
            }
            for (int k = 0; k < length; k++) {
                // 反转并取反
                a[i][k] = tmp.pop() ^ 1;
            }
        }
        return a;
    }

    /**
     * 对称判断反转
     */
    private int[][] wayTwo(int a[][]) {
        for (int i = 0; i < a.length; i++) {
            int length = a[i].length;
            for (int k = 0; k < length / 2; k++) {
                // 对称位置不相等
                if (a[i][k] != a[i][length - k - 1]) {
                    // 交换
                    int tmp = a[i][k];
                    a[i][k] = a[i][length - k - 1];
                    a[i][length - k - 1] = tmp;
                }
            }

            // 取反
            for (int k = 0; k < length; k++) {
                a[i][k] = a[i][k] ^ 1;
            }
        }
        return a;
    }
}


