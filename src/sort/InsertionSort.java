package sort;

/**
 * 插入排序【可以理解为边插入边排序，如果数组本来就有序，那么就只需要比较1+1+1+1+1次】
 *
 * @author kundy
 * @date 2022/4/13 10:51 PM
 */
public class InsertionSort {


    public static void main(String[] args) {
        Integer[] array = new Integer[]{5, 2, 6, 2, 7, 3, 9, 1};
        print(sort(array));
    }

    public static Integer[] sort(Integer[] array) {

        // 通过i控制要进行比较的元素
        for (int i = 1; i < array.length; i++) {

            // 从左往右开始，将第i个元素依次与已经排好序的队列一一进行比较
            for (int j = i; j > 0; j--) {
                if (array[j] < array[j - 1]) {
                    // 交换
                    swap(array, j, j - 1);
                }
            }

        }

        return array;
    }

    private static void swap(Integer[] array, Integer idxOne, Integer idxTwo) {

        Integer tmp = array[idxOne];
        array[idxOne] = array[idxTwo];
        array[idxTwo] = tmp;

    }

    private static void print(Integer[] array) {
        for (Integer integer : array) {
            System.out.print(integer + " ");
        }
    }

}
