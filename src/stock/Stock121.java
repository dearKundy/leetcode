package stock;

/**
 * 121. 买卖股票的最佳时机【只能买一次和卖一次】
 *
 * @author kundy
 * @date 2022/6/13 22:42
 */
public class Stock121 {

    public static void main(String[] args) {
        System.out.println(new Stock121().way2(new int[]{7, 1, 5, 3, 6, 4}));
    }

    /**
     * 超时。。。
     */
    public int maxProfit(int[] prices) {

        int low = prices[0];
        int maxProfit = 0;

        for (int i = 0; i < prices.length; i++) {
            if (low < prices[i]) {
                continue;
            }

            low = prices[i];

            for (int j = i + 1; j < prices.length; j++) {
                maxProfit = Math.max(maxProfit, prices[j] - low);
            }
        }

        return maxProfit;

    }

    public int way2(int[] prices) {

        int lowestPrice = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {

            if (prices[i] < lowestPrice) {
                lowestPrice = prices[i];
            } else if (prices[i] - lowestPrice > maxProfit) {
                maxProfit = prices[i] - lowestPrice;
            }

        }

        return maxProfit;
    }

}
