public class DailyCodingProblemDay3 {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "#";
        String left  = serialize(root.left);
        String right = serialize(root.right);
        return "[" + Integer.toString(root.val) + "," + left + "," + right + "]"; 
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        int val = 0;
        TreeNode curr = null;
        boolean neg = false;
        int l = -1,r = -1;
        
        for(int i=1;i<data.length() - 1;++i){
            if(data.charAt(i) == '-'){
                neg = true;
            }else if(data.charAt(i) >= '0' && data.charAt(i) <= '9'){
                val = val * 10 + (data.charAt(i) - '0');
                if(data.charAt(i + 1) == ','){
                    if(neg) curr = new TreeNode(-1 * val);
                    else curr = new TreeNode(val);
                    l = i + 2;
                    int o = 0;
                    for(int j = i + 2; j < data.length() - 1; ++j){                        
                        if(data.charAt(j) == ',' && o == 0){
                            r = j;
                            break;
                        }else if(data.charAt(j) == '[') o++;
                        else if(data.charAt(j) == ']') o--;
                    }                        
                
                    break;
                }
            }
        }
        if(curr == null) return null;
        
        curr.left  = deserialize(data.substring(l, r));
        curr.right = deserialize(data.substring(r + 1, data.length() -1));        
        return curr;
    }
}
