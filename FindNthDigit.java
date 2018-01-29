class Solution {
    public int findNthDigit(int n) {
        if(n < 10) return n;
        long digits = 1,sum = 0,start = 1,end = 9,prev=0;
        
        while(sum < n){
            prev = sum;
            sum += (end - start + 1) * digits;
            start *= 10L;
            end = end * 10L + 9L;
            digits++;
        }        
                
        digits--;
        start /= 10L;
        end = (end - 9L) / 10L;  
        
        long quo  = (n - prev - 1) / digits;       
        
        return new StringBuilder(Integer.toString((int)(start + quo))).charAt((int)((n - prev - 1 - quo*digits))) - '0';
    }
}
