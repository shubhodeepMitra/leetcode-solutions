// https://leetcode.com/problems/min-cost-climbing-stairs/
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length+1];
        dp[0]=cost[0];
        if(cost==null || cost.length==0)
            return 0;
        if(cost.length==1)
            return cost[0];
        dp[1] = cost[1];
        
        for(int i=2;i<cost.length;i++) {
            dp[i] = Math.min(dp[i-1],dp[i-2])+cost[i];
        }
        dp[cost.length] = Math.min(dp[cost.length-1], dp[cost.length-2]);
        return dp[cost.length];
    }
}