/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        if(intervals == null || intervals.size() == 0) return new ArrayList<Interval>();
        Collections.sort(intervals,new Comparator<Interval>(){
            public int compare(Interval v1,Interval v2){
                if(v1.start < v2.start) return -1;
                else if(v1.start > v2.start) return 1;
                
                if(v1.end > v2.end) return -1;
                else if(v1.end < v2.end) return 1;
                return 0;
            }            
        });
        
        List<Interval> merged_intervals = new ArrayList<Interval>();
        int size = intervals.size();    
        int running_max_end = intervals.get(0).end;
        int running_min_start = intervals.get(0).start;
        for(int i=1;i<size;++i){
            if(intervals.get(i).start > running_max_end){
                merged_intervals.add(new Interval(running_min_start,running_max_end));
                running_min_start = intervals.get(i).start;
                running_max_end = intervals.get(i).end;                
            }else{
                running_max_end = Math.max(running_max_end,intervals.get(i).end);
            }
        }
        merged_intervals.add(new Interval(running_min_start,running_max_end));
        return merged_intervals;
    }
}
