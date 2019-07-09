import java.util.HashSet;
import java.util.Set;

/**
 * 重复 N 次的元素
 * <p>
 * 需求：大小为 2N 的数组中含有 N+1 中元素，返回重复了 N 次的那个元素。
 * <p>
 * 解题思路：
 * 如果 2N 个元素全部都是不重复的，就会有 2N 种元素，但是现在只有 N+1 种元素，说明有一种元素重复了 N 次，而其他元素都是唯一的。
 * 所以只要某个元素重复出现，立即返回即可。
 *
 * 解决方案：
 * - 利用 HashSet。
 * - 利用数组。
 *
 * @author kundy
 * @date 2019/7/9 4:33 PM
 */
public class RepeatedNTimes {

    public static void main(String[] args) {
        System.out.println(wayOne(new int[]{5, 1, 5, 2, 5, 3, 5, 4}));
    }

    public static int wayOne(int[] A) {
        Set<Integer> set = new HashSet<>();
        for (int num : A) {
            if (set.contains(num)) {
                return num;
            }
            set.add(num);
        }
        return -1;
    }

    public static int wayTwo(int[] A) {
        int[] count = new int[10000];
        for (int a : A) {
            if (count[a]++ == 1) {
                return a;
            }

        }
        return -1;
    }
}
