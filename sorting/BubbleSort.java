import java.util.*;

class BubbleSort {
    
    public static int bubbleSort(int[] a,int N){
        int swaps = 0;
        
        for(int i=0;i<N;++i){
            for(int j=0;j<N-i-1;++j){
                if(a[j] < a[j+1]){
                    swaps++;
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
        }
        
        for(int i=0;i<N;++i) System.out.print(a[i] + " ");
        
        return swaps;
    }
    
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] a = new int[N];
        for(int i=0;i<N;++i) a[i] = sc.nextInt();
        System.out.println(bubbleSort(a,N));
    }
}
