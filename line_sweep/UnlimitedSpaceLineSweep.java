class UnlimitedSpaceLineSweep {
    private TreeMap<Integer, Integer> timeline;
    public UnlimitedSpaceLineSweep() {
         timeline = new TreeMap<>();
    }
    
    public int add(int s, int e) {
        timeline.put(s, timeline.getOrDefault(s, 0) + 1); 
        timeline.put(e, timeline.getOrDefault(e, 0) - 1); 
        int ongoing = 0, k = 0;
        for (int v : timeline.values())
            k = Math.max(k, ongoing += v);
        return k;
    }
}
