// https://leetcode.com/problems/search-a-2d-matrix-ii/
class Solution {
    // boolean SearchRow(int[][] matrix, int target, int row) {
    //     int l=0,h = matrix[row].length-1,m;
    //     while(l<=h) {
    //         m= l +(h-l)/2;
    //         if(matrix[row][m]==target)
    //             return true;
    //         else if(matrix[row][m]<target)
    //             l=m+1;
    //         else
    //             h=m-1;
    //     }
    //     return false;        
    // }
    // public boolean searchMatrix(int[][] matrix, int target) {
    //     int r=matrix.length, c=matrix[0].length;
    //     for(int i=0;i<r;i++){
    //         if(target>= matrix[i][0] && target<=matrix[i][c-1] && SearchRow(matrix,target,i))
    //             return true;
    //     }
    //     return false;
    // }
    public boolean searchMatrix(int[][] matrix, int target) {
        int r=0,c=matrix[0].length-1;
        while(c>=0 && r<matrix.length) {
            if(target== matrix[r][c])
                return true;
            if(target<matrix[r][c])
                c-=1;
            else
                r+=1;
        }
        return false;
    }
}