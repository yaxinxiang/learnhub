package leetcode;

public class Lc121 {
    public int maxProfit(int[] prices) {
        int preMin = prices[0];
        int profit = 0;
        for (int price : prices){
            profit =  Math.max(price - preMin, profit);
            preMin = Math.min(price, preMin);
        }
        return profit;
    }
}
