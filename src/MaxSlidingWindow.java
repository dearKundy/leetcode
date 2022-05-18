import java.util.Deque;
import java.util.LinkedList;

/**
 * 239. 滑动窗口最大值
 *
 * @author kundy
 * @date 2022/5/17 10:13 PM
 */
public class MaxSlidingWindow {

    public static int[] maxSlidingWindow(int[] nums, int k) {

        if (nums.length == 0) {
            return new int[]{};
        }

        // 定义滑动窗口，保存的是当前滑动窗口内的元素对应的索引下标，单调递减
        Deque<Integer> windows = new LinkedList<>();

        // 初始化滑动窗口
        for (int i = 0; i < k; i++) {
            // 窗口非空且当前待加入元素小于栈顶元素，将栈顶元素推出【因为有nums[i]在，这些元素比nums[i]位置靠前且比num[i]小，则这些元素永远没有出头之日，踢出去就可以了】
            while (!windows.isEmpty() && nums[i] >= nums[windows.peekLast()]) {
                windows.pollLast();
            }

            // 清理干净之后，将当前索引下标加入滑动窗口
            windows.offerLast(i);
        }

        int[] res = new int[nums.length - k + 1];
        res[0] = nums[windows.peekFirst()];

        // 循环维护滑动窗口
        for (int i = k; i < nums.length; i++) {

            // 先把越界的元素剔除【左边界】
            if (windows.peekFirst() <= i - k) {
                windows.pollFirst();
            }

            while (!windows.isEmpty() && nums[i] >= nums[windows.peekLast()]) {
                windows.pollLast();
            }

            windows.offerLast(i);

            res[i - k + 1] = nums[windows.peekFirst()];
        }

        return res;
    }

    public static void main(String[] args) {
        int[] ints = maxSlidingWindow(new int[]{1, 3, 1, 2, 0, 5}, 3);
        for (int anInt : ints) {
            System.out.print(anInt);
        }
    }

}
