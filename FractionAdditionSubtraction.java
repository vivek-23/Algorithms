public class Solution {
    
    public int GCD(int num1,int num2)
    {
        if(num1%num2 == 0) return num2;
        return GCD(num2,num1%num2);
    }
    
    public int LCM(int num1,int num2)
    {
        return num1*num2/GCD(num1,num2);
    }
    
    public String fractionAddition(String exp) {
	       
	   if(exp == null || exp.length() == 0) return "";    
	       
        int len = exp.length();
        int num1 = 0,
            num2 = 0,
            deno1 = 0,
            deno2 = 0,
            new_deno = 0;
            
        List<String> fractions = new ArrayList<String>();
        List<Character> operators = new ArrayList<Character>();

        for(int i=0;i<len;++i)
        {
            StringBuilder s = new StringBuilder("");
            s.append(exp.charAt(i));
            for(int j=i+1;j<len;++j)
            {
            	i = j;
            	if((exp.charAt(j) == '+' || exp.charAt(j) == '-') && exp.charAt(j-1)-'0' >= 0)
            	{
            		operators.add(exp.charAt(j));
            		break;
            	}
            	s.append(exp.charAt(j));
            }
            fractions.add(s.toString());            
        }

        int size = fractions.size();
        
        String[] s1 = fractions.get(0).split("/");
        num1  = Integer.parseInt(s1[0]);
        deno1 = Integer.parseInt(s1[1]);
        
        if(deno1 < 0)
        {
            deno1 = -deno1;
            num1 = -num1;
        }
        

        for(int i=1;i<size;i++)
        {
            s1 = fractions.get(i).split("/");    
            num2  = Integer.parseInt(s1[0]);
            deno2 = Integer.parseInt(s1[1]);
            
            if(deno2 < 0)
            {
                deno2 = -deno2;
                num2 = -num2;
            }
            
            new_deno = LCM(deno1,deno2);
            
            char op = operators.get(i-1);
            
            if(op == '+')
                num1  = num1 * (new_deno/deno1) + num2 * (new_deno/deno2);
            else
                num1  = num1 * (new_deno/deno1) - num2 * (new_deno/deno2);
                
            deno1 = new_deno;
        }
    
        int gcd = GCD(num1,deno1);
        num1 /= gcd;
        deno1 /= gcd;
        
        if(deno1 < 0)
        {
            deno1 = -deno1;
            num1 = -num1;
        }
        
        return String.valueOf(num1) + "/" + String.valueOf(deno1);
    }

}
