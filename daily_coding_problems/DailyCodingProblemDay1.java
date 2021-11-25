// two sum problem
public class DailyCodingProblemDay1 {
    public boolean twoSum(int[] nums, int k){
        Set<Integer> set = new HashSet<>();
        for(int x : nums){
            if(set.contains(k - x)) return true;
            set.add(x);
        }
        
        return false;
    }
}
