#include<stdio.h>

int elementOccurringOnce(int *arr,int n)
{
	int low = 0 ,
	    high = n-1,
	    mid = 0;
	    
	    
	 while(low <= high)   
	 {
	     mid = low + (high - low) / 2;
	     
	     if(mid == 0 || mid == n-1)
	        return arr[mid];
	     
	     
	     if(mid%2 == 1)
	     {
	          if(arr[mid] == arr[mid+1])
	            high = mid - 1;
	          else if(arr[mid] == arr[mid-1])
	            low = mid + 1;
	          else
	            return arr[mid];
	     }
	     else
	     {
	         if(arr[mid] == arr[mid+1])
	            low = mid + 1;
	          else if(arr[mid] == arr[mid-1])
	            high = mid - 1;
	          else
	            return arr[mid];
	     }
	 }
	    
	 return arr[low]; 
}


void input()
{
	int i,n,t;
	int arr[1000];
	scanf("%d",&t);

	while(t--)
	{
		scanf("%d",&n);

		for(i=0;i<n;++i)
			scanf("%d",&arr[i]);

		printf("%d\n",elementOccurringOnce(arr,n));
	}


}


int main()
{
    input();
	return 0;
}
