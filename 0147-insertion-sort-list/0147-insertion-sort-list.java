
class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode curr = head;
        ArrayList <ListNode> a1 = new ArrayList<>();
        while(curr != null)
        {
            a1.add(curr);
            curr = curr.next;
        }
        for(int i = 1;i<a1.size();i++)
        {
            ListNode key = a1.get(i);
            int j;
            for(j = i-1;j>=0;j--)
            {
                if(key.val<a1.get(j).val)
                {
                    a1.set(j+1,a1.get(j));
                }
                else break;
            }
            a1.set(j+1,key);
        }
        ListNode Dummy = new ListNode(0);
        ListNode start = Dummy;
        for(int i = 0;i<a1.size();i++)
        {
            Dummy.next = a1.get(i);
            Dummy = Dummy.next;
        }
        Dummy.next = null;
        return start.next;
    }
}