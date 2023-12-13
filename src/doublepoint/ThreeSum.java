package doublepoint;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15. 排序+双指针-三数之和
 * <p>
 * 先排序，必须要排序，才能使用双指针的方法，因为排序之后才能根据大小判断需要移动哪个指针，从而可以实现一次遍历找出所有的结果。
 * 排序之后，去重也比较简单
 *
 * <p>
 * 找匹配元素：
 * 遍历每一个a，找b，c，使得a+b+c=0。b从a的下一个元素开始【左指针】，c从数组末尾开始【右指针】。
 * 如果左右指针相加符合预期，加入结果集，左指针右移。
 * 如果左右指针相加小于预期，左指针右移。
 * 如果左右指针相加大于预期，右指针左移。
 * <p>
 * 结果集去重：
 * a、b均要去重，核心思路就是从第二个元素开始，判断是否与前面一个元素相同，相同则跳过，因为元素相同，结果集肯定也相同。
 *
 * @author kundy
 * @date 2022/5/18 10:26 PM
 */
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {

        if (nums == null || nums.length < 3) {
            return new ArrayList<>();
        }

        // 从小到大排序
        Arrays.sort(nums);

        List<List<Integer>> res = new ArrayList<>();

        // 遍历a
        for (int i = 0; i < nums.length; i++) {

            // 因为是从小到大排序，如果当前元素大于0，则后面的元素肯定大于0，相加肯定不可能等于0，该元素后面的所有元素都不可能了，直接 break
            if (nums[i] > 0) {
                break;
            }

            // 如果当前元素的相反数比最大的两个元素相加还要大，那就无解了
            if (-nums[i] > nums[nums.length - 1] + nums[nums.length - 2]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;
            int target = -nums[i];

            // a去重，第二位开始才需要去重
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // 遍历b
            while (left < right) {

                // b也要去重，从第二位开始，当前元素与上一个元素相同，则跳过
                if (left > i + 1 && nums[left] == nums[left - 1]) {
                    left++;
                    continue;
                }

                int curValue = nums[left] + nums[right];
                if (curValue == target) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                }

                // 比目标大，右指针左移
                if (curValue > target) {
                    right--;
                } else {
                    left++;
                }
            }

        }

        return res;

    }

}
