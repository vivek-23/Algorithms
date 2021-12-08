/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */

public class Solution {
    /**
     * @param root: the given tree
     * @return: the number of uni-value subtrees.
     */
    public int countUnivalSubtrees(TreeNode root) {
        int[] ans = new int[1];
        int[] mm = dfs(root, ans);
        if(mm.length > 0 && mm[0] == mm[1]) ans[0]++;
        return ans[0];
    }

    private int[] dfs(TreeNode root, int[] ans){
        if(root == null) return new int[0];
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int[] left  = dfs(root.left, ans);
        int[] right = dfs(root.right, ans);

        if(left.length == 0 && right.length == 0){
            return new int[]{root.val, root.val};
        }
        
        if(left.length > 0){
            min = Math.min(min, Math.min(left[0], left[1]));
            max = Math.max(max, Math.max(left[0], left[1]));
            if(left[0] == left[1]) ans[0]++;
        }

        if(right.length > 0){
            min = Math.min(min, Math.min(right[0], right[1]));
            max = Math.max(max, Math.max(right[0], right[1]));
            if(right[0] == right[1]) ans[0]++;
        }

        
        min = Math.min(min, root.val);
        max = Math.max(max, root.val);
        return new int[]{min, max};
    }
}
