class Solution {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if(cloned == null)
            return null;
        if(original== target)
            return cloned;
        TreeNode a = getTargetCopy(original.left,cloned.left,target) ;
        if(a != null)
            return a;
        TreeNode b = getTargetCopy(original.right,cloned.right,target) ;
        return b;
    }
}