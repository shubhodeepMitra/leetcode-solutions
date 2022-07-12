// https://leetcode.com/problems/kth-largest-element-in-an-array/
class Solution {
    void swap(int[] nums, int i, int j)
    {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    int partition(int[] nums, int low, int high) {
        int p = (int)(Math.random()*(high-low+1))+low;
        swap(nums, p, high);
        
        int index=low;
        int pivot = nums[high];
        for(int i=low;i<high;i++) {
            if(nums[i]<pivot) {
                swap(nums, i, index);
                index+=1;
            }
        }
        swap(nums, index, high);
        return index;
    }
    void quickSelectSort(int[] nums, int low, int high, int k) {
        int pivot = partition(nums, low, high);
        if(pivot==k) {
            return;
        }
        else if (pivot > k)
            quickSelectSort(nums, low, pivot-1, k);
        else
            quickSelectSort(nums, pivot+1, high, k);
        
    }
    public int findKthLargest(int[] nums, int k) {
        k= nums.length-k;
        quickSelectSort(nums, 0, nums.length-1, k);
        return nums[k];
        
    }
}