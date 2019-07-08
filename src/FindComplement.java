/**
 * 数字的补数
 * <p>
 * 需求：将某个数字的二进制全部取反。
 * <p>
 * 解题思路：
 * - 将N个1与该数字的二进制进行异或运算即可，其中N为该数字的二进制位数。
 * <p>
 * 我使用了字符串拼接的方式生成 N 个 1，效率极低。
 * 如果可以使用某种算法高效生成 N 个 1 （例如通过移位运算），即可优化。
 *
 * @author kundy
 * @date 2019/7/6 9:51 PM
 */
public class FindComplement {

    /**
     * 击败7%
     */
    public int findComplement(int num) {
        String binaryString = Integer.toBinaryString(num);
        StringBuilder tmp = new StringBuilder();
        for (int i = 0; i < binaryString.length(); i++) {
            tmp.append(1);
        }
        return num ^ Integer.valueOf(tmp.toString(), 2);
    }

}
