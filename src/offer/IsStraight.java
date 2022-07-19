package offer;

import java.util.HashSet;
import java.util.Set;

/**
 * @author kundy
 * @date 2022/7/19 22:02
 */
public class IsStraight {

    public static void main(String[] args) {
        System.out.println(new IsStraight().isStraight(new int[]{1, 2, 3, 4, 5}));
    }


    public boolean isStraight(int[] nums) {

        // 这里的初始化值妙得很，最大、最小变量初始化值分别设置为扑克牌的最小、最大值，以保证后面一定能够被正确置换
        int min = 14;
        int max = 0;

        Set<Integer> set = new HashSet<>();

        for (int num : nums) {

            // 万能牌跳过
            if (num == 0) {
                continue;
            }

            // 重复必定不是顺子
            if (!set.add(num)) {
                return false;
            }
            min = Math.min(min, num);
            max = Math.max(max, num);
        }


        // 最大-最小 小于5，证明一定是顺子
        return max - min < 5;
    }

}
