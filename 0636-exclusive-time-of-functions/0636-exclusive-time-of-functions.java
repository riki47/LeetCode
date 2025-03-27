class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int ans[] = new int[n];
        Stack <int[]> st = new Stack<>();
        for(String i : logs)
        {
            String split[] = i.split(":");
            int funId = Integer.parseInt(split[0]);
            int status = (split[1].compareTo("start") == 0)?0:1;
            int timeStamp = Integer.parseInt(split[2]);
            //start
            if(status == 0)
            {
                st.push(new int[]{funId,timeStamp});
            }
            else
            {
                int curr[] = st.pop();
                int start = curr[1];
                int execTime = timeStamp - start + 1;
                ans[funId] += execTime;
                if(!st.isEmpty())
                    ans[st.peek()[0]] -= execTime;
            }
        }
        return ans;
    }
}