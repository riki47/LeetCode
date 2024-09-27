class MyCalendarTwo {
    TreeMap<Integer, Integer> events;

    public MyCalendarTwo() {
        events = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        events.put(start, events.getOrDefault(start, 0)+1);
        events.put(end, events.getOrDefault(end, 0) - 1);
        int ab = 0;
        int max = 0;
        for (int delta : events.values()) {
            // activeBookings += delta;
            // if (activeBookings >= 3) {
            //     events.put(start, events.get(start) - 1);
            //     events.put(end, events.get(end) + 1);
            //     if (events.get(start) == 0) events.remove(start);
            //     if (events.get(end) == 0) events.remove(end);
            //     return false;
            // }
            ab+=delta;
            max = Math.max(ab,max);
        }
        if(max>2)
        {
            if(events.get(start) == 1)
                events.remove(start);
            else
                events.put(start, events.get(start)-1);


            if(events.get(end) == -1)
                events.remove(end);
            else
                events.put(end, events.get(end) + 1);

            return false;
        }
        return true;
    }
}
