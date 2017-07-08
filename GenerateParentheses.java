public class Solution {
    char open_char = '(';
    char closed_char = ')';
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        combinations(n,n,n*2,"",res);
        return res;
    }
    
    public void combinations(int open,int closed,int max_len,String s,List<String> res){
        if(open < 0) return;
        else if(s.length() == max_len){
            res.add(s);
            return;
        }
        
        combinations(open-1,closed,max_len,s+open_char,res);
        if(open < closed){
            combinations(open,closed-1,max_len,s+closed_char,res);
        }
    }
    
}
