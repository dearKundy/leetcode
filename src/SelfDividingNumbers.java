import java.util.ArrayList;
import java.util.List;

/**
 * 自除数
 * <p>
 * 解题思路：
 * 暴力解法：逐个字符取模比较
 *
 * @author kundy
 * @date 2019/7/6 11:49 AM
 */
public class SelfDividingNumbers {

    /**
     * 击败 24%
     */
    public static List<Integer> wayOne(int left, int right) {
        List<Integer> list = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            String tmp = String.valueOf(i);
            boolean flag = true;
            for (int j = 0; j < tmp.length(); j++) {
                if (tmp.charAt(j) == 48) {
                    flag = false;
                    break;
                }
                int num = i % (tmp.charAt(j) - 48);
                if (num != 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                list.add(i);
            }
        }
        return list;
    }

}
