class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1)
            return s;
        StringBuilder sb = new StringBuilder();
        char str[] = s.toCharArray();
        for(int i = 0; i<numRows; i++)
        {
            int j = i;
            while(j<s.length())
            {
                sb.append(str[j]);
                if(i != 0 && i != numRows-1)
                {
                    j += 2*numRows - 2 - 2*i;
                    if(j>s.length()-1)
                        break;
                    sb.append(str[j]);
                    j += 2*i;
                }
                else
                    j += 2*numRows - 2;
            }
        }
        return sb.toString();
    }
}