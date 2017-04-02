class TrieNode {
    
    List<TrieNode> child_nodes;
    char data;
    boolean end_of_a_word = false;

    public TrieNode() {
        this.child_nodes = new ArrayList<TrieNode>();
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
    	root = new TrieNode();
    	root.data='~';
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        
        TrieNode node = this.root,prev = this.root,temp = null;
        int ptr = 0,len = word.length();

        for(int i=0;i<node.child_nodes.size();++i)
        {
        	temp = node.child_nodes.get(i);
        	if(temp.data == word.charAt(ptr))
        	{
        		ptr++;        		
        		
        		if(ptr == len)
        		{		
        		   	temp.end_of_a_word = true; 
        		  	return;
        		}

        		i = -1;  
        		node = temp;
        	}
        }
        
        prev = node;

        for(int i = ptr;i<len;++i)
        {
        	TrieNode newNode = new TrieNode();
        	
        	newNode.data = word.charAt(i);

        	prev.child_nodes.add(newNode);

        	prev = newNode;  

        	if(i+1 == len)
        		newNode.end_of_a_word = true;   	
        }
        
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {

        TrieNode node = this.root,temp = null;
        int ptr = 0,len = word.length();

        for(int i=0;i<node.child_nodes.size();++i)
        {
        	temp = node.child_nodes.get(i);
        	if(temp.data == word.charAt(ptr))
        	{

        		ptr++;

	        		if(ptr == len)
	        		{        			
	        		    return temp.end_of_a_word;
	        		}
        		i = -1;

        		node = temp;
        	}
        }

        return false;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode node = this.root,temp = null;
        int ptr = 0,len = prefix.length();

        for(int i=0;i<node.child_nodes.size();++i)
        {
        	temp = node.child_nodes.get(i);
        	if(temp.data == prefix.charAt(ptr))
        	{
        		ptr++;

        		if(ptr == len)
        			return true;
        			
        		i = -1;
        		node = temp;
        	}
        }

        return false;
    }
}
