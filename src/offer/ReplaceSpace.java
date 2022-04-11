package offer;

/**
 * 替换空格【请实现一个函数，把字符串 s 中的每个空格替换成"%20"。】
 *
 * @author kundy
 * @date 2022/4/11 4:30 PM
 */
public class ReplaceSpace {


    public static String go(String s) {

        // 建立字符数组地长度为 s 的长度的 3 倍，这样可保证字符数组可以容纳所有替换后的字符
        char[] result = new char[s.length() * 3];

        char[] chars = s.toCharArray();
        int curPos = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {

                result[curPos] = '%';
                result[curPos + 1] = '2';
                result[curPos + 2] = '0';

                curPos += 3;

                continue;
            }

            result[curPos] = chars[i];
            curPos++;

        }
        return new String(result, 0, curPos);
    }

    public static void main(String[] args) {
        String s = "We are happy.";
        System.out.println(go(s));
    }
}
