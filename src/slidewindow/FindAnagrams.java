package slidewindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 滑动窗口-找到字符串中所有字母异位词
 * 核心思路：判断滑动窗口内的不同字符数量与目标的不同字符数量是否相等
 *
 * @author kundy
 * @date 2023/11/21 21:39
 */
public class FindAnagrams {

    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> res = new ArrayList<>();

        int sLength = s.length();
        int pLength = p.length();

        if (sLength < pLength) {
            return res;
        }

        // sCount[0-25] 表示 sCount 数组中 a-z 字母的词频，例如 int[0]=4 表示 a 在 s 中出现了 4 次
        int[] sCount = new int[26];
        int[] pCount = new int[26];

        // 初始化滑动窗口
        for (int i = 0; i < pLength; i++) {
            sCount[s.charAt(i) - 'a']++;
            pCount[p.charAt(i) - 'a']++;
        }

        // 先判断s中的头三个元素是否相同
        if (Arrays.equals(sCount, pCount)) {
            res.add(0);
        }

        for (int i = 0; i < sLength - pLength; i++) {

            // 滑动窗口向前移动一格，并且更新窗口内各字符数量
            --sCount[s.charAt(i) - 'a'];
            ++sCount[s.charAt(i + pLength) - 'a'];

            if (Arrays.equals(sCount, pCount)) {
                // 进入循环之后，就已经向前移动了一个，所以这里是+1
                res.add(i + 1);
            }

        }


        return res;

    }

    // 测试findAnagrams
    public static void main(String[] args) {

        FindAnagrams findAnagrams = new FindAnagrams();
        List<Integer> res = findAnagrams.findAnagrams("cbaebabacd", "abc");
        System.out.println(res);

    }

}
