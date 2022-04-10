package offer;

/**
 * 二维数组中的查找
 * <p>
 * 需求：在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * <p>
 * 我们要完成一个遍历，首先要找到一条好路：要么往A方向走，要么往B方向走。
 * 不好的路：一会左一会右一会上一会下，飘忽不定。
 * <p>
 * 按照上面的原则，二维数组从左到右、从上到下递增，我们可以观察得到从右上角、左上角开始都符合好路的的标准
 * 拿右上角开始举例子，同一行的左边都比当前元素小，同一列的下面都比当前元素大。
 * <p>
 * 那么我们可以从右上角开始，目标元素比当前节点小则左移，否则下移，直到当前节点为空或者相等
 *
 * @author kundy
 * @date 2022/4/9 8:37 PM
 */
public class FindNumberIn2DArray {

    private static int[][] MATRIX = new int[][]{
            {1, 4, 7, 11, 15},
            {2, 5, 8, 12, 19},
            {3, 6, 9, 16, 22},
            {10, 13, 14, 17, 24},
            {18, 21, 23, 26, 30}
    };

    /**
     * 行数
     */
    static int rowNum = MATRIX.length;
    /**
     * 列数
     */
    static int colNum = MATRIX[0].length;

    public static boolean go(int target) {

        // 初始化坐标，右上角
        int currentX = colNum - 1;
        int currentY = 0;

        // X轴没有往左溢出、Y轴都没有往下溢出，则可以一直循环
        // currentX==0，currentY=rowNum-1时，还可以进来吗？当然可以
        while (currentX >= 0 && currentY < rowNum) {

            int currentNum = MATRIX[currentY][currentX];

            if (currentNum == target) {
                return true;
            }

            // 如果当前值小于目标值，往下
            if (currentNum < target) {
                currentY++;
            }

            // 如果当前值大于目标值，往左
            if (currentNum > target) {
                currentX--;
            }
        }

        return false;

    }

    public static void main(String[] args) {
        System.out.println(go(5));
        System.out.println(go(9));
        System.out.println(go(14));
        System.out.println(go(26));
        System.out.println(go(18));
        System.out.println(go(996));
        System.out.println(go(226));
    }

}
