// public class Solution {
//     public ListNode detectCycle(ListNode head) {
//         ListNode turtle = head;
//         ListNode rabbit = head;
//         HashSet <ListNode> h1 = new HashSet<>();
//         while(rabbit != null && rabbit.next != null)
//         {
//             rabbit = rabbit.next.next;
//             turtle = turtle.next;
//             if(rabbit == turtle)
//             {
//                 break;
//             }
//         }
//         if(rabbit == null || rabbit.next == null)return null;

//         while(head!=turtle)
//         {
//             head = head.next;
//             turtle = turtle.next;
//         }
//         return head;
//     }
// }
////////////////////////////////////////////////////

public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode turtle = head;
        ListNode rabbit = head;
        while(rabbit != null)
        {
            if(rabbit.next == null)
                return null;
            rabbit = rabbit.next.next;
            turtle = turtle.next;
            if(rabbit == turtle)
                break;
        }
        if(rabbit == null)
            return null;
        rabbit = head;
        while(rabbit != turtle)
        {
            rabbit = rabbit.next;
            turtle = turtle.next;
        }
        return turtle;
    }
}