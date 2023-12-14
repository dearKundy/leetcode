package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 电话号码的字母组合
 *
 * @author kundy
 * @date 2023/12/14 11:44
 */
public class LetterCombinationsOfAPhoneNumber {

    String[] board = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};


    public List<String> letterCombinations(String digits) {

        List<String> res = new ArrayList<>();
        backtracking(digits, res, new StringBuffer(), 0);

        return res;
    }

    public void backtracking(String digits, List<String> res, StringBuffer path, int index) {

        if (digits.isEmpty()) {
            return;
        }

        if (path.length() == digits.length()) {
            res.add(path.toString());
            return;
        }

        int num = digits.charAt(index) - '0';
        String character = board[num];

        for (int i = 0; i < character.length(); i++) {
            path.append(character.charAt(i));

            backtracking(digits, res, path, index + 1);

            path.deleteCharAt(path.length() - 1);
        }

    }

}
