class MyCircularDeque {
    Deque <Integer> d1 ;
    int k = 0;
    int i = 0;
    public MyCircularDeque(int k) {
        d1 = new ArrayDeque<>();
        this.k = k;
    }
    
    public boolean insertFront(int value) {
        if(i>=k)
            return false;
        d1.addFirst(value);
        i++;
        return true;
        
    }
    
    public boolean insertLast(int value) {
        if(i>=k)
            return false;
        d1.addLast(value);
        i++;
        return true;
    }
    
    public boolean deleteFront() {
        if(i==0)
            return false;
        d1.removeFirst();
        i--;
        return true;
    }
    
    public boolean deleteLast() {
        if(i==0)
            return false;
        d1.removeLast();
        i--;
        return true;  
    }
    
    public int getFront() {
        if(d1.isEmpty())
            return -1;
        return d1.getFirst();
    }
    
    public int getRear() {
        if(d1.isEmpty())
            return -1;
        return d1.getLast();
    }
    
    public boolean isEmpty() {
        return d1.isEmpty();
    }
    
    public boolean isFull() {
        return i>=(k);
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */