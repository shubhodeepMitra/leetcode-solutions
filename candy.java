//https://leetcode.com/problems/candy/
class Solution {
    // O(n*n) approach
    // public int candy(int[] ratings) {
    //     int[] res= new int[ratings.length];
    //     res[0]=1;
    //     int l=ratings.length;
    //     for(int i=1;i<l;i++) {
    //         res[i]=(ratings[i]>ratings[i-1])?res[i-1]+1:1;
    //         if(ratings[i]>ratings[i-1])
    //             continue;
    //         for(int j=i;j>0;j--){
    //             if(ratings[j-1]>ratings[j] && res[j-1]<=res[j])
    //                 res[j-1]=res[j]+1;
    //             else 
    //                 break;
    //         }
    //     }
    //     int candy=0;
    //     for(int i=0;i<l;i++)
    //         candy+=res[i];
    //     return candy;
    // }
    public int candy(int[] ratings) {
        int l= ratings.length;
        int[] candies =  new int[l];
        for(int i=0;i<l;i++)
            candies[i]=1;
        for(int i=1;i<l;i++)
            if(ratings[i]>ratings[i-1])
                candies[i]=candies[i-1]+1;
        
        int sum = candies[l-1];
        for(int i=l-2;i>=0;i--){
            if(ratings[i]>ratings[i+1]) {
                candies[i] = Math.max(candies[i+1]+1, candies[i]);
            }
            sum+=candies[i];
        }
        return sum;
    }
}