package offer;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 数据流中的中位数
 * <p>
 * 我们使用 大顶堆(maxHeap) 来存储数据流中较小一半的值，用 小顶堆(minHeap) 来存储数据流中较大一半的值。
 * 即“大顶堆的堆顶”与“小顶堆的堆顶”就是排序数据流的两个中位数。
 *
 * @author kundy
 * @date 2022/5/14 10:00 AM
 */
public class MedianFinder {

    private Queue<Integer> bigHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
    private Queue<Integer> smallHeap = new PriorityQueue<>();

    /**
     * initialize your data structure here.
     */
    public MedianFinder() {

    }

    /**
     * 需要保证较小部分数据放入大顶堆，较大部分数据放入小顶堆【代入一个特例，只有两个元素的时候，就很容易理解了】
     * 其实就是通过比大小，判断当前num应该放入哪一个堆
     */
    public void addNum(int num) {
        // 放入大顶堆【保存较小一部分数据】
        if (bigHeap.size() == smallHeap.size()) {
            // smallHeap说：来，小的给你，大的我留下
            smallHeap.offer(num);
            bigHeap.offer(smallHeap.poll());
        }
        // 放入小顶堆【保存较大一部分数据】
        else {
            // bigHeap：来，大的给你，小的我留下
            bigHeap.offer(num);
            smallHeap.offer(bigHeap.poll());
        }
    }

    public double findMedian() {
        // 总长度为偶数，两个堆大小相等，返回两个堆顶的平均数
        // 总长度为奇数，返回元素数量更多的堆的堆顶【从addNum可以看到，当两个堆元素相等时，是往bigHeap中插入的，所以bigHeap元素更多】
        return bigHeap.size() == smallHeap.size() ? ((double) (bigHeap.peek() + smallHeap.peek())) / 2 : bigHeap.peek();
    }

    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
//        medianFinder.addNum(1);
        medianFinder.addNum(2);
        medianFinder.addNum(3);

        System.out.println(medianFinder.findMedian());
    }

}
