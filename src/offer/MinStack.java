package offer;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 包含min函数的栈
 *
 * @author kundy
 * @date 2022/4/29 9:08 PM
 */
public class MinStack {

    private Deque<Integer> stack;
    private Deque<Integer> minStack;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        stack = new LinkedList<>();
        minStack = new LinkedList<>();
    }

    public void push(int x) {
        stack.push(x);
        if (minStack.isEmpty()) {
            minStack.push(x);
            return;
        }
        minStack.push(Math.min(minStack.peek(), x));
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        if (stack.isEmpty()) {
            return 0;
        }
        return stack.peek();
    }

    public int min() {
        if (minStack.isEmpty()) {
            return 0;
        }
        return minStack.peek();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(6);
        minStack.push(5);
        minStack.push(4);
        minStack.push(3);
        minStack.push(2);
        minStack.push(1);

        System.out.println(minStack.min());
        minStack.pop();

        System.out.println(minStack.min());
        minStack.pop();

        System.out.println(minStack.min());
        minStack.pop();

        System.out.println(minStack.min());
        minStack.pop();

        System.out.println(minStack.min());
        minStack.pop();

        System.out.println(minStack.min());
        minStack.pop();

        System.out.println(minStack.min());
        minStack.pop();
    }
}
