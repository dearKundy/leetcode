package greedy;

import java.util.Arrays;

/**
 * 455. 分发饼干
 *
 * @author kundy
 * @date 2023/12/18 21:09
 */
public class Candy {

    // 测试findContentChildren
    public static void main(String[] args) {
        int[] g = {1, 2, 3};
        int[] s = {1, 1};
        System.out.println(new Candy().findContentChildren(g, s));
    }

    public int findContentChildren(int[] g, int[] s) {

        Arrays.sort(g);
        Arrays.sort(s);

        int res = 0;

        // 当前最大的饼干
        int curBiggestBiscuitIndex = s.length - 1;
        // 从尾到头遍历所有的孩子
        for (int i = g.length - 1; i >= 0; i--) {

            // 用当前最大的饼干喂当前的孩子，如果最大的饼干都满足不了，那这个孩子就喂不饱了，只能跳过
            if (curBiggestBiscuitIndex >= 0 && s[curBiggestBiscuitIndex] >= g[i]) {
                // 成功喂了一个孩子
                res++;
                // 成功喂了一个孩子之后，当前最大饼干的索引要前移，不能重复喂
                curBiggestBiscuitIndex--;
            }


        }
        return res;

    }

}
