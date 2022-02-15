import java.util.HashMap;
import java.util.Map;

/**
 * 需求：给你一个字符串 s ，字符串的「能量」定义为：只包含一种字符的最长非空子字符串的长度。请你返回字符串的能量。
 * ==============================
 * 输入：s = "leetcode"
 * 输出：2
 * 解释：子字符串 "ee" 长度为 2 ，只包含字符 'e' 。
 * ==============================
 * 输入：s = "abbcccddddeeeeedcba"
 * 输出：5
 * 解释：子字符串 "eeeee" 长度为 5 ，只包含字符 'e' 。
 * ==============================
 *
 * @author kundy
 * @date 2022/2/11 3:57 PM
 */
public class MaxPower {

    public static void main(String[] args) {
        System.out.println(wayOne());
    }

    public static Integer wayOne() {

        int count = 1;
        int result = 1;

        String str = "aaaaaaaaabbcccddddeeeeeeeedcba";
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length - 1; i++) {
            // 相等就叠加，否则重置
            count = chars[i] == chars[i + 1] ? count + 1 : 1;
            // result 每次都取 当前result和count中最大的一个
            result = Math.max(result, count);
        }

        return result;
    }
}
