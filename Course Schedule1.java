public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        
        boolean[] visited = new boolean[numCourses];
        boolean[] nodes_visited = new boolean[numCourses];
        List<List<Integer>> nodes = new ArrayList<List<Integer>>();
        
        for(int i=0;i<numCourses;++i)
            nodes.add(new ArrayList<Integer>());
        
        for(int i=0;i<prerequisites.length;++i)
        {
            nodes.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }    
        
        
    
        return detectCycle(nodes,visited,nodes_visited);
    }
    
    public boolean detectCycle(List<List<Integer>> nodes,boolean[] visited,boolean[] nodes_visited)
    {
        int len = nodes.size(),
            len1 = 0;
            
            
        
        for(int i=0;i<len;++i)
        {
            if(visited[i])
                continue;
                
            visited[i] = true;
            nodes_visited[i] = true;
            
            len1 = nodes.get(i).size();
            
            for(int j=0;j<len1;++j)
            {
                int x = nodes.get(i).get(j);
                
                if(detectCycleHelper(nodes,visited,nodes_visited,i,x))
                    return false;
            }
            
            nodes_visited[i] = false;
            
        }
        
        return true;
    }
    
    public boolean detectCycleHelper(List<List<Integer>> nodes,boolean[] visited,boolean[] nodes_visited,int parent,int current)
    {
        if(visited[current])
        {
            return false;
        }
            
        visited[current] = true;
        nodes_visited[current] = true;
        
        int len = nodes.get(current).size();
        
        for(int i=0;i<len;++i)
        {
            int x = nodes.get(current).get(i);
            
            if(nodes_visited[x] || detectCycleHelper(nodes,visited,nodes_visited,current,x))
                return true;
        }
        
        nodes_visited[current] = false;
        
        return false;
    }
    
}
