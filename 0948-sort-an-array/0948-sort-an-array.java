// class Solution {
//     public int[] sortArray(int[] nums) {
//         Queue<Integer> q1 = new PriorityQueue<>();
//         for(int i : nums)
//         {
//             q1.offer(i);
//         }
//         int newn[] = new int[nums.length];
//         for(int i = 0 ; i<nums.length; i++)
//         {
//             newn[i] = q1.poll();
//         }
//         return newn;
//     }
// }
class Solution {
    static void merge(int arr[], int l, int m, int r)
    {
        int n1 = m - l +1;
        int n2 = r - m;
        int arr1[] = new int[n1];
        int arr2[] = new int[n2];
        for(int i = 0;i<n1;i++)
        {
            arr1[i] = arr[l+i];
        }
        for(int i = 0;i<n2;i++)
        {
            arr2[i] = arr[m+1+i];
        }
        int i = 0;
        int j = 0;
        int count = l;
        while(i<n1 || j<n2)
        {
            if(i<n1 && j<n2)
            {
                if(arr1[i]<arr2[j])
                {
                    arr[count] = arr1[i];
                    i++;
                }
                else
                {
                    arr[count] = arr2[j];
                    j++;
                }
            }
            else if(i<n1)
            {
                arr[count] = arr1[i];
                i++;
            }
            else if(j<n2)
            {
                arr[count] = arr2[j];
                j++;
            }
            count++;
        }
    }

    static void sort(int arr[], int l, int r)
    {
        if (l < r) {
            int m = (l+r)/ 2;
            sort(arr, l, m);
            sort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }
    public int[] sortArray(int[] nums) {
        sort(nums,0,nums.length-1);
        return nums;
    }
}