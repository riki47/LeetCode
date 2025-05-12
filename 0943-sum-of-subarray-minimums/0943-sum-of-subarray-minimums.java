class Solution {
    //mono inc st
    int[] nse(int arr[])
    {
        int n = arr.length;
        int ans[] = new int[n];
        Stack <Integer> st = new Stack<>();
        for(int i = n-1; i>=0; i--)
        {
            while(!st.isEmpty() && arr[st.peek()] >= arr[i])
                st.pop();
            if(st.isEmpty())
                ans[i] = n;
            else
                ans[i] = st.peek();
            st.push(i);
        }
        return ans;
    }
    int[] pse(int arr[])
    {
        int n = arr.length;
        int ans[] = new int[n];
        Stack <Integer> st = new Stack<>();
        for(int i = 0; i< n; i++)
        {
            while(!st.isEmpty() && arr[st.peek()] > arr[i])
                st.pop();
            if(st.isEmpty())
                ans[i] = -1;
            else
                ans[i] = st.peek();
            st.push(i);
        }
        return ans;
    }
    public int sumSubarrayMins(int[] arr) {
        //calc += (i-pse)*(nse-i)*arr[i]
        int MOD = (int)(1e9 + 7);
        int n = arr.length;
        int ps[] = pse(arr);
        int ns[] = nse(arr);
        long sum = 0;
        for(int i = 0 ;i<n; i++)
        {
            long count = (long)(i - ps[i]) * (ns[i] - i) % MOD;
sum = (sum + arr[i] * count % MOD) % MOD; //all combinations of subarrays where arr[i] is min
        }
        return (int)(sum);
    }
}