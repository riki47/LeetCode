class Node
{
    int key;
    int val;
    Node next;
    Node prev;
    Node(int key,int val)
    {
        this.key = key;
        this.val = val;
        next = null;
        prev = null;
    }
}

class LRUCache {
    //var
    Node head;
    Node tail;
    Map<Integer, Node> h1;
    int size;

    //declare
    public LRUCache(int capacity) {
        head = new Node(-1,-1);
        tail = new Node(-1,-1);
        h1 = new HashMap<>();
        size = capacity;
        head.next = tail;
        tail.prev = head; // head-tail
    }

    //updating the value (custom)
    void delFromLast()
    {
        Node lru = tail.prev;
        delNode(tail.prev);
        h1.remove(lru.key); 
    }
    void delNode(Node node)
    {
        Node pr = node.prev;
        Node nxt = node.next;
        pr.next = nxt;
        nxt.prev = pr;
    }
    void updateAtStart(Node node)
    {
        Node hnxt = head.next;

        node.prev = head;
        head.next = node;//ehad-node 
        node.next = hnxt;
        hnxt.prev = node;//node-hnxt
    }

    //get
    public int get(int key) {
        if(h1.containsKey(key))
        {
            Node node = h1.get(key);
             //most recently used
            delNode(node);//-->
            updateAtStart(node);
            return node.val;
        }
        else
            return -1;
    }
    
    //put
    public void put(int key, int value) {
        if(h1.containsKey(key))
        {
            Node node = h1.get(key);
            node.val = value; //most recently used
            delNode(node); //--> and update at start
            updateAtStart(node);
            // ....-pr-node-next
            //head-node-....n1-n2-n3-pr-next
        }
        else
        {
            Node node = new Node(key,value);
            updateAtStart(node);
            h1.put(key,node);
            size--;
            //only here new element will be added so here we are checking
            if(size<0) //last element del least recently used
            {
                delFromLast();
                size++;
            }
        }
    }
}


/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */