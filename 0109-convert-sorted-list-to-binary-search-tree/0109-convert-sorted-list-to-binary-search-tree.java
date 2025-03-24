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
    ListNode middle(ListNode head)
    {
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast != null && fast.next!=null && fast.next.next !=null)
        {
            fast = fast.next.next;
            slow = slow.next;
        }
        System.out.println(slow.val);
        return slow;	    
    }
    TreeNode sort(TreeNode thead, ListNode head)
    {
        if(head == null) return null;
        ListNode mid = middle(head);
        if(mid.next == null)return new TreeNode(mid.val);
        TreeNode tHead = new TreeNode(mid.next.val);
        tHead.right = sort(tHead.right,mid.next.next);
        mid.next = null;
        tHead.left = sort(tHead.left,head);
        return tHead;
    }
    public TreeNode sortedListToBST(ListNode head) {
        return sort(new TreeNode(-1),head);
    }
}





