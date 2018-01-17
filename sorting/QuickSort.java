import java.util.*;
class QuickSort {
	public static void quickSort(int[] a,int low,int high){
		if(low >= high) return;
		if(low + 1 == high){
		    if(a[low] > a[high]) swap(a,low,high);
		    return;
		}
		int pivot_index = low + (high-low)/2;
		int left = low,right = high-1;
		swap(a,pivot_index,high);
		
		while(left < right){
			while(left < high && a[left] < a[high]) left++;
			while(right > -1 && a[right] > a[high]) right--;
			if(left < right) swap(a,left,right);
		}

		pivot_index = left;

		swap(a,high,pivot_index);

		quickSort(a,low,pivot_index-1);
		quickSort(a,pivot_index+1,high);
	}

	public static void swap(int[] a,int x,int y){
		int temp = a[x];
		a[x] = a[y];
		a[y] = temp;
	}


    public static void main(String args[] ) {        
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] a = new int[N];
        for(int i=0;i<N;++i) a[i] = sc.nextInt();
        quickSort(a,0,N-1);
    	for(int i=0;i<N;++i) System.out.print(a[i] + " ");
    }
}
