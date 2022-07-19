package offer;

/**
 * 1～n 整数中 1 出现的次数
 *
 * @author kundy
 * @date 2022/7/18 21:33
 */
public class CountDigitOne {

    public int countDigitOne(int n) {

        // 底数 10的0次方
        long base = 1;
        int res = 0;
        // 这里的i在循环中没有使用到，但是实质上充当的是 10 的 i 次方功能
        for (int i = 0; n >= base; ++i) {
            res += (n / (base * 10)) * base + Math.min(Math.max((n % (base * 10) - base + 1), 0), base);
//            Math.pow(10, i);
            base *= 10;
        }
        return res;

    }

}
