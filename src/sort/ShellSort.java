package sort;

/**
 * 希尔排序
 *
 * @author kundy
 * @date 2023/12/5 21:06
 */
public class ShellSort {

    // 测试 ShellSort
    public static void main(String[] args) {
        int[] arr = {1, 8, 3, 4, 7, 0, 7, 8, 9, 10};
        shellSort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    public static void shellSort(int[] arr) {

        // 以gap为间隙，进行N轮插入排序，最终gap一定要等于1
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {

            // 从gap开始，每一个元素都要与他前面间隔为gap的倍数的元素进行插入排序
            for (int i = gap; i < arr.length; i++) {
                // 这里负责取间隙为gap倍数的元素
                for (int j = i; j > gap - 1; j -= gap) {
                    if (arr[j] < arr[j - gap]) {
                        swap(arr, j - gap, j);
                    }
                }
            }
        }


    }

    private static void swap(int[] arr, int idxOne, int indexTwo) {
        int temp = arr[indexTwo];
        arr[indexTwo] = arr[idxOne];
        arr[idxOne] = temp;
    }

}
