package stackandqueue;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 有效的括号
 *
 * @author kundy
 * @date 2022/5/16 10:16 PM
 */
public class IsValid {

    private static final Map<Character, Character> map = new HashMap() {{
        put(')', '(');
        put('}', '{');
        put(']', '[');
    }};

    public static boolean isValid(String s) {
        Deque<Character> stack = new LinkedList<>();
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            // 如果是右括号，出栈，并检查是否是对应的左括号
            if (map.containsKey(aChar)) {
                Character peek = stack.peek();
                if (peek == null || !peek.equals(map.get(aChar))) {
                    return false;
                }
                stack.pop();
            }
            // 左括号，直接入栈
            else {
                stack.push(aChar);
            }

        }

        // 如果全部一一匹配，stack理应为空
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("()"));
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("(]"));
        System.out.println(isValid("([)]"));
        System.out.println(isValid("{[]}"));
        System.out.println(isValid("}"));
    }

}
