/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if(root == null) return;
        
        TreeLinkNode next_row_ptr = null;
        TreeLinkNode temp = root.next;
        TreeLinkNode prev = null;
        
        while(root != null){
            next_row_ptr = root.left;
            prev = root.right;
            if(root.left != null && root.right != null){
                root.left.next = root.right;
            }else if(root.left != null){
                prev = root.left;
            }else if(root.right != null){
                next_row_ptr = root.right;
            }
            temp = root.next;            
            while(temp != null){
                if(next_row_ptr == null) next_row_ptr = temp.left;
                if(temp.left != null && temp.right != null){
                    if(prev != null) prev.next = temp.left;
                    temp.left.next = temp.right;   
                    prev = temp.right;
                }else if(temp.left != null){
                    if(prev != null) prev.next = temp.left;
                    prev = temp.left;                    
                }else if(temp.right != null){
                    if(prev != null) prev.next = temp.right;
                    prev = temp.right;
                    if(next_row_ptr == null) next_row_ptr = temp.right;
                }
                
                temp = temp.next;
            }            
            
            root = next_row_ptr;
        }
    } 
}
