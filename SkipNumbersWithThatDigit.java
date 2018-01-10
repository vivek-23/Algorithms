import java.util.*;
class SkipNumbersWithThatDigit{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);		
		List<Integer> list = new ArrayList<Integer>();
		dfs(sc.nextInt(),sc.nextInt(),0,list);
		Collections.sort(list); // optional if you want numbers in sorted order
		int size = list.size();
		for(int i=0;i<size;++i) System.out.println(list.get(i));
	}

	public static void dfs(int n,int ignore_digit,int start,List<Integer> list){
		if(start > n) return;
		int end = start + 9;
		for(int i=start;i<=end && i <= n;++i){
			if(i-start != ignore_digit){
				list.add(i);
				if(i > 0) dfs(n,ignore_digit,i*10,list);
			}
		}
	}
}
