//https://leetcode.com/problems/search-insert-position/
class Solution {
    public int searchInsert(int[] nums, int target) {
        int l=0,h=nums.length-1,m=0;
        if(nums== null || nums.length==0)
            return l;
        if(target> nums[h]) 
            return h+1;
        if(target < nums[l])
            return l;
        if(target == nums[h]) 
            return h;
        if(target == nums[l])
            return l;
       
        while(l<=h) {
            m=l+(h-l)/2;
            if(nums[m]>=target)
                h=m-1;
            else
                l=m+1;
        }
        return h+1;
    }
}