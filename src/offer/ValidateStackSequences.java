package offer;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 栈的压入、弹出序列
 *
 * @author kundy
 * @date 2022/5/9 6:27 PM
 */
public class ValidateStackSequences {

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Deque<Integer> stack = new LinkedList();
        int currentPos = 0;

        for (int i = 0; i < pushed.length; i++) {
            stack.push(pushed[i]);

            while (!stack.isEmpty() && stack.peek().equals(popped[currentPos])) {
                stack.pop();
                currentPos++;
            }
        }

        return stack.isEmpty();
    }

}
