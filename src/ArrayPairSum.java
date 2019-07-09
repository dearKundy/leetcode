import java.util.Arrays;

/**
 * 数组拆分 I
 * <p>
 * 需求：将数组两两组合，要求每个组合中的最小值之和最大。
 * <p>
 * 解题思路：
 * - 想要每个组合中的最小值最大化，即每个组合中两个数字的差尽可能小。
 * - 首先将数组按从小到大排序，然后对基数位求和即可得到最终的结果。
 *
 * @author kundy
 * @date 2019/7/9 12:01 PM
 */
public class ArrayPairSum {

    public static int wayOne(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 != 0) {
                continue;
            }
            sum += nums[i];
        }
        return sum;
    }

    /**
     * 不使用 continue，循环次数减少一半
     */
    public static int wayTwo(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i += 2) {
            sum += nums[i];
        }
        return sum;
    }

}
