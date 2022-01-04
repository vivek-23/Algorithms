class Solution {
    public void sortColors(int[] nums) {
        int ptr1 = 0,ptr2 = nums.length-1;
        int mid = 1;
        for(int i=0,j=0,k=nums.length-1; j <= k; ){
           if(nums[j] < mid){
               swap(nums,i++,j++);
           }else if(nums[j] > mid){
               swap(nums, j, k--);
           }else{
               j++;
           }
        }
    }
    
    private void swap(int[] nums,int x,int y){
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
}
