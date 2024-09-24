class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode first = l1;
        ListNode second = l2;
        int carry = 0;
        int sum = 0;
        int firstval = first.val;
        int secval = second.val;
        ListNode prev = null;
        ListNode start = null;
        while(first!=null || second!=null || carry != 0)
        {
            sum = firstval + secval + carry;
            carry = sum/10;
            sum = sum%10;
            ListNode newn = new ListNode(sum);

            if(prev != null)
            prev.next = newn;

            if(prev == null)
            {
                prev = newn;
                start = prev;
            }
            else prev = newn;


            if(first !=null)
            {
                if(first.next!=null)
                {
                    first = first.next;
                    firstval = first.val;
                }
                else
                {
                    firstval = 0;
                    first = null;
                }
            }
            
            if(second!=null)
            {
                if(second.next!=null)
                {
                    second = second.next;
                    secval = second.val;
                }
                else
                {
                    secval = 0;
                    second = null;
                }
            }
        }
        return start;
    }
}
// class Solution {
//     public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
//     }
// }