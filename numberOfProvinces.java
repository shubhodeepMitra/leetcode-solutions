// https://leetcode.com/problems/number-of-provinces/
class Solution {
    int provinces;
    void DFS(List<List<Integer>> adList, int[] visited, int curCity) {
        if(visited[curCity]==1)
            return;
        visited[curCity]=1;
        
        for(int i=0;i<adList.get(curCity).size();i++) {
            if(visited[adList.get(curCity).get(i)]==0)
                DFS(adList, visited, adList.get(curCity).get(i));
        }
    }
    public int findCircleNum(int[][] isConnected) {
        List<List<Integer>> adList = new ArrayList<>();
        int nCity = isConnected.length;
        adList.add(new ArrayList<>());
        
        for(int i=0;i<nCity;i++) {
            adList.add(new ArrayList<>());
            
            for(int j=0;j<isConnected[i].length;j++) {
                    if(isConnected[i][j]==1 && j!=i) {
                        adList.get(i+1).add(j+1);
                    }   
            }            
        }
        
        int[] visited = new int[nCity+1];
        provinces=0;
        for(int i=1;i<=nCity;i++){
            if(visited[i]==0) {
                provinces+=1;
                
                DFS(adList, visited, i);
            }
        }
        return provinces;        
    }
}