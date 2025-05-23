/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/
//[[7,null],[13,0],[11,4],[10,2],[1,0]]
class Solution {
    public Node copyRandomList(Node head) {
        Node temp = head;
        //1st step
        while(temp != null)
        {
            Node newn = new Node(temp.val);
            newn.next = temp.next;
            temp.next = newn;
            temp = temp.next.next;
        }
        
        //2nd 
        // temp = head;
        // h
        // 7 7 13 13 11 10 10 1 1
        //      t   
        //   
        temp = head;
        while(temp != null)
        {
            if(temp.random != null)
                temp.next.random = temp.random.next;
            temp = temp.next.next;
            System.out.println("Asd");
        }

        //3rd
        temp = head;
        Node dummy = new Node(-1);
        Node res = dummy;
        while(temp != null)
        {
            res.next = temp.next;
            temp.next = temp.next.next;
            res = res.next;
            temp = temp.next;
        }
        return dummy.next;
    }
}