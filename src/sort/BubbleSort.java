package sort;

/**
 * 冒泡排序
 * <p>
 * 它通过不断交换相邻的元素，将较大的元素逐渐“冒泡”到数组的末尾，从而实现排序。
 *
 * @author kundy
 * @date 2022/4/12 10:44 PM
 */
public class BubbleSort {

    public static void main(String[] args) {
        Integer[] array = new Integer[]{5, 2, 6, 2, 7, 3, 9, 1};
        print(sort(array));
    }

    public static Integer[] sort(Integer[] array) {

        // 通过i控制每一轮的 "底部"，每一轮可以得出这一轮中的最大值，放在底部（分别选出冠亚季军，依次放在底部）
        // 底部不断前移
        for (int i = array.length - 1; i > 0; i--) {

            // 每一轮都是从0开始，一直比较交换，直到触底
            for (int j = 0; j < i; j++) {
                // 两者中较大的元素，提到前面一个位置，以参与下一轮的比较
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                }
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