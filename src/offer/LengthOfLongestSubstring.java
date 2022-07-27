package offer;

import java.util.HashSet;
import java.util.Set;

/**
 * @author kundy
 * @date 2022/7/27 21:13
 */
public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        System.out.println(new LengthOfLongestSubstring().lengthOfLongestSubstring("dvdf"));
    }

    public int lengthOfLongestSubstring(String s) {

        char[] chars = s.toCharArray();
        if (chars.length <= 0) {
            return 0;
        }

        int res = 1;

        for (int i = 0; i < chars.length; i++) {
            res = Math.max(res, this.findMax(chars, i));
        }

        return res;
    }
    private int findMax(char[] chars, int left) {

        int res = 0;
        Set<Character> duplicateSet = new HashSet<>();

        for (int i = left ; i < chars.length; i++) {

            if (duplicateSet.contains(chars[i])) {
                break;
            }

            duplicateSet.add(chars[i]);
            res++;

        }

        return res;

    }

}
