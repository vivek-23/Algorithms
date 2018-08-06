/*
Given an array, the task is to divide it into two sets S1 and S2 such that the absolute difference between their sums is minimum.

Input:
The first line contains an integer 'T' denoting the total number of test cases. In each test cases, the first line contains an integer 'N' denoting the size of array. The second line contains N space-separated integers A1, A2, ..., AN denoting the elements of the array.


Output:
In each seperate line print minimum absolute difference.


Constraints:
1<=T<=30
1<=N<=50
1<=A[I]<=50


Example:
Input:
2
4
1 6 5 11
4
36 7 46 40

Output : 
1
23

Explaination :
Subset1 = {1, 5, 6}, sum of Subset1 = 12
Subset2 = {11},       sum of Subset2 = 11

*/
import java.util.*;
import java.lang.*;
import java.io.*;

class Ideone{
	public static void main (String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().trim().split("\\s");
		int[] arr = new int[s.length];
		for(int i=0;i<arr.length;++i) 
			arr[i] = Integer.parseInt(s[i]);
		System.out.println(computeSets(arr).toString());
	}
	
	private static List<List<Integer>> computeSets(int[] arr){
		Arrays.sort(arr);
		List<List<Integer>> result_set = new ArrayList<List<Integer>>();
		Map<Integer,Integer> map = new HashMap<>();
		
		int sum = 0;
		for(int i:arr){
			sum += i;
			map.put(i,map.getOrDefault(i,0) + 1);
		}
			
		
		int sum2 = sum;
		sum >>= 1;
		sum += (sum2&1);
		
		int[] dp = new int[sum2+1];
		
		List<List<Integer>> sets = new ArrayList<List<Integer>>();
		for(int i=0;i<sum2+1;i++) sets.add(new ArrayList<Integer>());
		
		dp[0] = 1;
		for(int i=0;i<arr.length;++i){
			for(int j=sum;j>=arr[i];--j){
				if(dp[j-arr[i]] == 1){
					if(dp[j] == 0){
						sets.get(j).addAll(sets.get(j-arr[i]));
						sets.get(j).add(arr[i]);
					}
					
					dp[j] = 1;
				}
			}
		}
		
		for(int i=sum;i>=1;--i){
			if(sets.get(i).size() > 0){
				List<Integer> first_set = sets.get(i);
				result_set.add(first_set);
				for(int j=first_set.size()-1;j>=0;--j)
					map.put(first_set.get(j),map.get(first_set.get(j)) - 1);
				
				break;
			}
		}
		
		List<Integer> another_set = new ArrayList<Integer>();
		for(Map.Entry<Integer,Integer> m:map.entrySet()){
			int key = m.getKey();
			int value = m.getValue();
			while(value-- > 0) another_set.add(key);
		}
		
		result_set.add(another_set);
		return result_set;
	}
}
