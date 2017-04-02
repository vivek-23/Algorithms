import java.io.*;
import java.util.*;
class ZigzagCiphering
{
	static void initialize(StringBuilder[] rows)
	{
		for(int i=0;i<rows.length;++i)
			rows[i] = new StringBuilder("");
	}
	
    private static String zigzagEncrypt(String s,int numRows) 
	{    
        int len = s.length();
        
        if(len <= 1 || numRows <= 1)
        return s;
        
		int ptr = 1;
		boolean increment_value = true;
		StringBuilder rows[] = new StringBuilder[numRows];
		StringBuilder zigzag = new StringBuilder();
		ZigzagCiphering.initialize(rows);
		
		for(int i=0;i<len;++i)
		{
			rows[ptr-1].append(s.charAt(i));
			if(ptr == numRows)
			{
				increment_value = false;
			}
			else if(ptr == 1)
			{
				increment_value = true;
			}			
			ptr = increment_value?ptr+1:ptr-1;
		}
		
		
		for(int i=0;i<numRows;++i)
		{
			zigzag.append(rows[i]);
		}		
		
		
		return zigzag.toString();   
    }
	private static String zigzagDecrypt(String s,int n)
	{		
		int sum = 0,temp=0,len = s.length();
		
		if(len<=1 || n == 1)
			return s;
		
		int[] frequency = hits(s,n,len);		
		int[] indexes = frequency;		
		int ptr = 1;
		boolean increment_value = true;
		StringBuilder zigzag = new StringBuilder("");
		
		for(int i=0;i<indexes.length;++i)
		{
			temp = indexes[i];
			indexes[i] = sum;
			sum += temp;
		}
		
		while(len-- > 0)
		{
			zigzag.append(s.charAt(indexes[ptr-1]++));
			if(ptr == n)
			{
				increment_value = false;
			}
			else if(ptr == 1)
			{
				increment_value = true;
			}
		  ptr = increment_value?ptr+1:ptr-1;
		}		
			
		return zigzag.toString();
	}
	private static int[] hits(String s,int n,int len)
	{
		int[] freq = new int[n];
		int ptr = 1;		
		boolean increment_value = true;
		
		Arrays.fill(freq,0);
		
		for(int i=0;i<len;++i)
		{
			freq[ptr-1] += 1;
			
			if(ptr == n)
			{
			   increment_value = false;	
			}
			else if(ptr == 1)
			{
				increment_value = true;
			}
		   	
		   ptr = increment_value?ptr+1:ptr-1;
		}
		
		return freq;
	}
	public static void main(String args[]) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
		int n = Integer.parseInt(br.readLine());
		
		s = zigzagEncrypt(s,n);
		
		System.out.println("Encrypted Text => "+s);
		
		s = zigzagDecrypt(s,n);
		
		System.out.println("Decrypted Text => "+s);
	}	
}
