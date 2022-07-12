// https://leetcode.com/problems/matchsticks-to-square/
class Solution {
    boolean solution(int[] matchsticks, int index, int s1, int s2, int s3, int s4, int side) {
        if(index==-1){
            if(s1==side && s2==side && s3==side && s4==side)
                return true;
            return false;
        }
        if(s1>side || s2>side || s3>side || s4>side)
            return false;
        return solution(matchsticks, index-1, s1+matchsticks[index], s2, s3, s4, side) ||
                solution(matchsticks, index-1, s1, s2+matchsticks[index], s3, s4, side) ||
                solution(matchsticks, index-1, s1, s2, s3+matchsticks[index], s4, side) ||
                solution(matchsticks, index-1, s1, s2, s3, s4+matchsticks[index], side);
                
    }
    public boolean makesquare(int[] matchsticks) {
        Arrays.sort(matchsticks);
        int perimeter=0;
        for(int matchstick: matchsticks)
            perimeter+=matchstick;
        
        int side = (int)(perimeter/4);
        if(side*4!=perimeter)
            return false;
        if(matchsticks[matchsticks.length-1]>side)
            return false;
        
        // int newSide =0;
        // int sqSide  =0;
        // for(int matchstick: matchsticks) {
        //     newSide+=matchstick;
        //     if(newSide==side){
        //         sqSide+=1;
        //         newSide =0;
        //     } else if(newSide>side)
        //         return false; 
        // }
        // System.out.println(side + " " + newSide + " " + sqSide);
        // return (sqSide==4)? true:false;
        
        return solution(matchsticks, matchsticks.length-1 , 0, 0, 0, 0, side);
    }
}