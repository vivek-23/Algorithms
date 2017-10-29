class Solution {
    public List<List<Integer>> threeSum(int[] nums) {      
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        int j,k,target;
        int len = nums.length;
        
        for(int i=0;i+2<len;++i){
            if(i > 0 && nums[i] == nums[i-1]) continue;
            j = i+1;k=len-1;
            target = -nums[i];
            while(j < k){
                if(nums[j] + nums[k] == target){
                    res.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    j++;
                    k--;
                    while(j < k && nums[j] == nums[j-1]) j++;
                    while(k > j && nums[k] == nums[k+1]) k--;
                }else if(nums[j] + nums[k] > target) k--;
                else j++;
            }
        }
        
        
        return res;
    }
}
