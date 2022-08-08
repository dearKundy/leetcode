package offer;

/**
 * 剑指 Offer 56 - I. 数组中数字出现的次数
 *
 * @author kundy
 * @date 2022/8/8 20:42
 */
public class SingleNumbers {

    public static void main(String[] args) {
        int[] ints = new SingleNumbers().singleNumbers(new int[]{1, 1, 2, 2, 3, 4});
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }

    public int[] singleNumbers(int[] nums) {

        int xXorY = 0;
        // 求 x 异或 y
        for (int num : nums) {
            xXorY ^= num;
        }

        // 找出x异或y的第一位为1的二进制
        int m = 1;
        while ((xXorY & m) == 0) {
            m <<= 1;
        }

        // 我们只需要将x、y分开，然后其他相同的数组放在同一组即可
        // 当x & m、y & m 的结果必然是不同的，所以x、y必然能分开
        // 相同的数组 & m结果必然是相同的，所以相同的数字可以分到同一组
        // 注意，这两组数字的长度不需要相等，不影响结果
        int x = 0, y = 0;
        for (int num : nums) {
            if ((num & m) == 0) {
                x ^= num;
            } else {
                y ^= num;
            }
        }

        return new int[]{x, y};

    }


}
