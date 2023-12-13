package doublepoint;

/**
 * 双指针-移动零
 *
 * @author kundy
 * @date 2023/11/8 21:47
 */
public class MoveZeroes {

    public void moveZeroes(int[] nums) {

        if (nums == null || nums.length == 0) {
            return;
        }

        // 左指针，左指针左边都是非零元素，左指针指向：下一个非零元素应该放在此位置
        int left = 0;
        // 右指针，用于遍历所有元素
        int right = 0;
        int len = nums.length;

        // 如果全部都是非零元素，则一直是自己和自己交换，因为左右指针同时移动，一直指向同一个元素
        while (right < len) {
            // 非零元素放到左边，每放一个，左指针右移，以便存放下一个非零元素，实质上就是要把所有非零元素堆到左边，那具体是放在左边哪个位置呢
            // 就是放在左指针指向的这个位置
            if (nums[right] != 0) {
                swap(nums, left, right);
                left++;
            }
            right++;
        }

    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    //4个 moveZeroes 单元测试
    public static void main(String[] args) {
        MoveZeroes moveZeroes = new MoveZeroes();
        int[] nums = {0, 1, 0, 3, 12};
        moveZeroes.moveZeroes(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }

    }


}
