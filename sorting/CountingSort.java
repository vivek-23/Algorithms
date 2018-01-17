import java.util.*;
class CountingSort {
    public static void main(String args[] ) {        
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] a = new int[N];
        for(int i=0;i<N;++i) a[i] = sc.nextInt();
        int[] cnt = new int[100];
        for(int i=0;i<N;++i) cnt[a[i]-1]++;
        for(int i=0;i<100;++i) if(cnt[i] > 0) System.out.println(i+1);
    }
}
