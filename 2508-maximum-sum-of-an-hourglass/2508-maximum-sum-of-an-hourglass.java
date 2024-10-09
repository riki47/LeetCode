class Solution {
    public int maxSum(int[][] grid) {
        int arr[][] = grid;
        int r = arr.length;
        int c = arr[0].length;
        int max = 0;
        for(int i = 0;i<r-2;i++)
        {
            for(int j = 0;j<c-2;j++)
            {
                int sum = arr[i][j]+ arr[i][j+1]+ arr[i][j+2]+ arr[i+1][j+1]+ arr[i+2][j]+ arr[i+2][j+1]+ arr[i+2][j+2];
                if(sum>max)
                    max = sum;
            }
        }
        return max;
    }
}