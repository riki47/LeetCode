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
    private TreeNode dfs(TreeNode node, HashSet<Integer> del, List<TreeNode> ans)
    {
        if(node == null)return null;
        if(del.contains(node.val))
        {
            if(node.left == null && node.right == null) return null;
            if(node.left != null) 
            {
                if(!del.contains(node.left.val)) ans.add(node.left);
                    dfs(node.left,del,ans); 
            }
            if(node.right != null)
            {
                if(!del.contains(node.right.val)) ans.add(node.right);
                    dfs(node.right,del,ans);
            }
            return null;
        }
        node.left = dfs(node.left,del,ans);
        node.right = dfs(node.right,del,ans);
        return node;
    }   
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        HashSet<Integer> del = new HashSet<>();
        List<TreeNode> ans = new ArrayList<>();
        for(int i : to_delete)
            del.add(i);
        if(!del.contains(root.val))
            ans.add(root);
        dfs(root,del,ans);
        return ans;
    }
}