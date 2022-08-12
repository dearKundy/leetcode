package offer;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 剑指 Offer 59 - II. 队列的最大值
 * <p>
 * 当一个当前最大值被poll出去之后，他就不是当前最大值了，所以需要一个单调队列保存当前的最大值
 *
 * @author kundy
 * @date 2022/8/12 08:48
 */
public class MaxQueue {

    Queue<Integer> queue = new LinkedList<>();
    Deque<Integer> monotoneQueue = new LinkedList<>();

    public MaxQueue() {

    }

    public int max_value() {
        if (monotoneQueue.isEmpty()) {
            return -1;
        }

        return monotoneQueue.peekFirst();
    }

    public void push_back(int value) {

        queue.offer(value);
        // 如果一个选手比你小还比你强，你就可以退役了
        while (!monotoneQueue.isEmpty() && value > monotoneQueue.peekLast()) {
            monotoneQueue.pollLast();
        }
        monotoneQueue.offerLast(value);

    }

    public int pop_front() {
        Integer poll = queue.poll();
        if (poll == null) {
            return -1;
        }

        // 如果当前推出的元素刚好等于单调队列的首元素，需要同时移除单调队列的首元素
        if (poll.equals(monotoneQueue.peekFirst())) {
            monotoneQueue.pollFirst();
        }

        return poll;
    }

}
