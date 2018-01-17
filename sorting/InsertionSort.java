import java.util.*;
class InsertionSort {
    public static void insertionSort(int[] x,int N){        
        for(int i=1,j=0;i<N;++i){
            int temp = x[i];
            j = i-1;
            while(j >= 0 && temp < x[j]){
                x[j+1] = x[j];
                j--;
            }
            x[j+1] = temp;
        }
    }
    
    public static void main(String args[] ) {        
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] a = new int[N];
        for(int i=0;i<N;++i) a[i] = sc.nextInt();
        insertionSort(a,N);
    }
}
