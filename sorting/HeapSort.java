import java.util.*;
import static java.lang.System.out;
import java.io.*;

public class HeapSort{  
    public static void heapify(int[] a,int N){
        //out.println(Arrays.toString(a));
        // prepare your max heap
        for(int i=N/2-1;i>=0;--i){
            heapify(a,N,i);
        }
        out.println(Arrays.toString(a));
        // now heapify from last to first
        for(int i=N-1;i>0;--i){
            // swap first since we already have the highest at the top
            swap(i,0,a);
            heapify(a,i,0);// remember that the new upper limit/last index is i
        }                
        
        out.println(Arrays.toString(a));
        out.println(isSorted(a));
    }
    
    private static void heapify(int[] a,int n,int idx){
        int left = idx * 2 + 1;
        int right = idx * 2 + 2;
        int largest = idx;
        if(left < n && a[largest] < a[left]){
            largest = left;
        }
        
        if(right < n && a[largest] < a[right]){
            largest = right;
        }
        
        if(largest != idx){
            swap(largest,idx,a);
            heapify(a,n,largest); // heapify down to maintain max heap property.
        }
    }
    
    private static void swap(int x,int y,int[] a){
        int temp = a[x];
        a[x] = a[y];
        a[y] = temp;
    }
    
    private static boolean isSorted(int[] a){
        for(int i=1;i<a.length;++i){
            if(a[i] < a[i-1]) return false;
        }
        return true;
    }
    
    
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] a = new int[N];
        for(int i=0;i<N;++i) a[i] = sc.nextInt();
        heapify(a,N);
    }
}
