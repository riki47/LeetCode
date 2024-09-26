class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode one = l1;
        ListNode two = l2;
        ListNode newn = new ListNode(0);
        ListNode start = newn;
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        while(l1 != null)
        {
            s1.add(l1.val);
            l1 = l1.next;
        }
        while(l2 != null)
        {
            s2.add(l2.val);
            l2 = l2.next;
        }
        int sum = 0;
        int carry = 0;
        Stack<Integer> s3 = new Stack<>();
        while(!s1.isEmpty() || !s2.isEmpty() || carry != 0)
        {
            sum = 0;
            if(!s1.isEmpty() && !s2.isEmpty())
            {
                sum = carry + s1.pop() + s2.pop();
            }
            else if(!s1.isEmpty())
            {
                sum = carry + s1.pop();
            }
            else if(!s2.isEmpty())
            {
                sum = carry + s2.pop();
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
         
            s3.add(sum);
        }
        while(!s3.isEmpty())
        {
            ListNode newl = new ListNode(s3.pop());
            newn.next = newl;
            newn = newl;
        }
        return start.next;
    }
}