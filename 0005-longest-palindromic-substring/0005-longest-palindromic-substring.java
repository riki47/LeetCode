
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

// public class Solution {
//     static boolean palin(char str[],int start,int end)
//     {
//         int i = start;
//         int j = end;
//         while(i<j)
//         {
//             if(str[i] != str[j])
//                 return false;
//             i++;
//             j--;
//         }
//         return true;
//     }
//     public String longestPalindrome(String s) {
//         int n = s.length();
//         String max = String.valueOf(s.charAt(0));
//         char str[]= s.toCharArray();
        
//         for(int idx = 0;idx<n;idx++)
//         {
//             if(n%2 !=0)
//             {
//                 int i = 0;
//                 int j = idx;
//                     if(max.length()>j-i+1)
//                         break;
//                     if(palin(str,i,j))
//                     {
//                         String curr = String.valueOf(Arrays.copyOfRange(str,i,j+1));
//                         max = curr;
//                     }
//                     i--;
//                     j++;
//             }
//             else
//             {
//                 int i = 0;
//                 int j = idx+1;
//                     if(max.length()>j-i+1)
//                         break;
//                     if(palin(str,i,j))
//                     {
//                         String curr = String.valueOf(Arrays.copyOfRange(str,i,j+1));
//                         max = curr;
//                     }
//                     i--;
//                     j++;
//             }
        
//         }
        
//         return max;
//     }
// }