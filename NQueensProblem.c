#include <stdio.h>
#include <stdbool.h>


int chess_board[10][10];

bool isCellAttacked(int row,int col,int n)
{
	int i,j,start_row; 
	
	// vertical 
	
	for(i=0;i<n;++i)
	{
		if(i != row && chess_board[i][col] == 1)
			return true;
	}
	
	// horizontal 
	
	for(i=0;i<n;++i)
	{
		if(i != col && chess_board[row][i] == 1)
			return true;
	}
	
	// diagonal left 
	
	for(i=row+1,j=col+1;i<n && j < n;++i,++j)
	{
		if(chess_board[i][j] == 1)
			return true;
	}
	
	for(i=row-1,j=col-1;i>=0 && j >=0 ;--i,--j)
	{
		if(chess_board[i][j] == 1)
			return true;
	}
	
	// diagonal right 
	
	for(i=row+1,j=col-1;i<n && j >= 0;++i,--j)
	{
		if(chess_board[i][j] == 1)
			return true;
	}
	
	for(i=row-1,j=col+1;i>=0 && j < n;--i,++j)
	{
		if(chess_board[i][j] == 1)
			return true;
	}
	
	
	return false;	
}

int placeQueens(int n,int size)
{
	if(n == 0)
		return 1;
		
	int i,j;
	
	for(i=0;i<size;++i)
	{
		for(j=0;j<size;++j)
		{
			if(chess_board[i][j] == 1 || isCellAttacked(i,j,size))	
				continue;
			
			
			chess_board[i][j] = 1;
			
			if(0 == placeQueens(n-1,size))
				chess_board[i][j] = 0;
			else
				return 1;
		}	  
	}	
	
    return 0;
}

int main()
{
    int n,i,j;
    
    scanf("%d",&n);
    
    if(placeQueens(n,n))
    {
    	for(i=0;i<n;++i)
    	{
    		for(j=0;j<n;++j)
    		{
    			printf("%d ",chess_board[i][j]);
    		}
    	  printf("\n");
    	}
    }
    else
    	printf("Not possible");
   
    
    
    return 0;
}
