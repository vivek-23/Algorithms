public class Solution {
    public int maxSubArray(int[] nums) {
        // kadane's algorithm
        
        if(nums == null || nums.length == 0) return 0;
        
        int max_till_now = nums[0],
            max_sub_sum = nums[0];
        
        for(int i=1;i<nums.length;++i)
        {
            
            if(nums[i] > nums[i] + max_till_now)
                max_till_now = nums[i];
            else
                max_till_now += nums[i];
            
            if(max_sub_sum < max_till_now)
                max_sub_sum = max_till_now;
        }
        
        return max_sub_sum;
    }
}
