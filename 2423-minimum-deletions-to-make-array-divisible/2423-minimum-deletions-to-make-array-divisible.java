class Solution {
    public int minOperations(int[] nums, int[] numsDivide) {
        int gcd = numsDivide[0];
        for (int num : numsDivide) {
            gcd = findGCD(gcd, num);
        }
        PriorityQueue < Integer> pq = new PriorityQueue();
        for(int i : nums)
        {
            pq.add(i);
        }
        int cnt = 0;
        while (!pq.isEmpty()) {
            int curr = pq.peek(); // cache it
            if (gcd % curr == 0) {
                return cnt;
            } else {
                pq.poll(); // faster than remove()
                cnt++;
            }
        }

        return -1;
    }
    private int findGCD(int a, int b) {
        return b == 0 ? a : findGCD(b, a % b);
    }
}