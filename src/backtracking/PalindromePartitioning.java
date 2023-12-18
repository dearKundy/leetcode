package backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 131.分割回文串
 *
 * @author kundy
 * @date 2023/12/18 13:55
 */
public class PalindromePartitioning {

    private List<List<String>> res = new ArrayList<>();
    private LinkedList<String> path = new LinkedList<>();

    public List<List<String>> partition(String s) {
        backtracking(s, 0);
        return res;
    }


    public void backtracking(String s, int startIndex) {

        // startIndex 要等于 s.length() 的时候才能收集（而不是 s.length()-1）
        if (startIndex >= s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIndex; i < s.length(); i++) {

            String substring = s.substring(startIndex, i + 1);
            if (isPalindrome(substring)) {
                path.add(substring);
            } else {
                continue;
            }

            backtracking(s, i + 1);

            path.removeLast();

        }

    }

    public boolean isPalindrome(String str) {

        int left = 0;
        int right = str.length() - 1;

        while (left < right) {

            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {
        String str = "123456";
        System.out.println(str.substring(5,6));
    }

}
