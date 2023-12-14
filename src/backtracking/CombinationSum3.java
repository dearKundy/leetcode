package backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 组合总和 III
 *
 * @author kundy
 * @date 2023/12/14 10:49
 */
public class CombinationSum3 {

    public List<List<Integer>> combinationSum3(int k, int n) {

        List<List<Integer>> res = new ArrayList<>();
        backtracking(k, n, res, 0, new LinkedList<>(), 1);
        return res;


    }

    public void backtracking(int k, int target, List<List<Integer>> res, int sum, LinkedList<Integer> path, int startIndex) {

        // 剪枝
        if (sum > target) {
            return;
        }

        if (sum == target && path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }

        // 不剪枝
//        int loopSize = 9;

        // 剪枝
        int loopSize = 9 - (k - path.size()) + 1;

        for (int i = startIndex; i <= loopSize; i++) {

            path.add(i);
            sum += i;

            backtracking(k, target, res, sum, path, i + 1);

            path.removeLast();
            sum -= i;

        }

    }


}
