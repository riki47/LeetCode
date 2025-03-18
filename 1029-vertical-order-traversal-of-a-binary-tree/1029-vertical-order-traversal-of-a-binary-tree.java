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
    class Pair
    {
        int dta ;
        TreeNode node;
        int row;
        public Pair(int dta, TreeNode node, int row)
        {
            this.dta = dta;
            this.node = node;
            this.row = row;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer,ArrayList<int[]>> t1 = new TreeMap<>();
        List<List<Integer>> ans = new ArrayList<>();
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(0,root,0));
        int row = 0;
        while(!q.isEmpty())
        {
            Pair curr = q.poll();
            TreeNode node = curr.node;
            int val = curr.dta;
            int currow = curr.row;
            if(!t1.containsKey(val))
            {
                ArrayList<int[]> a1 = new ArrayList<>();
                a1.add(new int[]{node.val,currow});
                t1.put(val,a1);
            }
            else
            {
                t1.get(val).add(new int[]{node.val,currow});
            }
            if(node.left != null)
            {
                q.offer(new Pair(val-1,node.left,currow+1));
            }
            if(node.right != null)
            {
                q.offer(new Pair(val+1,node.right,currow+1));
            }
            
        }
        
        for(int i : t1.keySet())
        {
            for(int h[] : t1.get(i))
            {
                System.out.println(h[0] + " " + h[1]);
            }
            Collections.sort(t1.get(i),(k,j)->{
                if(k[1] == j[1])
                    return k[0]-j[0];
                return k[1]-j[1];
            });
            ArrayList<Integer> a1 = new ArrayList<>();
            for(int j[] : t1.get(i))
            {
                
                a1.add(j[0]);
            }
            ans.add(new ArrayList<>(a1));
        }
        return ans;
    }
}