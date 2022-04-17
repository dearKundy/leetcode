package offer;

/**
 * 找旋转排序数组中的最小值（数组中的含有重复元素）
 * <p>
 * 与不含重复元素的版本比较，当我们含有重复元素时，当numbers[pivot]==numbers[high]我们并不能确定
 * numbers[pivot] 究竟在最小值的左侧还是右侧，我们通过hig指针前移方法解决
 *
 * @author kundy
 * @date 2022/4/17 6:45 PM
 */
public class MinArray {

    public static int go(int[] nums) {
        // 起始左、右、中间指针
        int left = 0;
        int right = nums.length - 1;

        // 如果left == right，则循环结束
        while (left < right) {

            int pivot = (left + right) / 2;

            if (nums[pivot] < nums[right]) {
                // 因为中值 < 右值，中值也可能是最小值，右边界只能取到mid处
                right = pivot;
            } else if (nums[pivot] > nums[right]) {
                // 因为中值 > 右值，中值肯定不是最小值，左边界可以跨过mid
                left = pivot + 1;
            } else {
                right--;
            }

        }

        // 循环结束，left == right，最小值输出nums[left]或nums[right]均可
        return nums[left];
    }

    public static void main(String[] args) {
        System.out.println(go(new int[]{4, 4, 4, 4, 5, 6, 0, 1, 2, 3, 3, 3, 3}));
    }

}
