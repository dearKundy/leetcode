package offer;

import java.util.*;

/**
 * 数组中重复的数字
 *
 * @author kundy
 * @date 2022/4/9 10:37 AM
 */
public class FindRepeatNum {

    private static final int[] ARRAY = new int[]{4, 3, 2, 0, 4, 5, 3};

    /**
     * 数组中第一个重复的元素，使用HashMap，不优雅
     */
    public static Integer firstDuplicateV1() {

        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i : ARRAY) {

            // 统计当前数字出现次数
            Integer curCount = countMap.get(i);
            curCount = curCount == null ? 1 : ++curCount;

            countMap.put(i, curCount);
            if (curCount >= 2) {
                return i;
            }

        }
        return null;
    }

    /**
     * 数组中第一个重复的元素，使用HashSet
     */
    public static Integer firstDuplicateV2() {
        Set<Integer> set = new HashSet<>();
        for (int i : ARRAY) {
            // 添加失败表明重复
            if (!set.add(i)) {
                return i;
            }
        }
        return null;
    }

    /**
     * 重复的元素有哪些
     */
    public static List<Integer> duplicateList() {
        List<Integer> result = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int i : ARRAY) {
            // 添加失败表明重复
            if (!set.add(i)) {
                result.add(i);
            }
        }
        return result;
    }


    public static void main(String[] args) {
        System.out.println(duplicateList());
    }

}
