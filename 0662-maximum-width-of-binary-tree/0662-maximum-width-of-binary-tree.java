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
class Pairr
{
    TreeNode node;
    long val;
    public Pairr(TreeNode node,long val)
    {
        this.node = node;
        this.val = val;
    }
}
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        //your code goes here
        Queue<Pairr> q = new LinkedList<>();
        q.offer(new Pairr(root,0));
        long max = 0;
        while(!q.isEmpty())
        {
            int size = q.size();
            long low = Long.MAX_VALUE;
            long high = Long.MIN_VALUE;
            for(int i = 0;i<size;i++)
            {
                Pairr pairr = q.poll();
                TreeNode node = pairr.node;
                long val = pairr.val;

                if(node.left != null)
                    q.offer(new Pairr(node.left,val*2+1));
                if(node.right != null)
                    q.offer(new Pairr(node.right,val*2+2));

                if (i == size-1) {
                    high = val;
                }
                if (i == 0) {  
                    low = val;
                }
            }
            max = Math.max(max,high-low);
            //System.out.println(max);
        }
        return (int)max+1;
    }
}