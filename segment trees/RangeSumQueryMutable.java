class Node{
    int start,end;
    int data;
    Node left,right;
    Node(int s,int e,int d){
        start = s;
        end = e;
        data = d;
    }
}
public class NumArray {
    Node root;
    public NumArray(int[] nums) {
        root = nums == null || nums.length == 0 ? null : buildTree(nums,0,nums.length-1);        
    }
    
    public void update(int i, int val) {
        updateTree(root,i,val);
    }
    
    public int sumRange(int i, int j) {
        return rangeSum(root,i,j);
    }
    
    private Node buildTree(int[] arr,int s,int e){
        if(s == e) return new Node(s,e,arr[s]);
        Node root = new Node(s,e,0);
        int mid = (s + e) / 2;
        root.left  = buildTree(arr,s,mid);
        root.right = buildTree(arr,mid+1,e);
        root.data = root.left.data + root.right.data;
        return root;
    }
    
    private Node updateTree(Node root,int index,int new_val){
        if(root.left == null && root.right == null){
            root.data = new_val;
            return root;
        }
        if(inRange(index,root.left.start,root.left.end)){
            updateTree(root.left,index,new_val);
        }else{
            updateTree(root.right,index,new_val);
        }
        root.data = root.left.data + root.right.data;
        return root;
    }
    
    private int rangeSum(Node root,int s,int e){
        if(root.start == s && root.end == e) return root.data;
        if(inRangeComplete(root.left.start,root.left.end,s,e)){
            return rangeSum(root.left,s,e);
        }else if(inRangeComplete(root.right.start,root.right.end,s,e)){
            return rangeSum(root.right,s,e);
        }        
        return rangeSum(root.left,s,root.left.end) + rangeSum(root.right,root.right.start,e);
    }
    
    private boolean inRangeComplete(int start,int end,int s,int e){
        return s >= start && e <= end;
    }
    
    private boolean inRange(int index,int start,int end){
        return start <= index && index <= end;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */
