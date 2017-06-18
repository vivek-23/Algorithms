public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        
        long N = numerator,
             D = denominator,
             quo = 0;
        
        if(numerator == 0) return "0";
        
        StringBuilder s = new StringBuilder("");
        
        Map<Long,Integer> m = new HashMap<Long,Integer>();
        boolean decimal_ins = false;
        boolean sign_positive = false;
        
        sign_positive = numerator >= 0 && denominator >=0 || numerator < 0 && denominator < 0;
        
        N = Math.abs(N);
        D = Math.abs(D);
        
        while(N != 0){
            if(m.containsKey(N)){
                s.insert((int)m.get(N),'(');
                s.append(')');
                break;
            }
            m.put(N,s.length());
            quo = N/D;
            if(quo == 0){
                if(!decimal_ins) s.append("0.");
                else s.append("0");
                decimal_ins = true;
            }
            else s.append(String.valueOf(quo));
            N = N%D;
            if(N < D){
                if(!decimal_ins && N>0){
                    s.append(".");
                    decimal_ins = true;
                }
                N *= 10L;
            }
        }
        
        return sign_positive ? s.toString() : "-"+s.toString();
    }
}
