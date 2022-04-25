package offer;

/**
 * 调整数组顺序使奇数位于偶数前面
 *
 * @author kundy
 * @date 2022/4/25 6:27 PM
 */
public class ExchangeOddAndEven {

    public static int[] go(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left != right) {

            while (left < right && nums[left] % 2 != 0) {
                left++;
            }

            while (left < right && nums[right] % 2 == 0) {
                right--;
            }
            swap(nums, left, right);

        }

        return nums;
    }

    public static void swap(int[] nums, int left, int right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }

    public static void main(String[] args) {

        int[] num2 = go(new int[]{1, 2, 3, 4});
        for (int i = 0; i < num2.length; i++) {
            System.out.print(num2[i] + "");
        }
    }

}
