/*
Given a string s, find the longest palindromic subsequence's length in s. You may assume that the maximum length of s is 1000.

Example 1:
Input:

"bbbab"
Output:
4
One possible longest palindromic subsequence is "bbbb".
Example 2:
Input:

"cbbd"
Output:
2
One possible longest palindromic subsequence is "bb".

*/
class Solution {
    public int longestPalindromeSubseq(String s) {
        int len = s.length();
        int[][] dp = new int[len][len];
        
        for(int i=len-1;i>=0;--i){
            dp[i][i] = 1;
            for(int j=i+1;j<len;++j){
                dp[i][j] = Math.max(dp[i][j-1],dp[i+1][j]);
                if(s.charAt(i) == s.charAt(j)){
                    dp[i][j] = Math.max(dp[i][j],dp[i+1][j-1] + 2);
                }
            }
        }
        
        return dp[0][len-1];
    }
}
