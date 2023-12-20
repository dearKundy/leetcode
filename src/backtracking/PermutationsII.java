package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 47. 全排列 II
 *
 * @author kundy
 * @date 2023/12/20 18:14
 */
public class PermutationsII {

    public List<List<Integer>> permuteUnique(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(nums);
        backtracking(nums, res, new LinkedList<>(), new int[nums.length]);

        return res;
    }

    public void backtracking(int nums[], List<List<Integer>> res, LinkedList<Integer> path, int[] used) {

        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {

            // 树层去重
            if (i > 0 && nums[i] == nums[i - 1] && used[i - 1] == 0) {
                continue;
            }

            // 树枝去重
            if (used[i] == 1) {
                continue;
            }

            path.add(nums[i]);
            used[i] = 1;

            backtracking(nums, res, path, used);

            path.removeLast();
            used[i] = 0;

        }


    }

}
