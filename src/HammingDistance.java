/**
 * 汉明距离
 * <p>
 * 需求：求两个数字的二进制对应位不一样的数量，二进制位数不足，前面补零。
 * <p>
 * 解题思路：
 * - 这恰巧就是两个数进行异或运算的结果中 1 的数量。
 * - 使用Integer#()bitCount 取出十进制数对应的二进制数中 1 的位数。
 *
 * @author kundy
 * @date 2019/7/5 11:27 AM
 */
public class HammingDistance {

    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }

}
