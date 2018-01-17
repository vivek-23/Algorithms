import java.util.*;
class RadixSort {
    public static void main(String args[] ) {        
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] a = new int[N];
        for(int i=0;i<N;++i) a[i] = sc.nextInt();
        radixSort(a,N);
        printState(a);
    }
    
    public static int maxPlace(int[] a){
        int max = a[0];
        for(int i=1;i<a.length;++i) max = Math.max(a[i],max);
        int place = 1;
        while(max != 0){
            max /= 10;
            place *= 10;
        }
        return place;
    }
    
    public static void radixSort(int[] a,int N){
        int place = 1;
        int max_place = maxPlace(a);
        do{
            
            List<List<Integer>> l = new ArrayList<List<Integer>>();
            for(int i=0;i<10;++i) l.add(new ArrayList<Integer>());
            
            for(int i=0;i<a.length;++i){
                int idx = a[i]/place % 10;
                l.get(idx).add(a[i]);
            }
            
            for(int i=0,ptr=0;i<10;++i){
                int size = l.get(i).size();
                for(int j=0;j<size;++j) a[ptr++] = l.get(i).get(j);
            }
            
            place *= 10;
        }while(max_place != place);
        
    }
    
    public static void printState(int[] a){
        for(int i=0;i<a.length;++i) System.out.print(a[i] + " ");
        System.out.print("\n");
    }
}
