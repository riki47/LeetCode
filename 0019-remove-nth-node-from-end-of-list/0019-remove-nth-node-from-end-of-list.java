
/*Definition for Singly Linked List
class ListNode {
    int val;
    ListNode next;

    ListNode() {
        val = 0;
        next = null;
    }

    ListNode(int data1) {
        val = data1;
        next = null;
    }

    ListNode(int data1, ListNode next1) {
        val = data1;
        next = next1;
    }
}
 */
// 1 -> 2-> 3->4, n= 2
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        while(fast != null && n>0)
        {
            fast = fast.next;
            n--;
        }
        if(fast == null && n > 0) return head;
        else if(fast == null && n == 0) 
        {
            head = head.next;
            return head;
        }
        else
        {
            ListNode slow = head;
            while(fast.next != null)
            {
                fast = fast.next;
                slow = slow.next;
            }
            slow.next = slow.next.next;
        }
        return head;
    }
}