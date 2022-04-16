package offer;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 用栈实现队列【push在 inStack中操作，pop、peek在 outStack 中操作，当outStack中元素为空时，从inStack中抽取过去】
 * <p>
 * LeetCode官方思路：
 * <p>
 * 将一个栈当作输入栈，用于压入 push 传入的数据；另一个栈当作输出栈，用于 pop 和 peek 操作。
 * <p>
 * 每次 pop 或 peek 时，若输出栈为空则将输入栈的全部数据依次弹出并压入输出栈，这样输出栈从栈顶往栈底的顺序就是队列从队首往队尾的顺序。
 *
 * @author kundy
 * @date 2022/4/16 11:42 AM
 */
public class MyQueue {

    private Deque<Integer> inStack;
    private Deque<Integer> outStack;

    public MyQueue() {

        inStack = new ArrayDeque<>();
        outStack = new ArrayDeque<>();

    }

    public void push(int x) {
        inStack.push(x);
    }

    public int pop() {
        // 如果outStack为空，需要从inStack调取填充
        if (outStack.isEmpty()) {
            if (!in2out()) {
                throw new RuntimeException("队列为空");
            }
        }
        return outStack.pop();
    }

    public int peek() {
        // 如果outStack为空，需要从inStack调取填充
        if (outStack.isEmpty()) {
            if (!in2out()) {
                throw new RuntimeException("队列为空");
            }
        }

        return outStack.peek();
    }

    private Boolean in2out() {
        if (inStack.isEmpty()) {
            return false;
        }

        while (!inStack.isEmpty()) {
            outStack.push(inStack.pop());
        }

        return true;
    }

    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1);
        myQueue.push(2);
        myQueue.push(3);
        myQueue.push(4);
        myQueue.push(5);

        System.out.println(myQueue.peek());
        System.out.println(myQueue.peek());

        System.out.println(myQueue.pop());
        System.out.println(myQueue.pop());
        System.out.println(myQueue.pop());
        System.out.println(myQueue.pop());
        System.out.println(myQueue.pop());
        System.out.println(myQueue.pop());
        System.out.println(myQueue.pop());
        System.out.println(myQueue.pop());


    }

}
