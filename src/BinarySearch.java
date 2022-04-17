/**
 * 二分查找【在一个有序的数组里找到目标元素】
 *
 * @author kundy
 * @date 2022/4/14 9:28 PM
 */
public class BinarySearch {

    public static int go(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int middle = (right + left) / 2;

        // 左指针没有超过右指针
        while (left <= right) {

            if (nums[middle] == target) {
                return middle;
            }

            //  target 在中位数左边，右指针靠拢，可以确定middle肯定不是我们的目标预算，所以right可以向前移动一位
            if (target < nums[middle]) {
                right = middle - 1;
            }

            // target 在中位数右边，左指针靠拢，可以确定middle肯定不是我们的目标预算，所以left可以向后移动一位
            if (target > nums[middle]) {
                left = middle + 1;
            }

            // 计算中位数
            middle = (right + left) / 2;
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 3, 5, 9, 12};
        System.out.println(go(nums, -1));
        System.out.println(go(nums, 0));
        System.out.println(go(nums, 3));
        System.out.println(go(nums, 5));
        System.out.println(go(nums, 9));
        System.out.println(go(nums, 12));
        System.out.println(go(nums, 118));
        System.out.println(go(nums, 19));
    }


}
