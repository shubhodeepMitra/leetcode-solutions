//https://leetcode.com/problems/course-schedule/
class Solution {
    int V;
// Topological Sort using DFS
//     boolean topologicalSort(List<List<Integer>> adjList, boolean[] visited, int index) {
//         if(visited[index])
//             return false;
//         else
//             visited[index] = true;
        
       
//         for(int i=0;i<adjList.get(index).size();i++) {
//             if (!topologicalSort(adjList, visited, adjList.get(index).get(i)))
//                 return false;
            
//         }
//         visited[index] = false;
//          V+=1;
//         return true;
//     }
    public boolean canFinish(int numCourses, int[][] pre) {
        V=0;
        boolean[] visited = new boolean[numCourses];
        int[] preNumber = new int[numCourses]; // number of prerequisites for the given course
        List<List<Integer>> adjList = new ArrayList<>();
        
        for(int i=0;i<numCourses;i++) {
            adjList.add(new ArrayList<>());
            visited[i] = false;
        }
        
        for(int[] p: pre) {
            adjList.get(p[1]).add(p[0]);
            preNumber[p[0]]+=1;
        }
        
        
        Queue<Integer> q = new LinkedList<>();
        
        for(int i=0;i<numCourses;i++) {
            if(preNumber[i]==0)
                q.offer(i);
        }        
        
        while(!q.isEmpty()) {
            int cur = q.poll();
            V+=1;
            for(int i=0;i<adjList.get(cur).size();i++) {
                int adNum = adjList.get(cur).get(i);
                if(--preNumber[adNum]==0)
                    q.offer(adNum);
            }
        }

        return (V==numCourses)? true: false;
    }
}