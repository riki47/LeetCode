class Solution {
    public int[] maxSlidingWindow(int[] arr, int k) {
        int c = 0;
        int n = arr.length;
        int ans[] = new int[n-k+1];
        Deque <Integer> dq = new ArrayDeque<>();    

        //eg [4, 0, -1, 3, 5, 3, 6, 8]
        for(int j = 0;j<k;j++) //initial 3 symbols
        {
            while(!dq.isEmpty() && arr[dq.peekLast()] < arr[j])
                dq.pollLast(); // 
            dq.offerLast(j); //[4 0 -1]
        }
        ans[c++] = arr[dq.peekFirst()]; //4


        for(int i = k; i<n; i+=1)
        {
            while(!dq.isEmpty() && dq.peekFirst() < i-k+1) 
                dq.pollFirst(); //remove the element thats out of the sliding window
    
            while(!dq.isEmpty() && arr[dq.peekLast()] < arr[i])
                dq.pollLast(); //remove elements thats smaller than arr[i]
                //monotonic dec stack best element at bottom
        
            dq.offerLast(i);
            ans[c++] = arr[dq.peekFirst()];
        }
        return ans;
    }
}
