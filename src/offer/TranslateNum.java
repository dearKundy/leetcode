package offer;

/**
 * 剑指 Offer 46. 把数字翻译成字符串
 * 若X(i)与X(i-1) 组成的两位数字可以被翻译，则 dp[i] = dp[i - 1] + dp[i - 2]dp[i]=dp[i−1]+dp[i−2] ；否则 dp[i] = dp[i - 1]dp[i]=dp[i−1] 。
 *
 * @author kundy
 * @date 2022/8/10 20:43
 */
public class TranslateNum {

    public int translateNum(int num) {

        int a = 1;
        int b = 1;
        String string = String.valueOf(num);
        for (int i = 2; i <= string.length(); i++) {
            String tmpStr = string.substring(i - 2, i);
            int c = tmpStr.compareTo("10") >= 0 && tmpStr.compareTo("25") <= 0 ? a + b : a;
            b = a;
            a = c;
        }

        return a;

    }


}
