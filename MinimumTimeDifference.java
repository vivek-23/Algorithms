public class Solution {
    public int findMinDifference(List<String> timePoints) {
        boolean[] timeScale = new boolean[1440];
        int min_diff = 1441,ind=0;
        
        int size = timePoints.size();
        for(int i=0;i<size;++i)
        {
            String[] t = timePoints.get(i).split(":");
            ind = Integer.parseInt(t[0])*60+Integer.parseInt(t[1]);
            if(timeScale[ind])
                return 0;
            timeScale[ind] = true;
        }
        
        for(int i=0,last_visited=-1;i<1440;++i)
        {
            if(timeScale[i])
            {
                if(last_visited != -1)
                    min_diff = Math.min(min_diff,i-last_visited);
                last_visited = i;
            }
        }
        
        int[] first_half = new int[]{-1,-1};
        int[] second_half = new int[]{-1,-1};
        
        for(int i=0;i<720;++i)
        {
            if(timeScale[i])
                first_half[0] = first_half[0] == -1 ? i : first_half[0];
            if(timeScale[720-i-1])
                first_half[1] = first_half[1] == -1 ? 720-i-1 : first_half[1];
            if(first_half[0] != -1 && first_half[1] != -1) break;
        }
        
        for(int i=720;i<1440;++i)
        {
            if(timeScale[i])
               second_half[0] =  second_half[0] == -1 ? i : second_half[0];
            if(timeScale[1440-(i-720+1)])
               second_half[1] = second_half[1] == -1 ? 1440-(i-720+1) : second_half[1];
            if(second_half[0] != -1 && second_half[1] != -1) break;
        }
       
        
        if(first_half[0] != -1 && second_half[0] != -1)
        {
            min_diff = Math.min(min_diff,second_half[0] - first_half[1]);
            min_diff = Math.min(min_diff,1440 + first_half[0] - second_half[1]);
        }
    
        
        
        return min_diff;
    }
    
}
