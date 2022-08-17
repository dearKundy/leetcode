package offer;

/**
 * 剑指 Offer 66. 构建乘积数组
 *
 * @author kundy
 * @date 2022/8/16 10:31
 */
public class ConstructArr {

    public int[] constructArr(int[] a) {

        int length = a.length;

        if (length <= 0) {
            return a;
        }

        int[] arrayB = new int[length];
        arrayB[0] = 1;
        int tmp = 1;

        // 下三角
        for (int i = 1; i < length; i++) {
            // arrayB[i - 1] 表示上一次乘积的结果
            arrayB[i] = arrayB[i - 1] * a[i - 1];
        }

        // 上三角
        for (int i = length - 2; i >= 0; i--) {
            tmp *= a[i + 1];
            arrayB[i] *= tmp;
        }

        return arrayB;

    }

}
