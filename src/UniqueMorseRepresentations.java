import java.util.HashSet;
import java.util.Set;

/**
 * 唯一摩尔斯密码词
 * <p>
 * 需求：找出单词对应的摩尔斯密码的个数（不含重复）
 * <p>
 * 解题思路：
 * 因为 words 只包含小写字符，所以用（当前字符 - 97） 即可得到对应的摩尔斯密码的索引。
 *
 * @author kundy
 * @date 2019/7/4 8:28 PM
 */
public class UniqueMorseRepresentations {

    public int uniqueMorseRepresentations(String[] words) {

        String[] rules = {".-", "-...", "-.-.", "-..", ".",
                "..-.", "--.", "....", "..", ".---", "-.-",
                ".-..", "--", "-.", "---", ".--.", "--.-",
                ".-.", "...", "-", "..-", "...-", ".--",
                "-..-", "-.--", "--.."};

        Set<String> set = new HashSet<>();
        for (int i = 0; i < words.length; i++) {
            StringBuilder tmp = new StringBuilder();
            char[] chars = words[i].toCharArray();
            for (int j = 0; j < chars.length; j++) {
                tmp.append(rules[chars[j] - 97]);
            }
            set.add(tmp.toString());
        }
        return set.size();
    }

}
