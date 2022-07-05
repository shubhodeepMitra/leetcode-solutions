// https://leetcode.com/problems/daily-temperatures/
class Solution {
// Naive O(n*n) Solution
//     public int[] dailyTemperatures(int[] temperatures) {
//         int l = temperatures.length;
//         int[] res= new int[l];
        
//         for(int i=0;i<l;i++) {
//             for(int j=i+1;j<l;j++) {
//                 if(temperatures[j]>temperatures[i]){
//                     res[i]=j-i;
//                     break;
//                 }
//             }
//         }
//         return res;
//     }

    // Using monotonic stack to get the next bigger number
    public int[] dailyTemperatures(int[] temperatures) {
        int l = temperatures.length;
        int[] res = new int[l];
        Stack<Integer> stack = new Stack<>(); //monotonic decreasing stack containing the indices
        
        for(int i=0;i<l;i++) {
            while(!stack.isEmpty() && temperatures[stack.peek()]<temperatures[i]) {
                int indexToBeUpdated = stack.pop();
                res[indexToBeUpdated] = i-indexToBeUpdated;
            }
            stack.push(i);
        }
        return res;
    }
}