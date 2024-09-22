class Solution {
        public int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> h1 = new HashMap<>();
            int n = nums.length;
    
          
            for (int i = 0; i < n; i++) {
                h1.put(nums[i], i);
            }
    
            
            for (int i = 0; i < n; i++) {
                int val = target - nums[i];
                if (h1.containsKey(val) && h1.get(val) != i) {
                    int arr1[] = new int[2];
                    arr1[0] = i;
                    arr1[1] = h1.get(val);
                    return arr1;
                }
            }

            int arr[] = new int[]{};
            return arr; // No solution found
        }
    }