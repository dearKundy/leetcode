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

        // 每一轮最大的元素，放到已排序队列的末尾
        for (int i = array.length - 1; i > 0; i--) {

            // 记录当前这一轮的最大值的坐标
            int maxIndex = 0;

            // 从未排好序的数组中找出最大值，这里 j<= i，因为最大值也有可能是在坑位中的这个
            for (int j = 0; j <= i; j++) {
                if (array[j] > array[maxIndex]) {
                    maxIndex = j;
                }
            }

            // 将当前找到的最大值与已排序队列的末尾元素进行交换（放进坑位）
            if (maxIndex != i) {
                swap(array, i, maxIndex);
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
