
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
//         for(int i = 0;i<n;i++)
//         {
//             for(int j = n-1;j>i;j--)
//             {
//                 if(max.length()>j-i+1)
//                     break;
//                 if(palin(str,i,j))
//                 {
//                     String curr = String.valueOf(Arrays.copyOfRange(str,i,j+1));
//                     max = curr;
//                 }
//             }
//         }
//         return max;
//     }
// }

class Solution {
    String max= "";
    void palin(char str[],int middle,boolean iseven)
    {
        int i = middle-1;
        if(!iseven)
            i = middle;
        int j = middle;
        while(i>=0 && j<str.length && str[i] == str[j])
        {
            i--;
            j++;
        }
        if(max.length()<j-i-1)
        {
            max = String.valueOf(Arrays.copyOfRange(str,i+1,j));
        }
    }
    public String longestPalindrome(String s) {
        int n = s.length();
        max = String.valueOf(s.charAt(0));
        char str[]= s.toCharArray();
        boolean iseven = (n%2 == 0);
        for(int idx = 0;idx<n;idx++)
        {
            palin(str,idx,false);
            palin(str,idx,true);
        }
        return max;
    }
}