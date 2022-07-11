// https://leetcode.com/problems/keys-and-rooms/
class Solution {
//     void unlockPreviousRooms(List<List<Integer>> rooms, int[] unlockedRooms, int unlockRoom, int index){
//         if( unlockedRooms[unlockRoom]==1)
//             return;
//         unlockedRooms[unlockRoom]=1;
//            for (int k=0;k<rooms.get(unlockRoom).size();k++) {
//                 unlockedRooms[rooms.get(unlockRoom).get(k)]=1;
//                 if(rooms.get(unlockRoom).get(k) < index)
//                         unlockPreviousRooms(rooms, unlockedRooms, rooms.get(unlockRoom).get(k), index);
//             } 
//     }
//     public boolean canVisitAllRooms(List<List<Integer>> rooms) {
//         int[] unlockedRooms =  new int[rooms.size()];
//         unlockedRooms[0]=1;
//         for(int i=0;i<rooms.size();i++) {
//             for(int j=0;j<rooms.get(i).size();j++){
//                 if(unlockedRooms[i]==1) {
//                     if(rooms.get(i).get(j) < i)
//                         unlockPreviousRooms(rooms, unlockedRooms, rooms.get(i).get(j), i);
//                     unlockedRooms[rooms.get(i).get(j)]=1;
//                 }                
//             }
//         }
        
        
//         for(int i=0;i<rooms.size();i++){
//             if(unlockedRooms[i]==0)
//                 return false;
//         }
        
//         return true;
//     }
        void DFS(List<List<Integer>> rooms, int[] unlockedRooms, int roomToUnlock) {
            if(unlockedRooms[roomToUnlock]==1)
                return;
            unlockedRooms[roomToUnlock]=1;
            for(int i=0;i<rooms.get(roomToUnlock).size();i++) {
                if(unlockedRooms[rooms.get(roomToUnlock).get(i)]==0)
                    DFS(rooms, unlockedRooms, rooms.get(roomToUnlock).get(i));
            }
        }
        public boolean canVisitAllRooms(List<List<Integer>> rooms) {
            int[] unlockedRooms = new int[rooms.size()];
            DFS(rooms, unlockedRooms, 0);
            
            
            for(int i=0;i<rooms.size();i++)
                if(unlockedRooms[i]==0)
                    return false;
            return true;
       }
}