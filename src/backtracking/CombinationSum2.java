package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 40.组合总和II
 *
 * @author kundy
 * @date 2023/12/15 11:42
 */
public class CombinationSum2 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        backtracking(candidates, target, res, new LinkedList<>(), 0, 0, new int[candidates.length]);
        return res;

    }

    public void backtracking(int[] candidates, int target, List<List<Integer>> res, LinkedList<Integer> path, int sum, int startIndex, int[] used) {

        if (sum > target) {
            return;
        }

        if (sum == target) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIndex; i < candidates.length; i++) {

            // 去重
            // 为什么 used[i - 1] == false 就是同一树层呢，因为同一树层，used[i - 1] == false 才能表示，当前取的 candidates[i] 是从 candidates[i - 1] 回溯而来的。
            if (i > 0 && candidates[i] == candidates[i - 1] && used[i - 1] == 0) {
                continue;
            }

            path.add(candidates[i]);
            sum += candidates[i];
            used[i] = 1;

            backtracking(candidates, target, res, path, sum, i + 1, used);

            path.removeLast();
            sum -= candidates[i];
            used[i] = 0;
        }


    }


}
