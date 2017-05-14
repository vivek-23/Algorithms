import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);        
        int q = Integer.parseInt(sc.next());       
        int q_type=0,num=0;
        
        Stack<Integer> s1 = new Stack<Integer>();
        Stack<Integer> s2 = new Stack<Integer>();
        
        while(q-- > 0)
        {
            q_type = Integer.parseInt(sc.next());          
            
            if(q_type == 1)
            {
                num = Integer.parseInt(sc.next());
                s2.push(num);
            }
            else if(q_type == 2)
            {
                if(s1.isEmpty())
                    while(!s2.isEmpty())
                        s1.push(s2.pop());                    
                s1.pop();
            }
            else
            {
                if(s1.isEmpty())
                    while(!s2.isEmpty())
                         s1.push(s2.pop());
                System.out.println(s1.peek());
            }
            
        }
        
    }
}
