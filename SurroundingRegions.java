public class Solution {
    public static void solve(char[][] board) {
        
        if(board == null || board.length == 0)
            return;
        
            
        int rowL = board.length,
            colL = board[0].length;
        
        boolean[][] visited = new boolean[rowL][colL];
        // first row 
            for(int i=0;i<colL;++i)
                if(!visited[0][i] && board[0][i] == 'O')
                   bfs(board,0,i,visited,rowL,colL);
        
        // last row
            for(int i=0;i<colL;++i)
                if(!visited[rowL-1][i] && board[rowL-1][i] == 'O')
                    bfs(board,rowL-1,i,visited,rowL,colL);
        // first col
            for(int i=0;i<rowL;++i)
                if(!visited[i][0] && board[i][0] == 'O')
                    bfs(board,i,0,visited,rowL,colL);
        //  last col
            for(int i=0;i<rowL;++i)
                if(!visited[i][colL-1] && board[i][colL-1] == 'O')
                    bfs(board,i,colL-1,visited,rowL,colL);
        
        
        for(int i=0;i<rowL;++i)
        {
            for(int j=0;j<colL;++j)
            {
                if(board[i][j] == '1')
                    board[i][j] = 'O';
                else if(board[i][j] == 'O' && i!=0 && i!= rowL-1 && j !=0 && j!= colL-1)
                    board[i][j] = 'X';
            }
        }
    }
    
    public static void bfs(char[][] board,int e,int t,boolean[][] visited,int R,int C)
    {
        Queue<Location> q = new LinkedList<Location>();
        Location u = new Location(e,t);
        q.add(u);

        visited[e][t] = true;

        while(!q.isEmpty())
        {
            Location o = q.remove();
            board[o.x][o.y] = '1';

            if(o.x - 1 >=0 && o.x - 1 < R && !visited[o.x-1][o.y] && board[o.x-1][o.y] == 'O')
            {
                visited[o.x-1][o.y] = true;
                q.add(new Location(o.x-1,o.y));
            }
                
            if(o.x + 1 >=0 && o.x + 1 < R && !visited[o.x+1][o.y] && board[o.x+1][o.y] == 'O')
            {
                visited[o.x+1][o.y] = true;
                q.add(new Location(o.x+1,o.y));
            }
                
            if(o.y - 1 >=0 && o.y - 1 < C && !visited[o.x][o.y-1] && board[o.x][o.y-1] == 'O')
            {
                visited[o.x][o.y-1] = true;
                q.add(new Location(o.x,o.y-1));
            }
                
            if(o.y + 1 >=0 && o.y + 1 < C && !visited[o.x][o.y+1] && board[o.x][o.y+1] == 'O')
            {
                visited[o.x][o.y+1] = true;
                q.add(new Location(o.x,o.y+1));
            }
        }
        
    }
}

class Location
{
    int x,y;
    Location(int x,int y)
    {
        this.x = x;
        this.y = y;
    }
}
