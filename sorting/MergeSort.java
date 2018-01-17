import java.util.*;
class MergeSort {
    
    public static void mergeSort(int[] a,int low,int high){
        if(low == high) return;
        int mid = low + (high-low)/2;
        mergeSort(a,low,mid);
        mergeSort(a,mid+1,high);
        merge(a,low,mid,high);
    }
    
    public static void merge(int[] a,int low,int mid,int high){
        int ptr1 = low;
        int ptr2 = mid+1;
        int idx  = 0;
        
        int[] temp = new int[high-low+1];
        
        while(ptr1 < mid+1 || ptr2 < high+1){
            if(ptr1 == mid+1) temp[idx++] = a[ptr2++];
            else if(ptr2 == high + 1) temp[idx++] = a[ptr1++];
            else if(a[ptr1] > a[ptr2]){
                temp[idx++] = a[ptr2++];
            }else temp[idx++] = a[ptr1++];
        }
        
        for(int i=low,j=0;i<=high;++i,++j) a[i] = temp[j];
        
    }
    
    
    public static void main(String args[] ) {        
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] a = new int[N];
        for(int i=0;i<N;++i) a[i] = sc.nextInt();
        mergeSort(a,0,N-1);
    }
}
