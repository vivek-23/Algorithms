import java.util.*;
import static java.lang.System.out;

public class Sort2Darray
{
	public static void main (String[] args){
		Scanner sc = new Scanner(System.in);
		
		int[][] d = new int[sc.nextInt()][sc.nextInt()];
		for(int i=0;i<d.length;++i){
			for(int j=0;j<d[i].length;++j) d[i][j] = sc.nextInt();
		}
		
		Row[] row = new Row[d.length];
		for(int i=0;i<d.length;++i) row[i] = new Row(d[i]);
		
		Arrays.sort(row,new Comparator<Row>(){
			public int compare(Row e1,Row e2){
				int len = e1.arr.length;
				if(e1.arr[len-1] < e2.arr[len-1]) return -1;
				if(e1.arr[len-1] > e2.arr[len-1]) return 1;
				return 0;
			}
		});
		
		for(int i=0;i<d.length;++i)	d[i] = row[i].arr;
		
		for(int i=0;i<d.length;++i){
			for(int j=0;j<d[i].length;++j) out.print(d[i][j] + " ");
			out.println();
		}
	}
}

class Row{
	int[] arr;
	Row(int[] x){
		this.arr = x;
	}
}
