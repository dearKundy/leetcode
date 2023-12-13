import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 77.组合
 * @author kundy
 * @date 2023/12/13 10:29
 */
public class Combine {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        backtracking(n, k, res, new LinkedList<>(), 1);
        return res;
    }

    /**
     * 这个方法的核心是不断往 path 中添加一个合适的元素
     */
    public void backtracking(int n, int k, List<List<Integer>> res, LinkedList<Integer> path, int startIndex) {

        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }

        // 不剪枝
//        int loopCount = n;

        // 剪枝（想要有解，至多可以这个位置开始，从这个位置以后的元素为起点的都无解了，凑不够数了）
        int loopCount = n - (k - path.size()) + 1;

        // 处理 startIndex 及其以后的集合
        for (int i = startIndex; i <= loopCount; i++) {
            // 当前遍历到的元素加入到路径中
            path.add(i);
            // 接下来，需要在 startIndex 之后的元素中继续寻找合适的元素
            backtracking(n, k, res, path, i + 1);
            // 回溯，从一个很简单的角度去看【从第一层去看第一层的循环】，代码执行到这里之后，证明第i个为起点的路径已经处理完了，自然要把第i个元素从path中移除，path才能从下一个path中开始
            path.removeLast();
        }

    }





}
