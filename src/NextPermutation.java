/**
 * 31. 下一个排列
 *
 * @author kundy
 * @date 2022/8/18 22:18
 */
public class NextPermutation {

    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 1};
        new NextPermutation().nextPermutation(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }

    public void nextPermutation(int[] nums) {

        int i = nums.length - 2;
        // 拐点前一位，如果找不到i=-1
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        // 存在拐点才需要swap
        if (i >= 0) {
            int j = nums.length - 1;
            // 在 [i,end]区间，从后往前找到第一个比i小的元素
            while (j > i && nums[j] <= nums[i]) {
                j--;
            }

            // 交换
            this.swap(nums, i, j);
        }


        // 反转，拐点前一位进行反转，如果找到则 -1+1 =0 处开始反转
        this.reverse(nums, i + 1);

    }

    /**
     * 交换
     */
    private void swap(int[] nums, int left, int right) {
        int tmp = nums[right];
        nums[right] = nums[left];
        nums[left] = tmp;
    }

    /**
     * 反转
     */
    private void reverse(int[] nums, int start) {
        int end = nums.length - 1;
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }


}
