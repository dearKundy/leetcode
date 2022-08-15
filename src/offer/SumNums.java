package offer;

/**
 * 剑指 Offer 64. 求1+2+…+n
 *
 * @author kundy
 * @date 2022/8/15 22:27
 */
public class SumNums {

    int res = 0;
    public int sumNums(int n) {

        boolean x = n > 1 && sumNums(n - 1) > 0;
        res += n;
        return res;
    }

}
