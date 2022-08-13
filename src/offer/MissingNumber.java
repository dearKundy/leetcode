package offer;

/**
 * 剑指 Offer 53 - II. 0～n-1中缺失的数字
 *
 * @author kundy
 * @date 2022/8/13 11:32
 */
public class MissingNumber {

    public static void main(String[] args) {
        System.out.println(new MissingNumber().missingNumber(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 9}));
    }

    public int missingNumber(int[] nums) {

        int n = nums.length + 1;
        int exceptSum = ((0 + (n - 1)) * n) / 2;

        // 错误解法，当缺失位是首位、末尾时，用这个通项公式算出来的预期sum就是错误的
//        int exceptSum = ((nums[0] + nums[nums.length - 1]) * (nums[nums.length - 1] + 1)) / 2;

        int actualSum = 0;
        for (int num : nums) {
            actualSum += num;
        }

        return exceptSum - actualSum;
    }

}
