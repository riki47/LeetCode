class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int ans[] = new int[n];
        Deque <int[]> st = new ArrayDeque<>();
        for(String i : logs)
        {
            int firstColon = i.indexOf(':');
            int lastColon = i.lastIndexOf(':');
            
            int funId = Integer.parseInt(i.substring(0, firstColon));
            int status = (i.substring(firstColon + 1, lastColon).compareTo("start") == 0)?0:1;
            int timeStamp = Integer.parseInt(i.substring(lastColon + 1));
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