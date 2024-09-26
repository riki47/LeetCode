// public class Solution {
//     public String longestPalindrome(String s) {
//         if (s.length() <= 1) {
//             return s;
//         }

//         int maxLen = 1;
//         String maxStr = s.substring(0, 1);

//         for (int i = 0; i < s.length(); i++) {
//             for (int j = i + maxLen; j <= s.length(); j++) {
//                 if (j - i > maxLen && isPalindrome(s.substring(i, j))) {
//                     maxLen = j - i;
//                     maxStr = s.substring(i, j);
//                 }
//             }
//         }

//         return maxStr;
//     }

//     private boolean isPalindrome(String str) {
//         int left = 0;
//         int right = str.length() - 1;

//         while (left < right) {
//             if (str.charAt(left) != str.charAt(right)) {
//                 return false;
//             }
//             left++;
//             right--;
//         }

//         return true;
//     }
// }
public class Solution {
    static boolean palin(char str[],int start,int end)
    {
        int i = start;
        int j = end;
        while(i<j)
        {
            if(str[i] != str[j])
                return false;
            i++;
            j--;
        }
        return true;
    }
    public String longestPalindrome(String s) {
        int n = s.length();
        String max = String.valueOf(s.charAt(0));
        char str[]= s.toCharArray();
        for(int i = 0;i<n;i++)
        {
            for(int j = n-1;j>i;j--)
            {
                if(max.length()>j-i+1)
                    break;
                if(palin(str,i,j))
                {
                    String curr = String.valueOf(Arrays.copyOfRange(str,i,j+1));
                    max = curr;
                }
            }
        }
        return max;
    }
}