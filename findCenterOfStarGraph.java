// https://leetcode.com/problems/find-center-of-star-graph/
class Solution {
    public int findCenter(int[][] edges) {
        List<List<Integer>> adList = new ArrayList<>();
        
        for(int i=0;i<edges.length+2;i++)
            adList.add(new ArrayList<>());
        
        for(int[] edge:edges){
            adList.get(edge[0]).add(edge[1]);
            adList.get(edge[1]).add(edge[0]);
        }
        
        
        for(int i=0;i<adList.size();i++) {
            if(adList.get(i).size()==edges.length)
                return i;
        }
        
        return -1;
        
    }
}