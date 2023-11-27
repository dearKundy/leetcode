import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 单调栈-每日温度
 * 使用单调栈，当前元素比栈顶元素大的，栈顶元素出栈（记录解【下标】）
 * 如果当前元素比栈顶元素小，入栈
 *
 * @author kundy
 * @date 2023/11/15 21:20
 */
public class DailyTemperatures {

    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];

        Deque<Integer> stack = new ArrayDeque<>();

        // 遍历所有元素
        for (int i = 0; i < temperatures.length; i++) {
            // 如果当前元素比栈顶元素大，则找到了解，然后可以继续找下去
            // 如果当前元素比栈顶元素小，则找不到解，先存储起来，知道下一个比栈顶元素更大的元素出现
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                Integer pop = stack.pop();
                result[pop] = i - pop;
            }

            stack.push(i);
        }

        return result;
    }

    // 测试 dailyTemperatures
    public static void main(String[] args) {
        DailyTemperatures dailyTemperatures = new DailyTemperatures();
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] result = dailyTemperatures.dailyTemperatures(temperatures);
        for (int i : result) {
            System.out.println(i);
        }
    }

}
