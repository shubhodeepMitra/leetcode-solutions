//https://leetcode.com/problems/climbing-stairs/

class Solution {
public:
// Recursive Solution
//     int climbStairs(int n) {

//         if(n<0)
//             return 0;
//         if (n == 0) {
//             return 1;
//         }
//         return climbStairs(n-1) + climbStairs(n-2);
//     }
    int climbStairs(int n) {
        static int ans[46];
        if(n<0)
            return 0;
        if (n == 0) {
            return 1;
        }
        if (!ans[n])
            ans[n] = climbStairs(n-1) + climbStairs(n-2);
        return ans[n];
    }
};