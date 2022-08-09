package offer;

/**
 * @author kundy
 * @date 2022/8/9 20:54
 */
public class FindNthDigit {

    public static void main(String[] args) {
        System.out.println(new FindNthDigit().findNthDigit(1000000000));
        System.out.println(new FindNthDigit().findNthDigit(11));
    }

    public int findNthDigit(int n) {

        // 所在数字的位数
        int digital = 1;
        // 起始数字
        long start = 1;
        // 初始位数总数
        long count = 9;

        while (n > count) {

            n -= count;

            // 1 2 3 4 5
            digital += 1;
            // 10 100 1000 10000
            start *= 10;

            count = start * 9 * digital;
        }

        long num = start + ((n - 1) / digital);

        return (int) String.valueOf(num).charAt((n - 1) % digital) - '0';


    }


}
