package offer;

/**
 * 斐波那契数列
 * - 不建议使用递归，因为如果使用递归，会导致大量的重复计算，例如fib(6)=fib(6-1)+fib(6-2)，把树展开，就会发现f(4)、f(3)被重复计算了两次
 * <p>
 * - 而这道题是属于动态规划问题：递归关系中存在【overlap sub-problem】
 * <p>
 * 答案需要取模 1e9+7（1000000007），
 *
 * @author kundy
 * @date 2022/4/16 1:02 PM
 */
public class Fib {

    public static void main(String[] args) {
        System.out.println(fib(0));
        System.out.println(fib(1));
        System.out.println(fib(2));
        System.out.println(fib(3));
        System.out.println(fib(4));
        System.out.println(fib(5));
        System.out.println(fib(6));
        System.out.println(fib(7));
        System.out.println(fib(8));
        System.out.println(fib(9));
    }

    public static int fib(int n) {

        final int MOD = 1000000007;

        if (n < 2) {
            return n;
        }

        int a = 0, b = 1, sum = 2;
        for (int i = 2; i <= n; i++) {
            sum = (a + b) % MOD;
            a = b;
            b = sum;
        }

        return sum;
    }

}
