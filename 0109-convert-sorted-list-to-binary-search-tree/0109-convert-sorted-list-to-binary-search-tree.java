/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    ListNode middle(ListNode start,ListNode end)
    {
        ListNode slow = start;
        ListNode fast = start;
        while(fast != end && fast.next != end)
        {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;	    
    }
    TreeNode sort(TreeNode thead, ListNode start, ListNode end)
    {
        if(start == end) return null;
        ListNode mid = middle(start,end);
        TreeNode tHead = new TreeNode(mid.val);
        tHead.left = sort(tHead.left,start,mid);
        tHead.right = sort(tHead.right,mid.next,end);
        return tHead;
    }
    public TreeNode sortedListToBST(ListNode head) {
        return sort(new TreeNode(-1),head,null);
    }
}





