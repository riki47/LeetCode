class DetectSquares {
    HashMap<Integer,HashMap<Integer,Integer>> out;
    public DetectSquares() {
        out = new HashMap<>();
    }
    
    public void add(int[] point) {
        int x = point[0];
        int y = point[1];

        out.putIfAbsent(x, new HashMap<>());
        HashMap<Integer, Integer> in = out.get(x);
        in.put(y, in.getOrDefault(y, 0) + 1);
    }
    
    public int count(int[] point) {
        int x1 = point[0];
        if(!out.containsKey(x1))return 0;
        int y1 = point[1];
        int res = 0;
        for(int x2 : out.keySet())
        {
            if(x1 == x2)continue; // same axis but we want opposite point
            int d = x1-x2;

            int count = out.get(x2).getOrDefault(y1,0);
            if(count > 0)
            {
                res += count * out.get(x2).getOrDefault(y1+d,0) * out.get(x1).getOrDefault(y1+d, 0);
                res += count * out.get(x2).getOrDefault(y1-d,0) * out.get(x1).getOrDefault(y1-d, 0);
            }
        }
        return res;
    }
}

/**
 * Your DetectSquares object will be instantiated and called as such:
 * DetectSquares obj = new DetectSquares();
 * obj.add(point);
 * int param_2 = obj.count(point);
 */