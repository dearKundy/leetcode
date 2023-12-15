package doublepoint;

/**
 * 回文数
 * 需求：判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 *
 * @author kundy
 * @date 2019/7/9 9:59 PM
 */
public class IsPalindrome {

    public boolean isPalindrome(int x) {

        String str = String.valueOf(x);

        int left = 0;
        int right = str.length() - 1;

        while (left < right) {

            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }


}
