/**
 * 75. 颜色分类
 *
 * @author kundy
 * @date 2022/9/7 22:11
 */
public class SortColors {

    public void sortColors(int[] nums) {

        int length = nums.length;
        if (length < 2) {
            return;
        }

        int i = 0;
        // 如果要将0放在前面partition，请放在这个下标对应的位置
        int left = 0;
        // 如果要将2放在后面partition，请放在这个下标对应的位置
        int right = length - 1;

        while (i <= right) {

            if (nums[i] == 0) {
                // 交换，只能保证0被放在最前面的partition，其他的保证不了
                this.swap(nums, i, left);
                left++;
                // 这里可以i++，因为当前i位置的元素肯定是处于正确的位置了
                i++;
            }
            // 不用动，放在中间的partition
            else if (nums[i] == 1) {
                i++;
            }
            // num[i] ==  2
            else {
                // 交换，只能保证0被放在最后面的partition，其他的保证不了
                this.swap(nums, i, right);
                right--;
                // 这里不能够i++，因为这个情景是将当前i位置的元素与尾部元素置换，可能置换过来的还是2、1、0，都有可能，如果i++，就错过了
//                i++;
            }

        }

    }


    private void swap(int[] array, Integer idxOne, Integer idxTwo) {

        int tmp = array[idxOne];
        array[idxOne] = array[idxTwo];
        array[idxTwo] = tmp;

    }

}
