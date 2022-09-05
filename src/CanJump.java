/**
 * 55. 跳跃游戏
 *
 * @author kundy
 * @date 2022/9/5 20:31
 */
public class CanJump {

    /**
     * 我能走到第i阶吗？那得问问第i-1阶它最远能走到哪里喔，如果他勾不着我，那就没办法了
     */
    public boolean canJump(int[] nums) {

        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            // 能否走到第i阶，其实取决于第i-1阶
            if (i > k) {
                return false;
            }
            // 更新第i-1阶，能走到的最远距离
            k = Math.max(k, i + nums[i]);
        }

        return true;

    }


}
