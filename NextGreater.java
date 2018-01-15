class Solution {
    public int nextGreaterElement(int n) {        
        String s = Integer.toString(n);
        int len = s.length();
        int idx1 = -1;
        int idx2 = -1;
        
        for(int i=len-1;i>0;--i){
            for(int j=i-1;j>=0 && j > idx1;--j){
                if(s.charAt(i) > s.charAt(j)){
                    idx1 = j;
                    idx2 = i;
                    break;
                }
            }
        }
        
        if(idx1 == -1) return idx1;
        
        char[] ch = s.toCharArray();
        char temp = ch[idx1];
        ch[idx1] = ch[idx2];
        ch[idx2] = temp;
        
        int ptr1 = idx1+1;
        int ptr2 = len-1;
        
        while(ptr1 < ptr2){
            temp = ch[ptr1];
            ch[ptr1] = ch[ptr2];
            ch[ptr2] = temp;
            ptr1++;ptr2--;
        }
        
        try{
            return Integer.parseInt(new String(ch));
        }catch(NumberFormatException e){
            
        }
        
        return -1;
    }
}
