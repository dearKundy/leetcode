package backtracking;

import java.util.*;

/**
 * 90.子集II
 *
 * @author kundy
 * @date 2023/12/19 14:47
 */
public class SubsetsII {


    // 测试 subsetsWithDup
    public static void main(String[] args) {

        int[] nums = {3, 2, 1};

        SubsetsII subsetsII = new SubsetsII();

        List<List<Integer>> res = subsetsII.subsetsWithDup(nums);

        System.out.println(res);

    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        // 求子集是可以排序的 [1,2,3] 和 [2,3,1]是属于同一个解
        Arrays.sort(nums);
        backtracking(nums, res, new LinkedList<>(), 0);
        return res;
    }

    public void backtracking(int nums[], List<List<Integer>> res, LinkedList<Integer> path, int startIndex) {

        res.add(new ArrayList<>(path));

        for (int i = startIndex; i < nums.length; i++) {

            if (i > startIndex && nums[i] == nums[i - 1]) {
                continue;
            }

            path.add(nums[i]);

            backtracking(nums, res, path, i + 1);

            path.removeLast();

        }

    }

}
