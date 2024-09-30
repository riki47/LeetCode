class CustomStack {
    int stack[];
    int pos;
    int size;
    public CustomStack(int maxSize) {
        stack = new int[maxSize];
        pos = 0;
        size = maxSize;
    }
    public void push(int x) {
        if(pos>=size)
            return;

        stack[pos] = x;
        pos++;
    }
    
    public int pop() {
        if(pos == 0)
            return -1;
        int temp = stack[pos-1];
        pos--;
        return temp;
    }
    
    public void increment(int k, int val) {
        for(int i = 0;i<k&&i<pos;i++)
        {
            stack[i] += val;
        }
    }
}

