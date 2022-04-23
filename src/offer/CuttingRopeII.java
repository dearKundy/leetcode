package offer;

/**
 * 剪绳子II：14- I. 剪绳子 主体等价，唯一不同在于本题目涉及 “大数越界情况下的求余问题” 。
 * <p>
 * 1. 当所有绳段长度相等时，乘积最大。
 * 2. 尽可能将绳子以长度3 等分为多段时，乘积最大。
 * <p>
 * 最后一段要么4，要么5
 * <p>
 * 当最后剩余是5时，应该继续切分为3*2
 * <p>
 * 当最后剩余是4时，不用继续切割，因为 2*2=4,1*3=3
 *
 * @author kundy
 * @date 2022/4/23 10:39 AM
 */
public class CuttingRopeII {

    public static void main(String[] args) {
        System.out.println(go(7));
    }

    public static int go(int n) {

        // 注意是long，如果是 int 在取模之前已经溢出了
        long result = 1;

        while (n > 4) {
            result = result * 3 % 1000000007;
            n -= 3;
        }

        return (int) result * n % 1000000007;
    }

}
