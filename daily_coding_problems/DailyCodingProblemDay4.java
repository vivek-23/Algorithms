class DailyCodingProblemDay4 {
    public int firstMissingPositive(int[] nums) {
        for(int i=0;i<nums.length;++i){
            while(nums[i] <= nums.length && nums[i] > 0 && nums[i] != i + 1){
                if(nums[ nums[i] - 1] == nums[i]) break;
                swap(nums, i, nums[i] - 1);
            }
        }
        
        
        for(int i=0;i<nums.length;++i){
            if(nums[i] != i + 1) return i + 1;
        }
        
        return nums.length + 1;
    }
    
    private void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
