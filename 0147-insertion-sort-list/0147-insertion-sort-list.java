
class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode curr = head;
        ArrayList <Integer> a1 = new ArrayList<>();
        while(curr != null)
        {
            a1.add(curr.val);
            curr = curr.next;
        }
        for(int i = 1;i<a1.size();i++)
        {
            int key = a1.get(i);
            int j;
            for(j = i-1;j>=0;j--)
            {
                if(key<a1.get(j))
                {
                    a1.set(j+1,a1.get(j));
                }
                else break;
            }
            a1.set(j+1,key);
        }
        curr = head;
        for(int i = 0;i<a1.size();i++)
        {
            curr.val = a1.get(i);
            curr = curr.next;
        }
        return head;
    }
}