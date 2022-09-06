import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 56. 合并区间
 *
 * @author kundy
 * @date 2022/9/6 21:11
 */
public class Merge {

    public int[][] merge(int[][] intervals) {

        if (intervals.length == 0) {
            return new int[0][2];
        }

        // 按左区间从小到大排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        List<int[]> res = new ArrayList<>();

        for (int[] interval : intervals) {

            // 当前待处理的区间左右端点
            int left = interval[0];
            int right = interval[1];

            // 如果结果数组为空，直接将当前区间数组加入
            if (res.isEmpty()) {
                res.add(new int[]{left, right});
            }
            // 如果当前区间数组的左端点比结果数组中最后一个区间的右端点大，表明两个区间不重合，直接加入
            if (res.get(res.size() - 1)[1] < left) {
                res.add(new int[]{left, right});
            }
            // 否则当前区间与结果数组最后一个区间的右端点大，重合，重置结果数组中最后一个区间的右端点，值取两者中右端点较大的值
            else {
                res.get(res.size() - 1)[1] = Math.max(res.get(res.size() - 1)[1], right);
            }

        }

        return res.toArray(new int[res.size()][]);
    }

}
