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
    TreeNode helper(TreeNode node, int key)
    {
        if(node == null)return null;
        if(node.val == key) //this node has to be deleted
        {
            //case 1
            if(node.left == null && node.right == null)return null;
            //case 2
            else if(node.left == null || node.right == null)
            {
                if(node.left != null) return node.left;
                else return node.right;
            }
            //case 3
            else
            {
                TreeNode temp = node.left;
                while(temp.right != null)
                    temp = temp.right;
                temp.right = node.right;
                return node.left;
            }
        }
        else if(node.val > key)
            node.left =  helper(node.left,key);
        else
            node.right =  helper(node.right,key);
        return node;
    }
    public TreeNode deleteNode(TreeNode root, int key) {
        return helper(root,key);
    }
}