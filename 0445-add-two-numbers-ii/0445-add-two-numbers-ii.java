class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode one = l1;
        ListNode two = l2;
        ListNode newn = new ListNode(0);
        ListNode start = newn;
        
        ListNode prev = null;
        ListNode next = null;
        ListNode curr = l1;
        while(curr!=null)
        {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        one = prev;
        prev = null;
        next = null;
        curr = l2;
        while(curr!=null)
        {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        two = prev;
        int sum = 0;
        int carry = 0;
        while(one!=null || two!=null || carry != 0)
        {
            sum = 0;
            if(one!=null && two!=null)
            {
                sum = carry + one.val + two.val;
                one = one.next;
                two = two.next;
            }
            else if(one!=null)
            {
                sum = carry + one.val;
                one = one.next;
            }
            else if(two!=null)
            {
                sum = carry + two.val;
                two = two.next;
            }
            else
            {
                sum = carry;
            }
            
            if(sum>9)
            {
                carry = sum/10;
                sum = sum%10;
            }
            else
                carry = 0;

            ListNode newt = new ListNode(sum);
            newn.next = newt;
            newn = newt;
        }
        prev = null;
        next = null;
        curr = start.next;
        while(curr!=null)
        {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}