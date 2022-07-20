package offer;

import java.util.Arrays;

/**
 * @author kundy
 * @date 2022/7/20 20:44
 */
public class MinNumber {


    public static void main(String[] args) {

        System.out.println(new MinNumber().minNumber(new int[]{3, 30, 34, 5, 9}));
    }

    public String minNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strs, (x, y) -> (x + y).compareTo(y + x));
        StringBuilder stringBuilder = new StringBuilder();
        for (String str : strs) {
            stringBuilder.append(str);
        }

        return stringBuilder.toString();
    }

}
