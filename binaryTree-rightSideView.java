// https://leetcode.com/problems/binary-tree-right-side-view/

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
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> queue =  new LinkedList<>();
        List<Integer> res = new LinkedList<>();
        if(root==null)
            return res;        
        
        queue.add(root);
        
        while(!queue.isEmpty()) {
            int l = queue.size();
            for(int i=0;i<l;i++)
            {
                TreeNode temp = queue.poll();
                if(i==l-1)
                    res.add(temp.val);
                if(temp.left!=null)
                    queue.add(temp.left);
                if(temp.right!=null)
                    queue.add(temp.right);
            }
        }
        
        return res;
    }
}