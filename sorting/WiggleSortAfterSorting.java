class WiggleSortAfterSorting {
    public void wiggleSort(int[] nums) {
        int[] t = Arrays.copyOf(nums,nums.length);
        boolean even = nums.length % 2 == 0;
        Arrays.sort(t);
        int ptr2 = nums.length/2;
        if(!even) ptr2++;
        
        for(int i=ptr2-1,j=0;i>=0;i--,j+=2) nums[j] = t[i];
        for(int i=nums.length-1,j=1;i>=ptr2;i--,j+=2) nums[j] = t[i];        
    }
}
