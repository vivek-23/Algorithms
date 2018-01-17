import java.util.*;

class BucketSort {
    
    public static void bucketSort(int[] a,int N){
        List<List<Integer>> buckets = new ArrayList<List<Integer>>();
        for(int i=0;i<=10;++i) buckets.add(new ArrayList<Integer>());
        
        for(int i=0;i<a.length;++i) buckets.get(Integer.bitCount(a[i])).add(a[i]); 
        
        int[][] bucket_states = new int[11][];
        
        for(int i=1;i<=10;++i){
            bucket_states[i] = insertionSort(buckets.get(i));
        }
        
        for(int i=1;i<=10;++i){
            for(int j=0;j<bucket_states[i].length;++j){
                System.out.print(bucket_states[i][j] + " ");
            }
            System.out.println();
        }
        
    }
    
    public static int[] insertionSort(List<Integer> data_set){
        int[] arr = new int[data_set.size()];
        for(int i=0;i<arr.length;++i) arr[i] = data_set.get(i);
        
        for(int i=0,j=0;i<arr.length;++i){
            int temp = arr[i];
            j = i-1;
            while(j >= 0 && arr[j] > temp){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = temp;
        }
        
        return arr;
    }
    
    
    public static void main(String args[] ){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] a = new int[N];
        for(int i=0;i<N;++i) a[i] = sc.nextInt();
        bucketSort(a,N);
    }
}
