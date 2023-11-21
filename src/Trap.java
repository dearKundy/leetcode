import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 42. 单调栈-接雨水
 *
 * @author kundy
 * @date 2022/8/25 21:33
 */
public class Trap {

    public static void main(String[] args) {
        System.out.println(new Trap().trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }

    public int trap(int[] height) {

        int res = 0;

        Deque<Integer> stack = new LinkedList<>();

        for (int i = 0; i < height.length; i++) {

            // 不存在重复计算的问题，因为你会发现他进入一个区间后，都是在区间结束的时候才会进行计算一次。
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {

                // 当前要求解的柱子
                Integer pop = stack.pop();

                if (stack.isEmpty()) {
                    break;
                }

                // 有解，此时的栈顶元素就是左侧第一个比要求解的柱子高的元素
                Integer left = stack.peek();
                // height[i] 就是右侧第一个比要求解的柱子高的元素
                int curHeight = Math.min(height[i], height[left]) - height[pop];
                res += (i - left - 1) * curHeight;
            }

            stack.push(i);
        }

        return res;

    }

}
