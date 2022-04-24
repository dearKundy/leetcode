package offer;

/**
 * 数值的整数次方【从 x 开始，每次直接把上一次的结果进行平方】
 * <p>
 * 举个例子，x^77= (x^38)^2*x
 * <p>
 * 直接从左到右进行推导看上去很困难，因为在每一步中，我们不知道在将上一次的结果平方之后，还需不需要额外乘 x。
 * 但如果我们从右往左看，分治的思想就十分明显了
 * <p>
 * 从左到右，我们能做的只有不断的x2、x2，但是每次这样x2，最后大概率得不到我们想要的结果。
 * 但是从右到左，从目标出发，不断除2，从而就可以得到我们想要求的所有的中间目标，我们把这些中间目标计算并存储起来，
 * 就可以得到最终的结果，而这个过程恰巧可以使用递归完成
 *
 * @author kundy
 * @date 2022/4/23 12:53 PM
 */
public class MyPow {

    public static void main(String[] args) {
        System.out.println(go(2, 2));
        System.out.println(go(2, 3));
        System.out.println(go(2, 4));
        System.out.println(go(2, 5));
        System.out.println(go(2, 6));
        System.out.println(go(2, 7));
        System.out.println(go(2, 8));
        System.out.println(go(2, 9));
    }

    public static double go(double x, int n) {
        // 如果 n 为负数，则先算出 -n 次数，最后取倒数
        return n < 0 ? 1 / quickMul(x, -n) : quickMul(x, n);
    }

    public static double quickMul(double x, int n) {

        if (n == 0) {
            return 1;
        }

        double result = quickMul(x, n / 2);
        // 如果 n 为偶数：x^n=y^2
        // 如果 n 为奇数：x^n=y^2*x【如果为奇数开方之后，还需要再补一次x】
        // 其中n为次方数，y为上一次计算的结果
        return n % 2 == 0 ? result * result : result * result * x;
    }


}
