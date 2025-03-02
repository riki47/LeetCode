/*Definition of singly linked list:
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

class Solution {
    public ListNode rev(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        return prev;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        ListNode prevP = null;
        ListNode nextK = head;
        int f = 0;
        while(true)
        {
            ListNode prevK = nextK;
            temp = nextK;
            int c = 1;
            ListNode stor = temp;
            while(c<k && temp != null)
            {
                c++;
                temp = temp.next;
            }
            if(temp == null)
            {
                prevP.next = stor;
                return head;
            }
            nextK = temp.next;
            temp.next = null;
            prevK = rev(prevK); //2->1
            if(prevP != null)
                prevP.next = prevK;
            prevP = stor;
            if(f == 0)
            {
                f++;
                head = prevK;
            }
        }
    }
}