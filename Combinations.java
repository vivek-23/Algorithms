class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        
        for(int i=1;i<=n-k+1;++i){
            List<Integer> t = new ArrayList<Integer>();
            t.add(i);
            combineHelper(t,res,i+1,k-1,n);
        }
        
        return res;
    }

    public void combineHelper(List<Integer> t,List<List<Integer>> res,int start,int k,int n){
    	if(k == 0){
    		res.add(t);
    		return;
    	}

    	for(int i=start;i<=n-k+1;++i){
            List<Integer> new_t = new ArrayList<Integer>(t);
    	    new_t.add(i);
    		combineHelper(new_t,res,i+1,k-1,n);
    	}
    }
}
