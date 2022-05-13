package offer;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 最小的k个数
 * <p>
 * 先将数组中前k个数放进最大堆中【最大的元素在堆顶】
 * 试想一下，假如其他元素都比最大堆中的k个元素大，那么最大堆中的元素就是最小的k个数
 * 那么，我们就可以不断的将比堆顶还小的元素置换进去，最终就可以达到上面的状态了
 *
 * @author kundy
 * @date 2022/5/12 10:03 PM
 */
public class GetLeastNumbers {

    public static void main(String[] args) {
        int[] leastNumbers = getLeastNumbers(new int[]{0, 0, 0, 2, 0, 5}, 0);
        for (int i = 0; i < leastNumbers.length; i++) {
            System.out.print(leastNumbers[i] + " ");
        }
    }

    public static int[] getLeastNumbers(int[] arr, int k) {

        if (k == 0) {
            return new int[]{};
        }

        // 大顶堆
        Queue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> o2 - o1);

        // 初始化大顶堆
        for (int i = 0; i < k; i++) {
            priorityQueue.offer(arr[i]);
        }

        for (int i = k; i < arr.length; i++) {
            Integer topEle = priorityQueue.peek();
            if (arr[i] < topEle) {
                priorityQueue.poll();
                priorityQueue.offer((arr[i]));
            }
        }

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = priorityQueue.poll();
        }

        return result;
    }

}
