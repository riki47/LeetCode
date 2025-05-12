class Solution {
    int[] nse(int[] arr) {
        int n = arr.length, ans[] = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) st.pop();
            ans[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        return ans;
    }

    int[] pse(int[] arr) {
        int n = arr.length, ans[] = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] > arr[i]) st.pop();
            ans[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return ans;
    }

    int[] nge(int[] arr) {
        int n = arr.length, ans[] = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] <= arr[i]) st.pop();
            ans[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        return ans;
    }

    int[] pge(int[] arr) {
        int n = arr.length, ans[] = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] < arr[i]) st.pop();
            ans[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return ans;
    }

    public long subArrayRanges(int[] arr) {
        int n = arr.length;
        int[] ps = pse(arr), ns = nse(arr), pg = pge(arr), ng = nge(arr);
        long sumMin = 0, sumMax = 0;

        for (int i = 0; i < n; i++) {
            long left = i - ps[i];
            long right = ns[i] - i;
            long count = left * right;
            sumMin += (long) arr[i] * count;
        }

        for (int i = 0; i < n; i++) {
            long left = i - pg[i];
            long right = ng[i] - i;
            long count = left * right;
            sumMax += (long) arr[i] * count;
        }

        return sumMax - sumMin;
    }
}
