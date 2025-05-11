class Solution {
    public String removeKdigits(String num, int k) {
        //case 1 - n == len whole del
        if(num.length() == k)
            return "0";
        Stack<Integer> st = new Stack<>();
        for(char i : num.toCharArray())
        {
            int n = i-'0';
            while(!st.isEmpty() && st.peek() > n && k>0)
            {
                st.pop();
                k--;
            }
            st.push(n);
        }
        //case 2 if(k still remains)
        while(k>0)
        {
            st.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty())
        {
            sb.append(st.pop());
        }
        sb.reverse();
        //case 2 -  00 start
        while(sb.length() > 0 && sb.charAt(0) == '0')
        {
            sb.deleteCharAt(0);
        }
        if(sb.length() == 0)return "0";
        return sb.toString();
    }
}