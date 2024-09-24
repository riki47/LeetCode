class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left == right)
            return head;
        int count = 0;
        ListNode curr = head;
        ListNode Dummy = new ListNode(0);
        ListNode start = Dummy;
        start.next = head;
        ListNode prev = null;
        ListNode curr1 = curr;
        ListNode next  = null;
        if(2<=left)
        {
            count = 2;
            while(count<left)
            {
                curr = curr.next;
                count++;
            }
            start = curr;
            prev = curr.next;
            curr1 = curr.next.next;
            next = null;
        }
        while(count<right)
        {
            next = curr1.next;
            curr1.next = prev;
            prev = curr1;
            curr1 = next;
            count++;
        }
        if(start.next!=null)
        start.next.next = curr1;
        start.next = prev;
        return Dummy.next;
    }
}