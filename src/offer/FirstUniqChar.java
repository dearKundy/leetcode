package offer;

import java.util.HashMap;
import java.util.Map;

/**
 * 剑指 Offer 50. 第一个只出现一次的字符
 *
 * @author kundy
 * @date 2022/8/2 11:02
 */
public class FirstUniqChar {

    public char firstUniqChar(String s) {

        char[] chars = s.toCharArray();
        if (chars.length <= 0) {
            return ' ';
        }

        Map<Character, Integer> countMap = new HashMap<>();
        for (char aChar : chars) {
            Integer count = countMap.get(aChar);
            if (count != null) {
                countMap.put(aChar, ++count);
            } else {
                countMap.put(aChar, 1);
            }
        }

        for (char aChar : chars) {
            Integer integer = countMap.get(aChar);
            if (integer == 1) {
                return aChar;
            }
        }

        return ' ';

    }

}
