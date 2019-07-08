import java.util.LinkedList;

/**
 * 按奇偶排序数组
 * <p>
 * 需求：偶数放前面，基数放后面
 * <p>
 * 解题思路：
 * 方法一：新建LinkedList，如果是偶数调用LinkedList#addFirst()，否则调用 LinkedList#addLast() 方法。（效率低，击败5.4%）
 * 方法二：新建一个数组和头尾两个指针进行插入。
 *
 * @author kundy
 * @date 2019/7/8 5:43 PM
 */
public class SortArrayByParity {

    /**
     * 击败5.4%，哭了
     */
    public static int[] wayOne(int[] A) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int num : A) {
            if (num % 2 == 0) {
                linkedList.addFirst(num);
            } else {
                linkedList.addLast(num);
            }
        }

        int[] result = new int[linkedList.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = linkedList.get(i);
        }
        return result;
    }

    /**
     * 击败99.33%
     */
    public static int[] wayTwo(int[] A) {
        int[] result = new int[A.length];
        int left = 0;
        int right = A.length - 1;
        for (int num : A) {
            if (num % 2 == 0) {
                result[left++] = num;
            } else {
                result[right--] = num;
            }
        }
        return result;
    }

}
