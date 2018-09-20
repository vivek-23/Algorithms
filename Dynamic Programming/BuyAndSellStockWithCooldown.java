/*

Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times) with the following restrictions:

You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)
Example:

Input: [1,2,3,0,2]
Output: 3 
Explanation: transactions = [buy, sell, cooldown, buy, sell]
*/
class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length < 2) return 0;
        int[] dp = new int[prices.length];
        dp[0] = 0;
        
        for(int i=1;i<prices.length;++i){
            dp[i] = dp[i-1];
            for(int j=0;j<i;++j){
                int prev_profit = j - 2 < 0 ? 0 : dp[j-2];
                dp[i] = Math.max(dp[i],prev_profit + prices[i] - prices[j]);
            }
        }
        
        return dp[prices.length-1];
    }
}
