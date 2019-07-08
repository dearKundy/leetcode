/**
 * 山脉数组的峰顶索引
 * <p>
 * 需求：
 * 找出数组中最大的元素，该元素位于数组的中间。
 * <p>
 * 解题思路：
 * 出现第一个A[i] > A[i+1] 时，i 便是最大值位置。
 *
 * @author kundy
 * @date 2019/7/6 3:19 PM
 */
public class PeakIndexInMountainArray {

    public int peakIndexInMountainArray(int[] A) {
        for (int i = 0; i < A.length; i++) {
            if (A[i] > A[i + 1]) {
                return i;
            }
        }
        return 0;
    }

}
