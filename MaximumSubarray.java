//https://leetcode.com/problems/maximum-subarray
class Solution {
    public int maxSubArray(int[] nums) {
        int max=nums[0];
        int cur=0;
        for(int num:nums){
            cur+=num;
            max = Math.max(cur,max);
            cur = Math.max(0, cur);            
        }
        return max;
    }
}