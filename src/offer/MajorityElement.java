package offer;

import java.util.HashMap;
import java.util.Map;

/**
 * 数组中出现次数超过一半的数字
 *
 * @author kundy
 * @date 2022/5/11 10:01 PM
 */
public class MajorityElement {

    public int wayOne(int[] nums) {

        int mediumThreshold = nums.length / 2;

        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            Integer tmpNum = countMap.get(num);
            if (tmpNum == null) {
                countMap.put(num, 1);
            } else {
                int tmpCount = countMap.get(num) + 1;
                if (tmpCount > mediumThreshold) {
                    return num;
                }
                countMap.put(num, tmpCount);
            }
        }
        return nums[0];
    }

    /**
     * Boyer-Moore 投票算法【超过一半的众数会有个特性，如果在数组中同时去掉一个非众数和一个众数，并不会改变整个数组的众数】
     */
    public int wayTwo(int[] nums) {

        int candidate = 0;
        int count = 0;

        for (int num : nums) {

            // 如果当前擂台没有候选人，挑一位新的候选人上来
            if (count == 0) {
                candidate = num;
            }

            // 如果当前挑战者与当前候选人一致，当前候选人 count+1，否则 count-1
            count += (num == candidate) ? 1 : -1;
        }

        // 最终能留下来的，肯定是最硬的【众数】
        return candidate;
    }

}
