// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
class Solution {
    // Popular Method
    // public int maxProfit(int[] prices) {
    //     if(prices==null || prices.length==0)
    //         return 0;
    //     int max=0;
    //     int lowest=prices[0];
    //     for(int price: prices){
    //         lowest=Math.min(lowest, price);
    //         max=Math.max(max, price-lowest);
    //     }
    //     return max;
    // }
    /** Using Kadence to solve this
     *  get the difference between the days price and treak it as a kadence subproblem
     *  Ex: for {1, 7, 4, 11}, it gives {0, 6, -3, 7} -> then get the max in a max subarray problem
     */
     public int maxProfit(int[] prices) {
         int maxPrice=0, maxPriceSoFar=0;
         for(int i=1;i<prices.length;i++) {
             maxPrice = Math.max(0, maxPrice+=prices[i]-prices[i-1]);
             maxPriceSoFar = Math.max(maxPrice, maxPriceSoFar);
         }
         return maxPriceSoFar;
     }
}