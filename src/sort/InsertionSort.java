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

        // 已排序队列的边界（已排序的放在队列的左边），这里是 【array.length - 1】，因为i是表示，在i之前（包括i）都是有序的，所以在 【i=array.length - 1】时，再拿最后一个元素进行比较插入，这时就是最后一轮了
        for (int i = 0; i < array.length - 1; i++) {

            // 未排好序的队列的第一个元素插入到已排序队列的正确位置，插入的方式是逐个比对，不满足则向前滚动
            for (int j = i + 1; j > 0; j--) {

                if (array[j] < array[j - 1]) {
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
