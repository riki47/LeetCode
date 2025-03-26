class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        //O(nlogn)
        Arrays.sort(intervals,(a,b)->a[1]-b[1]); //sort according to end time
        int end = intervals[0][1]; //first meeting ends at this time
        int cnt = 0;
        int n = intervals.length;
        //O(n)
        for(int i = 1; i<n; i++)
        {
          //if second meeting starts before first one ends it cannot be scheduled
            if(intervals[i][0] < end)cnt++; 
          //else it can be scheduled update the end time
            else end = intervals[i][1];
        }
        return cnt;
    }
}