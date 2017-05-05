public class Solution{
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if(numCourses == 0) return new int[0];
        
        List<List<Integer>> li = new ArrayList<List<Integer>>();
        List<Integer> cord = new ArrayList<Integer>();
        
        for(int i=0;i<numCourses;++i)   
            li.add(new ArrayList<Integer>());
        
        for(int i=0;i<prerequisites.length;++i)
            li.get(prerequisites[i][0]).add(prerequisites[i][1]);
        
        boolean[] vis = new boolean[numCourses];
        boolean[] c_taken = new boolean[numCourses];
        for(int i=0;i<numCourses;++i)   
        {
            if(!c_taken[i] && !dfs(li,i,vis,c_taken,cord))
                    return new int[0];
            // System.out.println(i);
        }

        int[] c_order = new int[numCourses];

        for(int i=0;i<numCourses;++i)
            c_order[i] = cord.get(i);

        return c_order;
    }
    
    public boolean dfs(List<List<Integer>> li,int c_index,boolean[] vis,boolean[] c_taken,List<Integer> cord)
    {
        if(c_taken[c_index]) return true;
        
        List<Integer> course = li.get(c_index);
        int size = course.size();

        vis[c_index] = true;
        // System.out.println("c_size " + size);
        for(int j=0;j<size;++j)
        {
            int c = course.get(j);
            if((!c_taken[c] && vis[c]) || !dfs(li,c,vis,c_taken,cord))
                return false;            
        }

        vis[c_index] = false;
        c_taken[c_index] = true;
        cord.add(c_index);
        // System.out.println("c_index " + c_index);
        return true;
    }
}
