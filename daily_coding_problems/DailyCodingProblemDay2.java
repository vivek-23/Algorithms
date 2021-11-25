/*

This problem was asked by Uber.

Given an array of integers, return a new array such that each element at index i of the new array is the product of all the numbers in the original array except the one at i.

For example, if our input was [1, 2, 3, 4, 5], the expected output would be [120, 60, 40, 30, 24]. If our input was [3, 2, 1], the expected output would be [2, 3, 6].

Follow-up: what if you can't use division?

*/

import java.util.*;
public class DailyCodingProblemDay2 {
    public static void main(String args[]) {
       System.out.println(Arrays.toString(new DailyCodingProblem().solve(new int[]{1, 2, 3, 4, 5})));
    }
    
    private int[] solve(int[] nums){
        int[] left = new int[nums.length];
        for(int i=0,m = 1;i<nums.length;++i){
            left[i] = m * nums[i];
            m = left[i];
        }
        
        int[] ans = new int[nums.length];
        
        for(int i=nums.length-1, m = 1;i>=0;--i){
            ans[i] = (i - 1 >= 0 ? left[i - 1] : 1) * m;
            m *= nums[i];
        }
        
        return ans;
    }
}
