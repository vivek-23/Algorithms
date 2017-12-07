class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] wait = new int[temperatures.length];
        Stack<Integer> s = new Stack<Integer>();
        for(int i=temperatures.length-1;i>=0;--i){
            while(!s.isEmpty() && temperatures[i] >= temperatures[s.peek()]) s.pop();
            wait[i] = s.isEmpty() ? 0 : s.peek() - i;
            s.push(i);
        }
        return wait;
    }
}
