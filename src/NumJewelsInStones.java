import java.util.HashSet;
import java.util.Set;

/**
 * 宝石与石头
 * 需求：求 S 中含有 J 中的字符的个数。
 * <p>
 * 解题思路：
 * 1. 把珠宝放到 Set 中。
 * 2. 遍历 S ，使用 Set#contains() 判断是否存在。（HashSet 判断是否存在某个元素效率较高，O(1)）
 *
 * @author kundy
 * @date 2019/7/8 11:20 AM
 */
public class NumJewelsInStones {

    public static int numJewelsInStones(String J, String S) {

        Set<String> set = new HashSet<>();
        for (int i = 0; i < J.length(); i++) {
            set.add(String.valueOf(J.charAt(i)));
        }

        int num = 0;
        for (int i = 0; i < S.length(); i++) {
            if (set.contains(String.valueOf(S.charAt(i)))) {
                num++;
            }
        }

        return num;
    }

}
