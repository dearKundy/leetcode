package backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 46.全排列
 *
 * @author kundy
 * @date 2023/12/20 14:51
 */
public class Permutations {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtracking(nums, res, new LinkedList<>());
        return res;
    }

    public void backtracking(int[] nums, List<List<Integer>> res, LinkedList<Integer> path) {

        // 排列指的是一个数组的所有排列方式【所有的元素都要使用上】
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
        }

        // 每次都重头开始，但是不能重复使用元素
        for (int i = 0; i < nums.length; i++) {

            // path中已存在的就跳过，例如，现在是已2开头，进入下一轮递归之后，还是从1开始，但是需要跳过2
            if (path.contains(nums[i])) {
                continue;
            }

            path.add(nums[i]);

            backtracking(nums, res, path);

            path.removeLast();
        }

    }

}
