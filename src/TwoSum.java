import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 * <p>
 * 需求：给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。
 * <p>
 * =======================
 * 给定 nums = [2, 7, 11, 15], target = 9
 * <p>
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 * =======================
 *
 * @author kundy
 * @date 2022/2/10 4:35 PM
 */
public class TwoSum {

    private static int[] array = {2, 7, 11, 15, 4};
    private static int target = 19;


    public static void main(String[] args) {
        int[] ints = wayThree();
        for (int anInt : ints) {
            System.out.println(anInt);
        }

    }

    public static int[] wayOne() {

        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] + array[j] == target) {
                    return new int[]{i, j};
                }
            }
        }

        return null;
    }

    public static int[] wayTwo() {

        Map<Integer, Integer> map = new HashMap<>(16);
        for (int i = 0; i < array.length; i++) {
            map.put(array[i], i);
        }

        for (int i = 0; i < array.length; i++) {
            int complement = target - array[i];
            if (map.containsKey(complement) && (map.get(complement) != i)) {
                return new int[]{i, map.get(complement)};
            }
        }

        return null;
    }

    public static int[] wayThree() {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < array.length; i++) {

            map.put(array[i], i);
            int tmpNum = target - array[i];
            if (map.containsKey(tmpNum)) {
                return new int[]{map.get(tmpNum), i};
            }

        }
        return null;
    }

}
