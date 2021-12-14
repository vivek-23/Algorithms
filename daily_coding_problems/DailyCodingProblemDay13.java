import java.util.*;
public class DailyCodingProblemDay13 {
    public static void main(String args[]) {
      System.out.println(longestSubstringK("abcba", 2));
    }
    
    private static String longestSubstringK(String s, int K){
        int[] hash = new int[26];
        int start = 0;
        int ss = -1, e = -1;
        for(int i=0;i<s.length();++i){
            hash[s.charAt(i)-'a']++;
            while(start < i && moreThanK(hash, K)){
                hash[s.charAt(start++)-'a']--;
            }
            
            if(ss == -1 || e - ss < i - start + 1){
                ss = start;
                e = i + 1;
            }
        }
        
        return s.substring(ss ,e);
    }
    
    private static boolean moreThanK(int[] hash,int K){
        for(int i=0;i<hash.length;++i){
            if(hash[i] > 0) K--;
        }
        
        return K < 0;
    }
}
