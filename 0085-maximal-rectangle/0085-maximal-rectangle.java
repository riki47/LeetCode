class Solution {
    int[] nse(int arr[])
    {
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        int ps[] = new int[n];
        int c = n-1;
        for(int i = n-1;i>=0;i--)
        {
            while(!st.isEmpty() && arr[st.peek()] >= arr[i])
            {
                st.pop();
            }
            if(st.isEmpty())
            {
                ps[c--] = n;
            }
            else
            {
                ps[c--] = st.peek();
            }
            st.push(i);
        }
        return ps;
    }
    int[] pse(int arr[])
    {
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        int ps[] = new int[n];
        int c = 0;
        for(int i =0;i<n ;i++)
        {
            while(!st.isEmpty() && arr[st.peek()] >= arr[i])
            {
                st.pop();
            }
            if(st.isEmpty())
            {
                ps[c++] = -1;
            }
            else
            {
                ps[c++] = st.peek();
            }
            st.push(i);
        }
        return ps;
    }
    int largestRectangleArea(int[] heights) {
        int ns[] = nse(heights);
        int ps[] = pse(heights);
        int n = heights.length;
        int max = 0;
        for(int i = 0;i<n;i++)
        {
            max = Math.max(max, heights[i]*(ns[i]-ps[i]-1));
        }
        return max;
    }
    public int maximalRectangle(char[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        int height[][] = new int[r][c];
        for(int i = 0; i<c;i++)
        {
            int sum = 0;
            for(int j = 0;j<r; j++)
            {
                if(matrix[j][i] == '1')sum++;
                else sum = 0;
                height[j][i] = sum;
            }
        }
        int max = 0;
        for(int i = 0; i<r;i++)
        {
            max = Math.max(max,largestRectangleArea(height[i]));
        }
        return max;
    }
}