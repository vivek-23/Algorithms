/*
Given an array of n positive integers. Write a program to find the sum of maximum sum subsequence of the given array such that the integers in the subsequence are sorted in increasing order.

Input:

The first line of input contains an integer T denoting the number of test cases.
The first line of each test case is N,N is the size of array.
The second line of each test case contains N input A[].

Output:

Print the sum of maximum sum sequence of the given array.

Constraints:

1 ≤ T ≤ 100
1 ≤ N ≤ 100
1 ≤ A[] ≤ 1000

Example:

Input:
2
7
1 101 2 3 100 4 5
4
10 5 4 3

Output:
106
10

Explanation:
For input:
7
1 101 2 3 100 4 5
All the increasing subsequences : (1,101); (1,2,3,100); (1,2,3,4,5), out of this (1,2,3,100) has maximum sum,i.e., 106. Hence the output is stated as 106.

*/
#include<stdio.h>

int dp[205]={0};

int max(int a,int b){
  return a > b ? a : b;
}

int min(int a,int b){
  return a < b ? a : b;
}


int someFunction(int n,int *arr)
{
	int i,j;
	int maxi = 0;
	
	for(i=0;i<n;++i){
	    dp[i] = arr[i];
	    for(j=0;j<i;++j){
	        if(arr[i] > arr[j]) dp[i] = max(dp[i],arr[i] + dp[j]);
	    }
	    
	    maxi = max(maxi,dp[i]);
	}
	
	return maxi;
}


void input()
{
	int i,n,t;
	int arr[205];
	scanf("%d",&t);

	while(t--)
	{
		scanf("%d",&n);
		for(i=0;i<n;++i) scanf("%d",&arr[i]);
		printf("%d\n",someFunction(n,arr));
	}


}


int main()
{
  input();
	return 0;
}
