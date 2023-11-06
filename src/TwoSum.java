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

        // 用 Map 将数组中的【数值】与其对应的【索引】保存起来，
        // key=数值，value=索引
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < array.length; i++) {

            // 先将当前的元素存储起来
            map.put(array[i], i);
            // 当前元素array[i]的匹配数值
            int tmpNum = target - array[i];
            // 到map中寻找匹配数值，如果找到可返回
            if (map.containsKey(tmpNum)) {
                // map中元素在前，因为能从map中取出的，证明肯定是先放进去的
                return new int[]{map.get(tmpNum), i};
            }

        }
        return null;
    }

}
