import java.util.*;
class BalancedBrackets
{
	public static void main(String args[])
	{
	   Scanner sc = new Scanner(System.in);
	   
	   int t = Integer.parseInt(sc.nextLine());
	   
	   while(t-- > 0)
	   {
		   System.out.println(balancedBracketsChecker(sc.nextLine()) ? "balanced" : "not balanced");
	   }
	   
        }
	
	public static boolean balancedBracketsChecker(String s)
	{
		Stack<Character> st = new Stack<Character>();
		
		int len = s.length();
		
		for(int i=0;i<len;++i)
		{			
			switch(s.charAt(i))
			{
				case '{':
				case '[':
				case '(':
					st.push(s.charAt(i));			
					break;
				case '}':
					if(st.isEmpty() || st.peek() != '{')
						return false;
					st.pop();
					break;
				case ']':
					if(st.isEmpty() || st.peek() != '[')
						return false;
					st.pop();
					break;
				case ')':
					if(st.isEmpty() || st.peek() != '(')
						return false;
					st.pop();
					
			}			
		}
		
		return st.isEmpty();		    
	}
}
