class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        // Build a max‑heap keyed first by distance (descending), then by value (descending)
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> {
                if (a[0] != b[0]) {
                    return b[0] - a[0];      // larger distance first
                } else {
                    return b[1] - a[1];      // if same distance, larger value first
                }
            }
        );
        
        // 1) Push each element (distance, value), keep heap size ≤ k
        for (int v : arr) {
            pq.offer(new int[]{ Math.abs(v - x), v });
            if (pq.size() > k) {
                pq.poll();
            }
        }
        
        // 2) Collect the survivors
        List<Integer> ans = new ArrayList<>();
        while (!pq.isEmpty()) {
            ans.add(pq.poll()[1]);
        }
        
        // 3) Return in sorted order
        Collections.sort(ans);
        return ans;
    }
}
