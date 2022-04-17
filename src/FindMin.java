/**
 * 153. 寻找旋转排序数组中的最小值（数组中的元素互不相同）
 * <p>
 * [0,1,2,3,4,5,6] -> [4,5,6,0,1,2,3] 顺时针旋转
 * <p>
 * 旋转之后的数组特点：
 * - 在 [minPos,minValue对应的pos]这个区间，元素趋势递增
 * - 在 [minValue对应的pos, maxPos]这个区间，元素趋势递减
 * <p>
 * 主要就是用二分查找，只不过左右指针移动的规则和终止规则稍有不一样
 *
 * @author kundy
 * @date 2022/4/17 2:34 PM
 */
public class FindMin {

    public static int findMin(int[] nums) {

        // 起始左、右、中间指针
        int left = 0;
        int right = nums.length - 1;

        // 如果left == right，则循环结束
        while (left < right) {

            int pivot = (left + right) / 2;

            if (nums[pivot] < nums[right]) {
                // 因为中值 < 右值，中值也可能是最小值，右边界只能取到mid处
                right = pivot;
            } else {
                // 因为中值 > 右值，中值肯定不是最小值，左边界可以跨过mid
                left = pivot + 1;
            }

        }

        // 循环结束，left == right，最小值输出nums[left]或nums[right]均可
        return nums[left];
    }

    public static void main(String[] args) {
        System.out.println(findMin(new int[]{4, 5, 6, 0, 1, 2, 3}));
    }

}
