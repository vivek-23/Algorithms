/*
Given a set of non-negative integers, and a value sum, determine if there is a subset of the given set with sum equal to given sum.

Examples: set[] = {3, 34, 4, 12, 5, 2}, sum = 9
Output:  True  //There is a subset (4, 5) with sum 9.

*/
class Solution{
  public static boolean possibleSubsetSum(int[] arr,int s){
        int[][] dp = new int[arr.length+1][s+1];
        for(int i=1;i<=arr.length;++i){
            for(int j=1;j<=s;++j){
                dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
                if(j >= arr[i-1]) dp[i][j] = Math.max(dp[i-1][j-arr[i-1]] + arr[i-1],dp[i][j]);
                if(dp[i][j] == s){
                    return true;                  
                }
            }
        }       
        
        return false;
    }
}
