import java.util.Arrays;

/**
 * 42. 接雨水【第二道纯靠自己 AC 的 difficult 题】
 *
 * @author kundy
 * @date 2022/8/25 21:33
 */
public class Trap {

    public static void main(String[] args) {
        System.out.println(new Trap().trap(new int[]{0, 3, 0, 2, 1, 0, 1, 31, 2, 1, 2, 1}));
    }

    public int trap(int[] height) {
        int maxHeight = Arrays.stream(height).max().getAsInt();

        int res = 0;

        for (int i = 0; i < maxHeight; i++) {
            int left = 0;
            int right = height.length - 1;

            // 第N层的左墙
            while (height[left] - i <= 0 && left < height.length - 1) {
                left++;
            }

            // 第N层的右墙
            while (height[right] - i <= 0 && right > 0) {
                right--;
            }

            // 统计每一层的容量
            if (left < right) {
                for (int j = left; j < right; j++) {
                    if (height[j] - i <= 0) {
                        res++;
                    }
                }
            }

        }

        return res;
    }

}
