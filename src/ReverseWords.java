/**
 * 反转字符串中的单词 III
 * <p>
 * 需求：给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 * <p>
 * 解题思路：
 * 暴力算法：单独对每个单词进行取反。
 *
 * @author kundy
 * @date 2019/7/9 3:13 PM
 */
public class ReverseWords {

    public static void main(String[] args) {
        String string = "Let's take LeetCode contest";
        System.out.println(reverseWords(string));
    }

    public static String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder result = new StringBuilder();
        for (String word : words) {
            StringBuilder tmp = new StringBuilder();
            for (int j = word.length() - 1; j >= 0; j--) {
                tmp.append(word.charAt(j));
            }
            result = result.append(tmp).append(" ");
        }
        // 删除末尾空格
        return result.toString().trim();
    }

}

