public class BestTimeBuySellStock {
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }
    public static int maxProfit(int[] prices) {
        int buy = prices[0];
        int sell = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < buy) buy = prices[i];
            sell = Math.max(sell, prices[i] - buy);
        }
        return sell;
    }
}
