public class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> l = new ArrayList<Integer>();        
        for(int i=1;i<=9 && i<=n;++i){
            l.add(i);
            generateForMSB(i*10,n,l);
        }        
        return l;
    }
    
    public void generateForMSB(int num,int n,List<Integer> l){
        for(int i=num;i<=n && i-num <= 9 && i>9;++i){
            l.add(i);      
            generateForMSB(i*10,n,l);
        }
    } 
}
