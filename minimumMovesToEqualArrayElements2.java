// https://leetcode.com/problems/minimum-moves-to-equal-array-elements-ii/
class Solution {
    public int minMoves2(int[] nums) {
        int l = nums.length;
        Arrays.sort(nums);
        // int pivot = nums[l/2];
        int count = 0;
        for (int i =0;i<l/2;i++) {
            count+=Math.abs(nums[i] - nums[l - i - 1]);
        }
        return count;
    }
}