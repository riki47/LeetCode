/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode turtle = head;
        ListNode rabbit = head;
        HashSet <ListNode> h1 = new HashSet<>();
        while(rabbit != null && rabbit.next != null)
        {
            rabbit = rabbit.next.next;
            turtle = turtle.next;
            if(rabbit == turtle)
            {
                break;
            }
        }
        if(rabbit == null || rabbit.next == null)return null;

        while(head!=turtle)
        {
            head = head.next;
            turtle = turtle.next;
        }
        return head;
    }
}