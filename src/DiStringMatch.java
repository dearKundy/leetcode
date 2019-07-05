/**
 * 增减字符串匹配
 * <p>
 * 解题思路：
 * - 为了避免后面无数可用，所以优先使用没有使用过的数中最大或者最小的数。
 * - 使用两个变量记录当前头尾指针位置，如果是 I ，从头取。否则从尾取。
 * - 最后一个元素取当前head的值或者tail的值都可以，因为头尾指针最终会相遇。
 *
 * @author kundy
 * @date 2019/7/5 3:14 PM
 */
public class DiStringMatch {

    public static int[] diStringMatch(String s) {
        char[] chars = s.toCharArray();
        int length = chars.length;
        int[] result = new int[length + 1];

        int head = 0;
        int tail = length;

        for (int i = 0; i < length; i++) {
            if (chars[i] == 'I') {
                result[i] = head++;
            } else {
                result[i] = tail--;
            }
        }
        // 补上最后一个值
        result[length] = head;
        return result;
    }

}
