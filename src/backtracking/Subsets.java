package backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 78.子集
 *
 * @author kundy
 * @date 2023/12/19 14:21
 */
public class Subsets {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtracking(nums, res, new LinkedList<>(), 0);
        return res;
    }

    public void backtracking(int nums[], List<List<Integer>> res, LinkedList<Integer> path, int startIndex) {

        // 每一个节点都要添加到结果集中
        res.add(new ArrayList<>(path));


        for (int i = startIndex; i < nums.length; i++) {

            path.add(nums[i]);

            backtracking(nums, res, path, i + 1);

            path.removeLast();

        }

    }

}
