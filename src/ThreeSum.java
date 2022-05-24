import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15. 三数之和
 *
 * @author kundy
 * @date 2022/5/18 10:26 PM
 */
public class ThreeSum {

    public static void main(String[] args) {
        List<List<Integer>> lists = wayOne(new int[]{-1, 0, 1, 2, -1, -4});
        for (List<Integer> list : lists) {
            for (Integer integer : list) {
                System.out.print(integer + " ");
            }
            System.out.println("");
        }
    }


    public static List<List<Integer>> wayOne(int[] nums) {

        if (nums == null || nums.length <= 0) {
            return new ArrayList<>();
        }

        Arrays.sort(nums);

        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {

            // 重复跳过
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int leftPos = i + 1;
            int rightPos = nums.length - 1;

            while (leftPos < rightPos) {

                int curValue = nums[i];
                int curLeft = nums[leftPos];
                int curRight = nums[rightPos];
                int curTotal = curValue + curLeft + curRight;

                if (curTotal > 0) {
                    rightPos--;
                }

                if (curTotal < 0) {
                    leftPos++;
                }

                if (curTotal == 0) {
                    res.add(Arrays.asList(curValue, curLeft, curRight));

                    // 重复跳过
                    while (leftPos < rightPos && nums[rightPos] == nums[rightPos - 1]) {
                        rightPos--;
                    }
                    while (leftPos < rightPos && nums[leftPos] == nums[leftPos + 1]) {
                        leftPos++;
                    }

                    // 继续找
                    rightPos--;
                    leftPos++;
                }
            }

        }

        return res;
    }

}
