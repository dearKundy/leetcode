import java.util.Deque;
import java.util.LinkedList;

/**
 * 32. 最长有效括号
 *
 * @author kundy
 * @date 2022/8/23 20:43
 */
public class LongestValidParentheses {

    public static void main(String[] args) {
        System.out.println(new LongestValidParentheses().longestValidParentheses("()"));
    }

    public int longestValidParentheses(String s) {

        char[] chars = s.toCharArray();
        int res = 0;
        Deque<Integer> deque = new LinkedList<>();

        deque.push(-1);

        for (int i = 0; i < chars.length; i++) {

            // 遇到左括号入栈
            if (chars[i] == '(') {
                deque.push(i);
            } else {
                // 遇到有括号，先pop一个与之对应的左括号
                deque.pop();

                // 空了代表，匹配不上，且【最后一个没有被匹配的右括号的下标】已经被推出去
                if (deque.isEmpty()) {
                    deque.push(i);
                } else {
                    // 每一轮的计算一次最大长度，不断覆盖
                    res = Math.max(res, i - deque.peek());
                }
            }


        }

        return res;

    }

}
