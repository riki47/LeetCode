// class Solution {
//     public ListNode[] splitListToParts(ListNode head, int k) {
//         ListNode curr = head;
//         int count = 0;
//         while(curr != null)
//         {
//             curr = curr.next;
//             count++;
//         }
//         int extra = count%k;
//         double size = Math.floor(((double)count/k));
//         ListNode[] lc = new ListNode[k];
        
//         curr = head;
//         for(int i = 0;i<k;i++)
//         {
//             int s = (int)size;
//             int limit = 0;
//             ListNode newn = curr;
//             ListNode str = newn;
//             if(extra>0)
//             {
//                 s++;
//                 extra--;
//             }
//             while(limit < s-1 && newn !=null)
//             {
//                 newn = newn.next;
//                 curr = curr.next;
//                 limit++;
//             }
//             if(curr != null)
//             curr = curr.next;
//             if(newn != null)
//             newn.next = null;
//             lc[i] = str;
//         }
//         return lc;
//     }
// }

class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode curr = head;
        int c = 0;
        while(curr != null)
        {
            curr = curr.next;
            c++;
        }
        int extra = 0;
        if(c>k)
        extra = c%k;
        int parts = c/k;
        ListNode next = head;
        ListNode lc[] = new ListNode[k];
        for(int i = 0;i<k;i++)
        {   
            curr = next;
            lc[i] = curr;
            int count = 1;
            if(extra>0)
            {
                count--;
                extra--;
            }
            while(count<parts)
            {
                count++;
                curr = curr.next;
                if(curr == null)
                    break;
            }
            if(curr==null)
                break;
            next = curr.next;
            curr.next = null;
        }
        return lc;
    }
}