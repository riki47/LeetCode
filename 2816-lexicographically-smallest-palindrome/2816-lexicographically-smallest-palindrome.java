class Solution {
    public String makeSmallestPalindrome(String s) {
        int i = 0;
        int j = s.length()-1;
        char str[] = s.toCharArray();
        while(i<=j)
        {
            if(str[i] != str[j])
            {
                if(str[i] > str[j])
                    str[i] = str[j];
                else
                    str[j] = str[i];
            }
            i++;
            j--;
            if(i>j)break;
            if(str[i] != str[j])
            {
                if(str[i] > str[j])
                    str[i] = str[j];
                else
                    str[j] = str[i];
            }
            i++;
            j--;
        }
        return String.valueOf(str);
    }
}