// class Solution {
//     public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//         double median = 0;
//         ArrayList <Integer> a1 = new ArrayList<>();
//         int i = 0;
//         int j = 0;
//         while(i< nums1.length || j< nums2.length)
//         {
//             if(nums1.length>i && nums2.length>j)
//             {
//                 if(nums1[i]<nums2[j])
//                 {
//                     a1.add(nums1[i]);
//                     i++;
//                 }
//                 else if(nums1[i] >= nums2[j])
//                 {
//                     a1.add(nums2[j]);
//                     j++;
//                 }
//             }
//             else if(nums1.length>i)
//             {
//                 a1.add(nums1[i]);
//                 i++;
//             }
//             else if(nums2.length>j)
//             {
//                 a1.add(nums2[j]);
//                 j++;
//             }
//         }
//         int size = a1.size();
//         if(size%2 == 0)
//         {
//             int mid = size/2;
//             median = (double)(a1.get(mid) + a1.get(mid-1))/2;
//         }
//         else
//         {
//             median = a1.get(size/2);
//         }
//         return median;
//     }
// }
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double median = 0;
        int i = 0;
        int j = 0;
        int mid = Integer.MAX_VALUE;
        int mid1 = Integer.MAX_VALUE;
        double nu1 = 0;
        double nu2 = 0;
        int n1 = nums1.length;
        int n2 = nums2.length;
        if((n1+n2)%2==0)
        {
            mid = ((n1 + n2 )/ 2)+1;
            mid1 = ((n1+ n2 - 1)/ 2)+1;
            int count = 0;
            while(i<n1 || j<n2)
            {
                if((i<n1 && j<n2))
                {
                    if(nums1[i]<nums2[j])
                    {
                       
                        i++;
                        count++;  
                        if(count == mid)
                            nu1 = nums1[i-1];
                        if(count == mid1)
                            nu2 = nums1[i-1];
                    }
                    else
                    {
                        j++;
                        count++;
                        if(count == mid)
                            nu1 = nums2[j-1];
                        if(count == mid1)
                            nu2 = nums2[j-1];
                    }
                }
                else if(i<n1)
                {
                    i++;
                    count++;
                    if(count == mid)
                            nu1 = nums1[i-1];
                    if(count == mid1)
                            nu2 = nums1[i-1];
                }
                else if(j<n2)
                {
                    j++;
                    count++;
                    if(count == mid)
                            nu1 = nums2[j-1];
                    if(count == mid1)
                            nu2 = nums2[j-1];
                }
            }
        }
        else
        {
            mid = ((n1 + n2 )/ 2+1);
            int count = 0;
            while(i<n1 || j<n2)
            {
                if((i<n1 && j<n2))
                {
                    if(nums1[i]<nums2[j])
                    {
                        i++;
                        count++;
                        if(count == mid)
                            return (double)nums1[i-1];
                    }
                    else
                    {
                        j++;
                        count++;
                        if(count == mid)
                            return (double)nums2[j-1];
                    }
                }
                else if(i<n1)
                {
                    i++;
                    count++;
                    if(count == mid)
                        return (double)nums1[i-1];
                }
                else if(j<n2)
                {
                    j++;
                    count++;
                    if(count == mid)
                        return (double)nums2[j-1];
                }
            }
        }
        return (nu1+nu2)/2;
    }
}