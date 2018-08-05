/*

Given an array A[] of positive integers. The task is to complete the function which returns an integer denoting the minimum sum subsequence from the array such that at least one value among all groups of four consecutive elements is picked.
Examples:

Input: A[] = {1, 2, 3, 4, 5, 6, 7, 8}
Output: 6
6 is sum of output subsequence {1, 5}
Following 4 length subarrays are possible
(1, 2, 3, 4), (2, 3, 4, 5), (3, 4, 5, 6),
(4, 5, 6, 7), (5, 6, 7, 8)
Here, Our subsequence {1, 5} has an element from all
above groups of four consecutive elements.

Input : A[] = {1, 2, 3, 3, 4, 5, 6, 1}
Output : 4
The subsequence is {3, 1}. Here we consider
second three.

Input:
The first line of input contains an integer T denoting the no of test cases. Then T test cases follow. Each test case contains two lines. The first line of each test case contains an integer N. Then in the next line are N space separated values of the array A[].

Output:
For each test case in a new line output will be the min sum of such subsequence .

Constraints:
1<=T<=100
1<=N<=50
1<=A[]<=1000

Example(To be used only for expected output):
Input:
2
8
1 2 3 4 5 6 7 8
8
1 2 3 3 4 5 6 1
Output:
6
4

*/
class GfG{
	public static int minSum(int arr[], int n){
	    int[] dp = new int[n];
	    if(arr.length <= 4){
	        int mini = Integer.MAX_VALUE;
	        for(int i=0;i<arr.length;++i) mini = Math.min(arr[i],mini);
	        return mini;
	    }
	    
	    dp[0] = arr[0];
	    dp[1] = arr[1];
	    dp[2] = arr[2];
	    dp[3] = arr[3];
	    
	    for(int i=4;i<n;++i) dp[i] = arr[i] + minimum(dp[i-1],dp[i-2],dp[i-3],dp[i-4]);
	 
	    return minimum(dp[n-1],dp[n-2],dp[n-3],dp[n-4]);   
	}
	
	private static int minimum(int a,int b,int c,int d){
	    return Math.min(Math.min(a,b),Math.min(c,d));   
	}
}
