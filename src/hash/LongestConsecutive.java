package hash;

import java.util.HashSet;
import java.util.Set;

/**
 * 最长连续序列
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 *
 * @author kundy
 * @date 2023/11/8 20:59
 */
public class LongestConsecutive {

    public int longestConsecutive(int[] nums) {

        Set<Integer> set = new HashSet<>();

        // nums 判空
        if (nums == null || nums.length == 0) {
            return 0;
        }

        for (int num : nums) {
            set.add(num);
        }

        int res = 1;
        // 以数组中的每个数为终点，向前取数，直到取不到为止，取到的数的个数即以当前数为终点的最长连续序列的长度
        for (int num : nums) {

            // 如果存在比当前数大的数，说明最长连续序列不会在已此数字为终点的序列中产生
            if (set.contains(num + 1)) {
                continue;
            }

            int tmpRes = 1;
            // 以当前数为终点，向前取数，直到取不到为止
            int frontNum = num - 1;
            while (set.contains(frontNum)) {
                frontNum = frontNum - 1;
                tmpRes++;
            }

            res = Math.max(res, tmpRes);

        }

        return res;

    }


    // 生成测试方法
    public static void main(String[] args) {

        int[] nums = {100, 4, 200, 1, 3, 2};
        int res = new LongestConsecutive().longestConsecutive(nums);
        System.out.println(res);

    }

}
