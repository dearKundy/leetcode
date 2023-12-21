package greedy;

/**
 * 53. 最大子数组和
 *
 * @author kundy
 * @date 2023/12/20 18:36
 */
public class MaxSubArray {

    public int maxSubArray(int[] nums) {

        int curSum = 0;
        // 这个必须初始化为最小值，不能初始化为0，要不然如果最大和是负数的时候，就没办法更新结果
        int res = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {

            // 先加了再说
            curSum += nums[i];
            // 如果当前累加和大于结果，就更新结果，有更大的肯定要更新啦
            if (curSum > res) {
                res = curSum;
            }

            // 一旦当前累加和小于0，证明就断了，当前这一轮的最大和就到这里结束了，因为后面再加上这一轮的和只会导致结果更小
            // 所以这里将和置为0，重新开始新的一轮累加
            if (curSum < 0) {
                curSum = 0;
            }

        }

        return res;
    }

}
