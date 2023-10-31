package org.resume.slidingWindow;

public class SellAndBuyStocks {


    public SellAndBuyStocks(int[] prices) {
        int mProfit = maxProfit(prices);
        System.out.println("Max profit from these prices was: "  + mProfit);
    }

    private int maxProfit(int[] prices) {

        int l=0, r=1;
        int maxP = 0;
        // two pointer solution, keep l on the lowest, r on the highest
        while (r < prices.length) {
            if (prices[l] < prices[r]) {
                maxP = Math.max(maxP, prices[r] - prices[l]);
            }else {
                l = r;
            }
            r++;
        }
        return maxP;
    }
}
