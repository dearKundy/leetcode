/**
 * 33. 搜索旋转排序数组
 * 将数组一分为二，其中一定有一个是有序的，另一个可能是有序，也能是部分有序。
 * 此时有序部分用二分法查找。无序部分再一分为二，其中一个一定有序，另一个可能有序，可能无序。就这样循环.
 *
 * @author kundy
 * @date 2022/8/31 18:03
 */
public class Search {

    public int search(int[] nums, int target) {

        int length = nums.length;
        if (length == 0) {
            return -1;
        }
        if (length == 1) {
            return nums[0] == target ? 0 : -1;
        }

        int left = 0;
        int right = length - 1;


        while (left <= right) {
            int mid = (left + right) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            // 必须在有序的部分定位目标

            // 左半部分有序
            if (nums[left] <= nums[mid]) {

                // 目标在左半部
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                }
                // 目标在右半部
                else {
                    left = mid + 1;
                }

            }
            // 右半部分有序
            else {

                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }

            }

        }

        return -1;

    }

}
