// class Solution {
//     public int minExtraChar(String s, String[] dictionary) {
//         Set<String> dict = new HashSet<>();
//         for (String word : dictionary) {
//             dict.add(word); // Add dictionary words to a set for quick lookup
//         }
//         int n = s.length();
//         int[] dp = new int[n + 1]; // DP array to track the minimum extra characters
        
//         for (int i = 1; i <= n; i++) {
//             dp[i] = n; // Initialize with maximum extra characters
//         }
//         // Iterate through each index in the string
//         for (int i = 1; i <= n; i++) {
//             // Check all substrings ending at i
//             for (int j = 0; j < i; j++) {
//                 String sub = s.substring(j, i); // Get substring s[j:i]
//                 if (dict.contains(sub)) {
//                     dp[i] = Math.min(dp[i], dp[j]); // If substring found in dictionary
//                 }
//             }
//             dp[i] = Math.min(dp[i], dp[i - 1] + 1); // Consider current character as extra
//         }

//         return dp[n]; // Return the result from dp[n]
//     }
// }


class Solution {
    public int minExtraChar(String s, String[] dictionary) {
        Set <String> h1 = new HashSet<>();
        for(String i : dictionary)
        {
            h1.add(i);
        }
        int n = s.length();
        int dp[] = new int[n+1];
        dp[0] = 0;
        for(int i = 1;i<n+1;i++)
        {
            dp[i] = n;
        }
        for(int i = 1;i<n+1;i++)
        {
            for(int j = 0;j<i;j++)
            {
                if(h1.contains(s.substring(j,i)))
                {
                    dp[i] = Math.min(dp[i],dp[j]);
                }
            }
            dp[i] = Math.min(dp[i],dp[i-1]+1);
        }
        return dp[n];
    }
}