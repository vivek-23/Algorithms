class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.length() == 0) return 0;
        if(haystack.length() < needle.length()) return -1;
        int[] computedTable = generateTable(needle);
        int ptr = 0 , i = 0;
        for(; i < haystack.length() && ptr < needle.length();++i){
            if(haystack.charAt(i) == needle.charAt(ptr)){
                ptr++;
            }else{
                if(ptr != 0) i--;
                ptr = ptr == 0 ? 0 : computedTable[ptr - 1];   
            }
        }
        
        return ptr == needle.length() ? i - needle.length() : -1;
    }
    
    private int[] generateTable(String needle){
        int len = needle.length();
        int[] table = new int[len];
        table[0] = 0;
        int j = 0;
        
        for(int i=1;i<len;++i){
            if(needle.charAt(i) == needle.charAt(j)){
                table[i] = j+1;
                j++;
            }else{
                j = table[i-1];
                while(j > 0 && needle.charAt(i) != needle.charAt(j)){
                    j = table[j-1];
                }
                table[i] = needle.charAt(j) == needle.charAt(i) ? j + 1 : 0; 
            }
        }
        
        
        return table;
    }
}
