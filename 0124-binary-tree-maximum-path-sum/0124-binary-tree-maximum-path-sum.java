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
    int balanced(TreeNode node,int max[])
    {
        if(node == null)return 0;

        int left = Math.max(0,balanced(node.left,max));
        int right = Math.max(0,balanced(node.right,max)); //if smaller than zero dont take that path not worth

        max[0] = Math.max(max[0], left + right + node.val);

        return Math.max(left,right) + node.val;
    }
    public int maxPathSum(TreeNode root) {
        int max[] = new int[]{-(int)1e9};
        balanced(root,max);
        return max[0];
    }
}