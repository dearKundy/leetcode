package offer;

import java.util.*;

/**
 * 剑指 Offer 49. 丑数
 * 第N个丑数，一定是 2X 3X 5X ，每次都取当前最小的数，分乘2、3、5，第N次最小堆堆顶就是第N个丑数
 *
 * @author kundy
 * @date 2022/8/1 22:08
 */
public class NthUglyNumber {

    public static void main(String[] args) {
        System.out.println(new NthUglyNumber().nthUglyNumber(10));
    }

    public int nthUglyNumber(int n) {

        PriorityQueue<Long> smallHeap = new PriorityQueue<>();
        Set<Long> seen = new HashSet<>();
        List<Integer> factors = Arrays.asList(2, 3, 5);

        smallHeap.offer(1L);
        seen.add(1L);
        Long res = 1L;

        for (int i = 0; i < n; i++) {

            res = smallHeap.poll();

            for (Integer factor : factors) {
                if (seen.add(res * factor)) {
                    smallHeap.offer(res * factor);
                }
            }

        }

        return res.intValue();
    }

}
