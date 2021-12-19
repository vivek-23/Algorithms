class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans = new int[nums.length - k + 1];
        Deque<Integer> dq = new ArrayDeque<Integer>();
        int ptr = 0;
        for(int i=0;i<nums.length; ++i){
            boolean it = false;
            while(!dq.isEmpty()){
                int idx = dq.peekFirst();
                if(idx <= i - k || nums[idx] <= nums[i]) dq.pollFirst();
                else break;
            } 
            
            while(!dq.isEmpty()){
                int idx = dq.peekLast();
                if(idx <= i - k || nums[idx] <= nums[i]) dq.pollLast();
                else break;
            }
            
            dq.offerLast(i);
            
            if(i >= k - 1) ans[ptr++] = nums[dq.peekFirst()];
        }
        
        
        return ans;// ofcourse for daily coding problem, we can just return array sum.
    }
}
