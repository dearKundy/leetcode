/**
 * 回文数
 * 需求：判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 *
 * @author kundy
 * @date 2019/7/9 9:59 PM
 */
public class IsPalindrome {

    public static void main(String[] args) {

    }


    /**
     * 击败15%，哭了
     */
    public static boolean wayOne(int x) {
        String str = String.valueOf(x);
        StringBuilder sb = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            char currentChar = str.charAt(i);
            if (currentChar < 48 || currentChar > 57) {
                return false;
            }
            sb = sb.append(str.charAt(i));
        }
        return str.equals(sb.toString());
    }

    /**
     * wayOne 优化版本，使用fast-fail，如果为负数，直接返回。但是对时间效率没有太大的提升。
     */
    public static boolean wayOneOptimization(int x) {
        if (x < 0) {
            return false;
        }
        String str = String.valueOf(x);
        StringBuilder sb = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            char currentChar = str.charAt(i);
            sb = sb.append(str.charAt(i));
        }
        return str.equals(sb.toString());
    }

}
