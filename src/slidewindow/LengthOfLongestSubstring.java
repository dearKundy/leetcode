package slidewindow;

import java.util.HashSet;
import java.util.Set;

/**
 * 滑动窗口-无重复字符的最长子串
 * 左指针遍历每一个元素，右指针移动到以左指针为起点，右指针为终点围成的最长无重复字串处
 * 无论何时，左右指针围起来的字串都是不含重复元素的【所以当移动左指针后，右指针无须复位，只需移动到下一个元素即可】
 *
 * @author kundy
 * @date 2023/11/20 17:03
 */
public class LengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s) {

        int res = 0;

        char[] charArray = s.toCharArray();
        Set<Character> charSet = new HashSet<>();


        int right = 0;
        for (int i = 0; i < charArray.length; i++) {

            // 从第二轮开始，每向前移动一次左指针，需要将前面的元素从set中移除，因为前面的元素已经不再滑动窗口中了【滑动窗口就是要一直处理更新窗口中的数值】
            if (i != 0) {
                charSet.remove(charArray[i - 1]);
            }

            // 一直往右移动指针，直到set中含有了重复元素就停退出，接着移动左指针
            while (right <= charArray.length - 1 && !charSet.contains(charArray[right])) {
                charSet.add(charArray[right]);
                res = Math.max(res, right - i + 1);
                right++;
            }


        }


        return res;

    }

    // lengthOfLongestSubstring 单元测试
    public static void main(String[] args) {

        String s = "abcabcbb";
        LengthOfLongestSubstring lengthOfLongestSubstring = new LengthOfLongestSubstring();
        System.out.println(lengthOfLongestSubstring.lengthOfLongestSubstring(s));

    }

}
