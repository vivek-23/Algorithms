import java.util.*;
class SelectionSort {
    
    public static void selectionSort(int[] a,int N,int x){
        for(int i=0;i<N;++i){
            int min = i;
            for(int j=i+1;j<N;++j){
                if(a[j] < a[min]) min = j;
            }
            
            int temp = a[i];
            a[i] = a[min];
            a[min] = temp;
        }
    }
    
    public static void main(String args[] ) {        
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int x = sc.nextInt();
        int[] a = new int[N];
        for(int i=0;i<N;++i) a[i] = sc.nextInt();
        selectionSort(a,N,x);
        for(int i=0;i<N;++i) System.out.print(a[i] + " ");
    }
}
