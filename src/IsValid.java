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
        for (int i = 0; i < chars.length; i++) {
            if (map.containsKey(chars[i])) {
                Character peek = stack.peek();
                if (peek == null || !peek.equals(map.get(chars[i]))) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(chars[i]);
            }

        }

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
