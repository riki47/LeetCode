import java.util.*;

class Solution {
    
    /* Function to find the indices of 
    next smaller elements */
    private int[] findNSE(int[] arr) {
        
        // Size of array
        int n = arr.length;
        
        // To store the answer
        int[] ans = new int[n];
        
        // Stack 
        Stack<Integer> st = new Stack<>();
        
        // Start traversing from the back
        for (int i = n - 1; i >= 0; i--) {
            
            // Get the current element
            int currEle = arr[i];
            
            /* Pop the elements in the stack until 
            the stack is not empty and the top 
            element is not the smaller element */
            while (!st.isEmpty() && arr[st.peek()] >= currEle) {
                st.pop();
            }
            
            // Update the answer
            ans[i] = !st.isEmpty() ? st.peek() : n;
            
            /* Push the index of current 
            element in the stack */
            st.push(i);
        }
        
        // Return the answer
        return ans;
    }
    
    /* Function to find the indices of 
    next greater elements */
    private int[] findNGE(int[] arr) {
        
        // Size of array
        int n = arr.length;
        
        // To store the answer
        int[] ans = new int[n];
        
        // Stack 
        Stack<Integer> st = new Stack<>();
        
        // Start traversing from the back
        for (int i = n - 1; i >= 0; i--) {
            
            // Get the current element
            int currEle = arr[i];
            
            /* Pop the elements in the stack until 
            the stack is not empty and the top 
            element is not the greater element */
            while (!st.isEmpty() && arr[st.peek()] <= currEle) {
                st.pop();
            }
            
            // Update the answer
            ans[i] = !st.isEmpty() ? st.peek() : n;
            
            /* Push the index of current 
            element in the stack */
            st.push(i);
        }
        
        // Return the answer
        return ans;
    }
    
    /* Function to find the indices of 
    previous smaller or equal elements */
    private int[] findPSEE(int[] arr) {
        
        // Size of array
        int n = arr.length;
        
        // To store the answer
        int[] ans = new int[n];
        
        // Stack 
        Stack<Integer> st = new Stack<>();
        
        // Traverse on the array
        for (int i = 0; i < n; i++) {
            
            // Get the current element
            int currEle = arr[i];
            
            /* Pop the elements in the stack until 
            the stack is not empty and the top 
            elements are greater than the current element */
            while (!st.isEmpty() && arr[st.peek()] > currEle) {
                st.pop();
            }
            
            // Update the answer
            ans[i] = !st.isEmpty() ? st.peek() : -1;
            
            /* Push the index of current 
            element in the stack */
            st.push(i);
        }
        
        // Return the answer
        return ans;
    }
    
    /* Function to find the indices of 
    previous greater or equal elements */
    private int[] findPGEE(int[] arr) {
        
        // Size of array
        int n = arr.length;
        
        // To store the answer
        int[] ans = new int[n];
        
        // Stack 
        Stack<Integer> st = new Stack<>();
        
        // Traverse on the array
        for (int i = 0; i < n; i++) {
            
            // Get the current element
            int currEle = arr[i];
            
            /* Pop the elements in the stack until 
            the stack is not empty and the top 
            elements are smaller than the current element */
            while (!st.isEmpty() && arr[st.peek()] < currEle) {
                st.pop();
            }
            
            // Update the answer
            ans[i] = !st.isEmpty() ? st.peek() : -1;
            
            /* Push the index of current 
            element in the stack */
            st.push(i);
        }
        
        // Return the answer
        return ans;
    }
    
    /* Function to find the sum of the 
    minimum value in each subarray */
    private long sumSubarrayMins(int[] arr) {
        
        int[] nse = findNSE(arr);
        
        int[] psee = findPSEE(arr);
        
        // Size of array
        int n = arr.length;
        
        // To store the sum
        long sum = 0;
        
        // Traverse on the array
        for (int i = 0; i < n; i++) {
            
            // Count of first type of subarrays
            int left = i - psee[i];
            
            // Count of second type of subarrays
            int right = nse[i] - i;
            
            /* Count of subarrays where 
            current element is minimum */
            long freq = left * right * 1L;
            
            // Contribution due to current element 
            long val = (freq * arr[i] * 1L);
            
            // Updating the sum
            sum += val;
        }
        
        // Return the computed sum
        return sum;
    }
    
    /* Function to find the sum of the 
    maximum value in each subarray */
    private long sumSubarrayMaxs(int[] arr) {
        
        int[] nge = findNGE(arr);
        
        int[] pgee = findPGEE(arr);
        
        // Size of array
        int n = arr.length;
        
        // To store the sum
        long sum = 0;
        
        // Traverse on the array
        for (int i = 0; i < n; i++) {
            
            // Count of first type of subarrays
            int left = i - pgee[i];
            
            // Count of second type of subarrays
            int right = nge[i] - i;
            
            /* Count of subarrays where 
            current element is maximum */
            long freq = left * right * 1L;
            
            // Contribution due to current element 
            long val = (freq * arr[i] * 1L);
            
            // Updating the sum
            sum += val;
        }
        
        // Return the computed sum
        return sum;
    }
    
    /* Function to find the sum of 
    subarray ranges in each subarray */
    public long subArrayRanges(int[] arr) {
        
        // Return the result
        return ( sumSubarrayMaxs(arr) - 
                 sumSubarrayMins(arr) );
    }

    
}
