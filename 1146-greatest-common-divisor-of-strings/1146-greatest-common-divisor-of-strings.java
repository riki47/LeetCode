class Solution {
    static boolean check(char[] smaller, char[] larger, String max)
    {
        int mlen = max.length();
        String pre = max;
        for(int i = 0;i<(smaller.length/max.length())-1;i++)
        {
            pre += max;
        }
        if(pre.compareTo(String.valueOf(smaller)) != 0)
            return false;

        pre = max;
        for(int i = 0;i<(larger.length/max.length())-1;i++)
        {
            pre += max;
        }
        if(pre.compareTo(String.valueOf(larger)) != 0)
            return false;

        return true;    
    }
    public String gcdOfStrings(String str1, String str2) {
        int l1 = 0;
        int l2 = 0;
        String larger;
        String smaller;
        if(str1.length()>str2.length())
        {
            larger = str1;
            smaller = str2;
            l1 = str1.length();
            l2 = str2.length();
        }
        else
        {
            larger = str2;
            smaller = str1;
            l1 = str2.length();
            l2 = str1.length();
        }
        char lar[] = larger.toCharArray();
        char small[] = smaller.toCharArray();
        for(int i = l2;i>0;i--)
        {
            if(l1%i == 0 && l2%i == 0)
            {
                String max = String.valueOf(Arrays.copyOfRange(small,0,i));
                if(check(small,lar,max))
                {
                    return max;
                }
            }
        }
        return "";
    }
}