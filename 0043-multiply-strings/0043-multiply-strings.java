class Solution {
    public String multiply(String num1, String num2) {
        if(num1.compareTo("0") == 0 || num2.compareTo("0") == 0) return "0";
        int sum[] = new int[num1.length()+num2.length()];
        for(int i = num1.length()-1; i>=0; i--)
        {
            int carry = 0;
            int temp1 = num1.charAt(i) - '0';
            int ic = sum.length -1 - (num1.length()-1 -i);
            for(int j = num2.length()-1; j>=0; j--)
            {
                int temp2 = num2.charAt(j) - '0';
                int temp3 = temp1*temp2 + carry;
                carry = 0;
                if(temp3 > 9)
                {
                    carry = (int)temp3/10;
                    temp3 %= 10;
                }
                sum[ic] += temp3;
                ic--;
                if(j == 0)
                    sum[ic] = carry;
            }
        }
        StringBuilder sb= new StringBuilder();
        int n = 0;
        for(int i = sum.length-1;i>=0;i--)
        {
            int prev = n;
            n = prev;
            if(sum[i]>9)
            {
                sum[i-1] += sum[i]/10;
                sum[i] %= 10;
                n = 1;
            }
            if(sum[i]==0 && i == 0)
            {
                prev = 0;
                continue;
            }
            sb.append(sum[i]);
        }
        return sb.reverse().toString();
    }
}