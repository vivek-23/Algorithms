public class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
        
        if(matrix == null || matrix.length == 0) return new int[0];
        
        int rows = matrix.length,cols = matrix[0].length;
        int[] ele = new int[rows*cols];
        int ptr = -1,
            row = 0,
            col = 1,
            i = 0,
            j = 0,
        next_col = 0,
        next_row = 0;
        
        boolean up = true;       
        
        while(ptr < ele.length-1){                      
            if(up){
                if(next_col >= cols) next_col = cols-1;
                if(row >= rows) row = rows-1;
                
                for(i=row,j=next_col;i>=0 && j < cols;--i,++j) 
                    ele[++ptr] = matrix[i][j];   
                row += 2;
                
                if(j == cols) next_row = i+2;
            }else{
                if(next_row >= rows) next_row = rows-1;
                if(col>= cols) col = cols-1;
                
                for(j=col,i=next_row;j>=0 && i < rows;++i,--j) 
                    ele[++ptr] = matrix[i][j];
                col += 2;
                
                if(i == rows) next_col = j+2;
            }                
            up = !up;
        }        
        
        return ele;
    }
}
