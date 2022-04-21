package offer;

/**
 * 二进制中1的个数
 *
 * @author kundy
 * @date 2022/4/21 10:04 PM
 */
public class HammingWeight {

    public static int go(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) != 0) {
                result++;
            }
        }
        return result;
    }

}
