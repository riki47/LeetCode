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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int val) { val = val; left = null, right = null }
 * }
 **/

class Solution {
    TreeNode find(TreeNode node,int start)
    {
        if(node == null)return null;
        if(node.val == start)return node;
        TreeNode left = find(node.left , start);
        TreeNode right = find(node.right, start);

        if(left != null)
            return left;
        else
            return right;
        
    }
    public int amountOfTime(TreeNode root, int start) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        Map<TreeNode ,TreeNode> map = new HashMap<>();
        List<Integer> ans = new ArrayList<>();
        while(!q.isEmpty())
        {
            int size = q.size();
            for(int i = 0;i<size;i++)
            {
                TreeNode node = q.poll();
                if(node.left != null)
                {
                    map.put(node.left,node);
                    q.offer(node.left);
                }
                if(node.right != null)
                {
                    map.put(node.right,node);
                    q.offer(node.right);
                }
            }
        }
        
        HashSet<TreeNode> vis = new HashSet<>();
        TreeNode target = find(root,start);
        q.offer(target);
        vis.add(target);
        int k = 0;
        while(!q.isEmpty())
        {
            int size = q.size();
            for(int i = 0;i<size;i++)
            {
                TreeNode node = q.poll();
                if(!vis.contains(node.left) && node.left != null)
                {
                    vis.add(node.left);
                    q.offer(node.left);
                }
                if(!vis.contains(node.right) && node.right != null)
                {
                    vis.add(node.right);
                    q.offer(node.right);
                }

                //fetch parent
                TreeNode parent = null;
                if(map.containsKey(node)) 
                    parent = map.get(node);

                if(!vis.contains(parent) && parent != null)
                {
                    vis.add(parent);
                    q.offer(parent);
                }
            }
            k++;
            
        }
        return k-1;
    }
}