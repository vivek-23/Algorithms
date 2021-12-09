class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        int s1 = nums[0],s2 = nums[1];
        for(int i=2;i<nums.length;++i){
            int s3 = s1 + nums[i];
            s1 = Math.max(s2,s1);
            s2 = s3;
        }
        return Math.max(s1,s2);
    }
}
