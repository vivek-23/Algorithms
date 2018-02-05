
class Node {
    int data;
    Node left;
    Node right;
 }
     
class CheckIfBST{
    boolean is_bst = true;   
    boolean checkBST(Node root) {
        if(root == null) return true;
        is_bst = true;        
        int[] left = {root.data - 1,root.data - 1};
        int[] right = {root.data + 1,root.data + 1};
        if(root.left != null) left = checkBSTHelper(root.left);
        if(root.right != null) right = checkBSTHelper(root.right);              
        return is_bst && left[0] < root.data && left[1] < root.data && root.data < right[0] && root.data < right[1];
    }

    int[] checkBSTHelper(Node root){
        if(root.left == null && root.right == null) return new int[]{root.data,root.data};
        
        int[] left = {root.data,root.data};
        int[] right = {root.data,root.data};
        
        if(root.left != null){
            left   = checkBSTHelper(root.left);
            is_bst = is_bst && left[0] < root.data && left[1] < root.data; 
        }
        
        if(root.right != null){
            right = checkBSTHelper(root.right);
            is_bst = is_bst && root.data < right[0] && root.data < right[1];
        }
        
        return new int[]{
            Math.min(root.data,Math.min(Math.min(right[0],right[1]),Math.min(left[0],left[1]))),
            Math.max(root.data,Math.max(Math.max(right[0],right[1]),Math.max(left[0],left[1])))
        };
    }


}
