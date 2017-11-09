import java.util.*;
class HeapSort{
	public static void main(String[] a){
		Scanner sc = new Scanner(System.in);
		String[] s = sc.nextLine().split("\\s");
		int[] arr = new int[s.length+1];
		for(int i=1;i<arr.length;++i) arr[i] = Integer.parseInt(s[i-1]);
		new HeapSort().sort(arr);
		System.out.println();
		for(int i=1;i<arr.length;++i) System.out.print(arr[i] + " ");
		System.out.println();		
	}

	public void sort(int[] a){
		int half = (a.length-1)/2;	
		buildMaxHeap(a,half);		
		for(int i=1;i<a.length-1;++i){
			swap(a,1,a.length-i);
			heapify(a,1,a.length-i);
		}
	}

	public void buildMaxHeap(int[] a,int half){
		for(int i=half;i>=1;--i){
			heapify(a,i,a.length);
		}
	}

	public void heapify(int[] a,int index,int end){
		if(index*2 >= end) return;
		int max_ele = maxIndex(a,index,index*2,index*2+1 >= end ? index*2 : index*2+1);
		if(max_ele == index) return;
		swap(a,index,max_ele);
		heapify(a,max_ele,end);
	}

	public int maxIndex(int[] a,int p,int c1,int c2){
		if(a[p] >= a[c1] && a[p] >= a[c2]) return p;
		if(a[c1] >= a[p] && a[c1] >= a[c2]) return c1;
		return c2;
	}

	public void swap(int[] a,int x,int y){
		int t = a[x];
		 a[x] = a[y];
		 a[y] = t;
	}
}
