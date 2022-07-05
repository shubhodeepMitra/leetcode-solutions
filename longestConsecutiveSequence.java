//https://leetcode.com/problems/longest-consecutive-sequence/
class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums==null || nums.length==0)
            return 0;
        
        HashSet<Integer> set = new HashSet<>();
        int max = 1;
        for(int num: nums) {
            set.add(num);
        }
        
        for(int num:nums){
            int seq=1, leftVal=num-1, rightVal=num+1;
            while(set.contains(leftVal)){
                seq+=1;
                set.remove(leftVal--);
            }
            while(set.contains(rightVal)) {
                seq+=1;
                set.remove(rightVal++);
            }
            
            max = Math.max(max,seq);
        }
        return max;
    }
}