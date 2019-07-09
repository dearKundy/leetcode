import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 键盘行
 * <p>
 * 需求：只返回可以使用在键盘同一行的字母打印出来的单词。
 * <p>
 * 解题思路：
 * 1. 把键盘信息存放在 HashMap ，key 为键盘字符，value 为键盘字符所在行。
 * 2. 逐个字符比较 value 是否相同。
 *
 * @author kundy
 * @date 2019/7/9 9:56 AM
 */
public class FindWords {

    private static Map<Character, Integer> map = new HashMap<>();

    static {
        map.put('z', 1);
        map.put('x', 1);
        map.put('c', 1);
        map.put('v', 1);
        map.put('b', 1);
        map.put('n', 1);
        map.put('m', 1);
        map.put('a', 2);
        map.put('s', 2);
        map.put('d', 2);
        map.put('f', 2);
        map.put('g', 2);
        map.put('h', 2);
        map.put('j', 2);
        map.put('k', 2);
        map.put('l', 2);
        map.put('q', 3);
        map.put('w', 3);
        map.put('e', 3);
        map.put('r', 3);
        map.put('t', 3);
        map.put('y', 3);
        map.put('u', 3);
        map.put('i', 3);
        map.put('o', 3);
        map.put('p', 3);
    }

    public static String[] findWords(String[] words) {
        List<String> result = new ArrayList<>(words.length);
        for (String word : words) {
            String tmp = word.toLowerCase();
            boolean isSameLine = true;
            int currentLine = map.get(tmp.charAt(0));
            for (int j = 1; j < tmp.length(); j++) {
                if (map.get(tmp.charAt(j)) != currentLine) {
                    isSameLine = false;
                    break;
                }
            }
            if (isSameLine) {
                result.add(word);
            }
        }
        return result.toArray(new String[0]);
    }

}
