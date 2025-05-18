import java.util.*;

class Solution {
    // Function to compute digit sum
    private int digitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    public int minSwaps(int[] nums) {
        int n = nums.length;

        // Step 1: Pair with original index
        int[][] arr = new int[n][3]; // {digitSum, value, originalIndex}
        for (int i = 0; i < n; i++) {
            arr[i][0] = digitSum(nums[i]);
            arr[i][1] = nums[i];
            arr[i][2] = i;
        }

        // Step 2: Sort by digitSum, then value
        Arrays.sort(arr, (a, b) -> {
            if (a[0] != b[0])
                return a[0] - b[0]; // sort by digit sum
            return a[1] - b[1];     // then by value
        });

        // Step 3: Count minimum swaps to reach target
        boolean[] visited = new boolean[n];
        int swaps = 0;

        for (int i = 0; i < n; i++) {
            // Already visited or in the right place
            if (visited[i] || arr[i][2] == i)
                continue;

            int cycleSize = 0;
            int j = i;

            // Follow the cycle
            while (!visited[j]) {
                visited[j] = true;
                j = arr[j][2];
                cycleSize++;
            }

            if (cycleSize > 1)
                swaps += cycleSize - 1;
        }

        return swaps;
    }
}
