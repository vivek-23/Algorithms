public class Solution {
    public boolean find132pattern(int[] nums) {
        
        if(nums==null || nums.length < 3) return false;
        
        int len = nums.length,
            num = 0;
        int min_left[]  = new int[len];
        Stack<Integer> st = new Stack<Integer>();
        
        min_left[0]  = nums[0];
        
        for(int i=1;i<len;++i) min_left[i] = min_left[i-1] > nums[i] ? nums[i] : min_left[i-1];
        
        for(int i=len-1;i>=0;--i)
        {
            if(nums[i] > min_left[i])
            {
                while(!st.isEmpty() && st.peek() < nums[i])
                {
                    num = st.pop();
                    if(num > min_left[i]) return true;
                }
                
                st.push(nums[i]);
            }
        }
        
        
        
        return false;
    }
}
