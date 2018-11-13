public class SieveOfEratosthenes{      
    public static void main(String args[]){
        boolean[] sieve1 = new boolean[1000001];
        boolean[] sieve2 = new boolean[1000001];
        boolean[] sieve3 = new boolean[1000001];
        naive(sieve1);
        moderatelyEfficient(sieve2);
        efficient(sieve3);
    }
       
    public static void naive(boolean[] sieve){
        for(int i=2;i<sieve.length;++i){
            if(sieve[i]) continue;
            for(int j=i+i;j<sieve.length;j+=i){
                sieve[j] = true;
            }
        }
    }
    
    public static void moderatelyEfficient(boolean[] sieve){
        for(long i=2;i<sieve.length;++i){
            if(sieve[(int)i]) continue;
            for(long j=i*i;j<sieve.length;j+=i){
                sieve[(int)j] = true;
            }
        }
    }
    
    public static void efficient(boolean[] sieve){
        for(int i=2;i*i<sieve.length;++i){
            if(sieve[i]) continue;
            for(int j=i*i;j<sieve.length && j > 0;j+=i){
                sieve[j] = true;
            }
        }
    }
}
