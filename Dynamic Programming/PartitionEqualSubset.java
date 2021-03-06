/*
Given a non-empty array containing only positive integers, find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.

Note:
Each of the array element will not exceed 100.
The array size will not exceed 200.
Example 1:

Input: [1, 5, 11, 5]

Output: true

Explanation: The array can be partitioned as [1, 5, 5] and [11].
Example 2:

Input: [1, 2, 3, 5]

Output: false

Explanation: The array cannot be partitioned into equal sum subsets.
*/

/* Approach 1 */
class Solution {
    public boolean canPartition(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for(int x:nums) sum += x;
        if((sum&1) == 1) return false;
        sum >>= 1;
        int cnt = 0;   
        
        int[][] dp = new int[nums.length+1][sum+1];
        
        for(int i=0;i<nums.length;++i){
            for(int j=1;j<=sum;++j){
                dp[i+1][j] = Math.max(dp[i+1][j-1],dp[i][j]);
                if(nums[i] > j) continue;
                dp[i+1][j] = Math.max(dp[i+1][j],dp[i][j-nums[i]] + nums[i]);
            }
            
            if(dp[i+1][sum] == sum) cnt++;
        }
        
        return cnt >= 2;
    }
}
/* Approach 2 (Optimized) */

class Solution {
    public boolean canPartition(int[] nums) {
           int sum = 0;
        for(int x:nums) sum += x;
        if((sum&1) != 0) return false;
        sum >>= 1;
        for(int i=0;i<nums.length;++i){
            if(nums[i] > sum) return false;
        }
        Arrays.sort(nums);
        int[] dp = new int[sum + 1];
        Arrays.fill(dp,-1);
        dp[0] = -2;
        for(int i=0;i<nums.length;++i){
            for(int j=1;j + nums[i] <= sum;++j){
                if(dp[j] != i && dp[j] != -1){
                    int next_possible_sum = j + nums[i];
                    dp[next_possible_sum] = dp[next_possible_sum] != -1 ? dp[next_possible_sum] : i;
                }
            }
            if(dp[sum] != -1 && dp[sum] != i && dp[sum-nums[i]] != -1) return true;
            dp[nums[i]] = i;
        }       
        
        return false;
    }
}

