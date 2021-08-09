/*

You are given a two-dimensional list of integers matrix. You can move up, left, right, down and each move from matrix[a][b] to
matrix[c][d] costs abs(matrix[a][b] - matrix[c][d]).

Return the minimum cost to move from the top left corner to the bottom right corner.

Input:
matrix = [
    [1, 100, 1],
    [2, 5, 3],
    [1, 2, 3]
]
Output:
4
Explanation:
We can move from 1 -> 2 -> 1 -> 2 -> 3.

*/
import java.util.*;

class Solution {
    public int solve(int[][] matrix) {
        int rows = matrix.length,cols = matrix[0].length;
        int[][] dp = new int[rows][cols];
        for(int i=0;i<rows;++i) Arrays.fill(dp[i],-1);
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(100,(a,b) -> (a[2] - b[2]));
        pq.offer(new int[]{0,0,0});
        dp[0][0] = 0;
        int[][] dirs = {{-1,0},{1,0},{0,1},{0,-1}};
        boolean[][] vis = new boolean[rows][cols];
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int cost = curr[2];
            vis[curr[0]][curr[1]] = true;
            for(int[] d : dirs){
                int x = d[0] + curr[0];
                int y = d[1] + curr[1];
                if(x < 0 || y < 0 || x == rows || y == cols || vis[x][y]) continue;
                int cc = Math.abs(matrix[curr[0]][curr[1]] - matrix[x][y]);
                if(dp[x][y] == -1 || dp[x][y] > cc + cost){
                    dp[x][y] = cc + cost;
                    pq.offer(new int[]{x,y,cc + cost});
                }
            }            
        }

        return dp[rows-1][cols-1];
    }
}
