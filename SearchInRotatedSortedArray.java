public class Solution {
    public int search(int[] nums, int target) {
        
        if(nums == null || nums.length == 0) return -1;
        
        int low = 0,
            high = nums.length - 1,
            mid = 0;
            
        while(low < high)
        {
            mid = low + (high - low)/2;
            
            if(nums[mid] == target) return mid;
            if(nums[mid] < target)
            {
                if(nums[low] > nums[mid] && nums[low] <= target) high = mid-1;
                else low = mid + 1;
            }
            else if(nums[mid] > target)
            {
                if(nums[low] > nums[mid] || nums[low] <= target) high = mid-1;
                else low = mid+1;
            }
        }
            
        return nums[low] == target ? low : -1;
    }
}
