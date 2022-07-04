// https://leetcode.com/problems/maximum-units-on-a-truck/
class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        int max=0;
        Arrays.sort(boxTypes, (a,b)->b[0]-a[0]);
        Arrays.sort(boxTypes, (a,b)->b[1]-a[1]);
        
        System.out.println(Arrays.deepToString(boxTypes));
        int index=0, l=boxTypes.length, cur=0,boxesSoFar=0;
        for(int[] box: boxTypes){
            int boxesUnit = box[0]*box[1];
            if(boxesSoFar+box[0]>truckSize) {
                int partialBox = (truckSize-boxesSoFar)*box[1];
                if(partialBox+cur>max)
                    max=partialBox+cur;
                while(boxesSoFar+box[0]>truckSize){
                    boxesSoFar-=boxTypes[index][0];
                    cur-=(boxTypes[index][0]*boxTypes[index][1]);
                    index+=1;
                }
            }
            cur+=boxesUnit;
            boxesSoFar+=box[0];
            if(cur>max)
                max=cur;
        }
        
        return max;
    }
}