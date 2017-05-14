/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class SortIntervals implements Comparator<Interval>
{
    public int compare(Interval x,Interval y)
    {
        if(x.start < y.start) return -1;
        if(x.start > y.start) return 1;
        if(x.end > y.end) return 1;
        if(x.end < y.end) return -1;
        return 0;
    }
}

public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals,new SortIntervals());
        List<Interval> merged = new ArrayList<Interval>();
        
        int size = intervals.size();
        int start = -1,
            end = -1,
            x = 0,
            y = 0,
            prev_x = -1,
            prev_y = -1;
        
        for(int i=0;i<size;++i)
        {
            start = intervals.get(i).start;
            end = intervals.get(i).end;
            prev_x = start;
            prev_y = end;
            
            for(int j=i+1;j<size;++j)
            {
                x = intervals.get(j).start;
                y = intervals.get(j).end;
                
                if(x > prev_y)
                {
                    i = j-1;
                    break;
                }
                
                prev_x = x;
                prev_y = Math.max(prev_y,y);
                i = j;
            }
            
            merged.add(new Interval(start,prev_y));
        }
        
        return merged;
    }
}
