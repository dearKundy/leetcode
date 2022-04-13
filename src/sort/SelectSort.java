package sort;

/**
 * 选择排序【每一轮，将最大/最小的元素放在已排序队列的末尾】
 *
 * @author kundy
 * @date 2022/3/2 3:31 PM
 */
public class SelectSort {

    public static void main(String[] args) {
        Integer[] array = new Integer[]{5, 2, 6, 2, 7, 3, 9, 1};
        print(sort(array));
    }

    public static Integer[] sort(Integer[] array) {

        int length = array.length;

        // 为每一个元素找到它应该与哪一个元素交换位置
        for (int i = 0; i < length; i++) {

            // 假设当前元素就是最大值
            int maxPos = i;

            // 选出当前这一轮最大的元素下标
            for (int j = i + 1; j < length; j++) {
                if (array[j] > array[maxPos]) {
                    maxPos = j;
                }
            }

            if (maxPos != i) {
                swap(array, i, maxPos);
            }

        }
        return array;
    }

    private static void print(Integer[] array) {
        for (Integer integer : array) {
            System.out.print(integer + " ");
        }
    }

    private static void swap(Integer[] array, Integer idxOne, Integer idxTwo) {

        Integer tmp = array[idxOne];
        array[idxOne] = array[idxTwo];
        array[idxTwo] = tmp;

    }

}
