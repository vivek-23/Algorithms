/*
Given a string, your task is to count how many palindromic substrings in this string.

The substrings with different start indexes or end indexes are counted as different substrings even they consist of same characters.

Example 1:
Input: "abc"
Output: 3
Explanation: Three palindromic strings: "a", "b", "c".
Example 2:
Input: "aaa"
Output: 6
Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
Note:
The input string length won't exceed 1000.

*/

class Solution {
    public int countSubstrings(String s) {
        int len = s.length();
        int p_cnt = len;
        boolean[] dp = new boolean[len];
        boolean[] temp = new boolean[len];
        
        for(int i=len-1;i>=0;--i){   
            temp[i] = true;
            for(int j=i+1;j<len;++j){
                if(s.charAt(i) == s.charAt(j)){
                    if(dp[j-1] || j == i+1){
                        temp[j] = true;
                        p_cnt++;
                    }                    
                }
            }
            
            for(int j=0;j<len;++j){
                dp[j] = temp[j];
                temp[j] = false;
            }
        }        
        
        return p_cnt;
    }
}
