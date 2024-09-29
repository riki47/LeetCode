/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
 
class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<ListNode> nodeMap = new HashSet<>();
        ListNode curr1 = headA;
        ListNode curr2 = headB;
        while(curr1 != null && curr2 != null)
        {
            curr1 = curr1.next;
            curr2 = curr2.next;
        }
        if(curr2 != null && curr1 == null)
        {
            ListNode temp = headB;
            headB = headA;
            headA = temp;
        }
        while (headA != null || headB != null) {
            nodeMap.add(headB);
            if (nodeMap.contains(headA)) {
                return headA; 
            }
            if(headA!=null)
            headA = headA.next;
            if(headB!=null)
            headB = headB.next;
        }
        return null; 
    }
}