/*
Given an unsorted array of integers, find the number of longest increasing subsequence.

Example 1:
Input: [1,3,5,4,7]
Output: 2
Explanation: The two longest increasing subsequence are [1, 3, 4, 7] and [1, 3, 5, 7].
Example 2:
Input: [2,2,2,2,2]
Output: 5
Explanation: The length of longest continuous increasing subsequence is 1, and there are 5 subsequences' length is 1, so output 5.
Note: Length of the given array will be not exceed 2000 and the answer is guaranteed to be fit in 32-bit signed int.
*/

class Solution {
    public int findNumberOfLIS(int[] nums) {
        int[][] dp = new int[nums.length][2];
        int max_len = 1,cnt=0;
        
        for(int i=0;i<nums.length;++i){
            dp[i][0] = 1;
            dp[i][1] = 1;
            for(int j=i-1;j>-1;--j){
                if(nums[i] > nums[j]){
                    if(dp[i][0] == dp[j][0] + 1) dp[i][1] += dp[j][1];
                    else if(dp[i][0] < dp[j][0] + 1){
                        dp[i][0] = dp[j][0] + 1;
                        dp[i][1] = dp[j][1];
                    }
                    
                }
            }
            max_len = Math.max(dp[i][0],max_len);
        }
        
        for(int i=0;i<nums.length;++i){
            if(dp[i][0] == max_len) cnt += dp[i][1];
        }
        
        return cnt;
    }
}
