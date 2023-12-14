package backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 39. 组合总和
 *
 * @author kundy
 * @date 2023/12/14 15:23
 */
public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> res = new ArrayList<>();
        backtracking(candidates, target, 0, res, new LinkedList<>(), 0);
        return res;
    }

    public void backtracking(int[] candidates, int target, int sum, List<List<Integer>> res, LinkedList<Integer> path, int startIndex) {

        // 要搞清楚这个 return 的含义，例如[1,2,3] 已经大于 target了，就没必要再以[1,2,3]为开始，继续递归寻找剩余可能了，因为都不可能了（而是应该回滚3，再找下一个）
        if (sum > target) {
            return;
        }

        if (sum == target) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIndex; i < candidates.length; i++) {

            path.add(candidates[i]);
            sum += candidates[i];

            // 元素可重复选择，所以下一轮还是从i开始
            backtracking(candidates, target, sum, res, path, i);

            path.removeLast();
            sum -= candidates[i];

        }

    }

}
