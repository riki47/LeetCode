class Solution {
    public static int dfs( TreeNode root)
    {
        if(root == null)
            return 0; 
        if(root.left == null && root.right == null)
            return root.val;
        int a = dfs(root.left);
        int b = dfs(root.right);
        return a+b;
    }
    public boolean checkTree(TreeNode root) {
        if(root.val == dfs(root))
            return true;
        return false;
    }
}