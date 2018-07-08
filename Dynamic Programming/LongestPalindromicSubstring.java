class Solution {
    public String longestPalindrome(String s) {
        int len = s.length(),max_len = 1;
        if(len == 0) return "";
        boolean[][] dp = new boolean[len][len];
        String max_pstring = "" + s.charAt(0);
        
        for(int i=0;i<len;++i) dp[i][i] = true;
        
        for(int i=2;i<=len;i++){
            for(int j=0;j<=len-i;++j){
                if(s.charAt(j) == s.charAt(j+i-1)){
                    if(i == 2 || dp[j+1][j+i-2]) dp[j][j+i-1] = true;                    
                    if(dp[j][j+i-1] && max_len < i){
                        max_len = i;
                        max_pstring = s.substring(j,j+i);
                    }
                }
            }    
        }       
        
        
        return max_pstring;
    }
}