public class BestTimeBuySellStock2 {
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        int start = prices[0];

        for (int i = 1; i < prices.length; i++) {
            if (start < prices[i])
                maxProfit = maxProfit + prices[i] - start;
            start = prices[i];
        }
        return maxProfit;
    }
}
