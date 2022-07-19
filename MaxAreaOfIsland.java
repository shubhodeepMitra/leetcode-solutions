// https://leetcode.com/problems/max-area-of-island/
class pair {
    int r;int c;
    pair() {
        
    }
    pair(int r, int c) {
        this.r=r;
        this.c=c;
    }
}
class Solution {
    int maxArea=0;
    void bfs(int[][] grid, int[][] visited, int i, int j) {
        int r=grid.length;
        int c=grid[0].length;
        int area=0;
        Queue<pair> q = new LinkedList<>();
        q.offer(new pair(i,j));
        int[] dir = {-1,0,1,0,-1};
        while(!q.isEmpty()) {
            pair cur = q.poll();
            area+=1;
            for(int k=0;k<4;k++) {
                int rr = cur.r+dir[k];
                int cc = cur.c+dir[k+1];
                if(rr>=0 && cc>=0 && rr<r && cc<c && grid[rr][cc]==1 && visited[rr][cc]==0) {
                    visited[rr][cc]=1;
                    q.offer(new pair(rr, cc));
                }
            }
        }
        if(area>maxArea)
            maxArea=area;     
    }
    public int maxAreaOfIsland(int[][] grid) {
        if(grid==null || grid.length==0)
            return maxArea;
        int r=grid.length;
        int c=grid[0].length;
        
        int[][] visited = new int[r][c];
        for(int i=0;i<r;i++) {
            for(int j=0;j<c;j++) {
                if(grid[i][j]==1 && visited[i][j]==0) {
                    visited[i][j]=1;
                    bfs(grid, visited, i, j);
                }
                   
            }
        }
        return maxArea;
    }
}