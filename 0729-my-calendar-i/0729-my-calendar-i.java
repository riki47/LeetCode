class MyCalendar {
    TreeMap<Integer, Integer> a1;

    public MyCalendar() {
        a1 = new TreeMap<>();
        a1.put(0,0);
    }
    
    public boolean book(int start, int end) {
        for(Map.Entry <Integer,Integer> m1 : a1.entrySet())
        {
            if(m1.getKey()<end && m1.getValue()>end)
            {
                return false;
            }
            if(m1.getValue()>start && m1.getKey()<end)
            {
                return false;
            }
        }
        this.a1.put(start,end);
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */