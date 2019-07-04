/**
 * 转换成小写字母
 * <p>
 * 需求：将字符串中的字符全部转换成小写字母
 * <p>
 * 解题思路：
 * - 直接使用 String#toLowerCase()
 * - 轮子法：每个 char 都有一个唯一对应的整数，大写字母(A) + 32 = 小写字母(a)。
 *
 * @author kundy
 * @date 2019/7/4 8:22 PM
 */
public class ToLowerCase {

    public String toLowerCase(String str) {
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] >= 65 && chars[i] <= 90) {
                chars[i] += 32;
            }
        }
        return new String(chars);
    }

}
