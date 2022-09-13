import java.util.ArrayList;
import java.util.List;

/**
 * 46. 全排列
 *
 * @author kundy
 * @date 2022/9/13 21:24
 */
public class Permute {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        Permute solution = new Permute();
        List<List<Integer>> lists = solution.permute(nums);
        System.out.println(lists);
    }


    public List<List<Integer>> permute(int[] nums) {

        int length = nums.length;
        List<List<Integer>> res = new ArrayList<>();

        if (length == 0) {
            return res;
        }

        List<Integer> path = new ArrayList<>();
        boolean[] isUsed = new boolean[length];
        int depth = 0;

        dfs(nums, res, path, isUsed, depth, length);

        return res;
    }

    public void dfs(int[] nums, List<List<Integer>> res, List<Integer> path, boolean[] isUsed, int depth, int length) {

        if (depth == length) {
            // 拷贝path，如果直接add path，因为path指向的是同一个对象，回溯操作会导致最终path为空，最终res为N个空数组
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < length; i++) {

            if (!isUsed[i]) {
                path.add(nums[i]);
                isUsed[i] = true;

                dfs(nums, res, path, isUsed, depth + 1, length);

                path.remove(path.size() - 1);
                isUsed[i] = false;
            }

        }

    }

}
