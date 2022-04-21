package offer;

/**
 * 打印从1到最大的n位数
 *
 * @author kundy
 * @date 2022/4/21 10:27 AM
 */
public class PrintNumbers {

    public static int[] go(int n) {
        int limit = (int) Math.pow(10, n) - 1;
        int[] result = new int[limit];
        for (int i = 0; i < limit; i++) {
            result[i] = i + 1;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] go = go(3);
        for (int i = 0; i < go.length; i++) {
            System.out.print(go[i] + ",");
        }
    }

}
