import java.util.*;
public class TowerOfHanoi
{		    
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       int n = Integer.parseInt(sc.nextLine());
       solveTowerOfHanoi(n,"A","B","C");
    }
    
    private static void solveTowerOfHanoi(int n,String from,String aux,String to){
    	if(n == 1){
    		System.out.println("Move " + n + " from " + from + " to " + to);
    		return;
    	}
    	
    	solveTowerOfHanoi(n-1,from,to,aux);
    	System.out.println("Move " + n + " from " + from + " to " + to);
    	solveTowerOfHanoi(n-1,aux,from,to);
    }
}
