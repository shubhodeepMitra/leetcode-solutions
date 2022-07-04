//https://leetcode.com/problems/kth-smallest-element-in-a-bst/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int index;
    int solution(TreeNode root, int k){
        if(root==null)
            return -1;
        if(root.left==null && root.right==null){
            index+=1;
            if(index==k)
                return root.val;
            return -1;
        }
        int left=-1, right=-1;
        left=solution(root.left, k);
        index+=1;
        if(index==k)
            return root.val;
        right=solution(root.right,k);
        
        return (left!=-1)? left:right;
        
    }
    public int kthSmallest(TreeNode root, int k) {
        index=0;
        return solution(root,k);        
    }
}