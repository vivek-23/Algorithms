/*

Implement a least recently used cache with the following methods:

LRUCache(int capacity) constructs a new instance of a LRU cache with the given capacity.
get(int key) retrieves the value associated with the key key. If it does not exist, return -1. As a side effect, this key now becomes the most recently used key.
set(int key, int val) updates the key key with value val. If updating this key-value pair exceeds capacity, then evicts the least recently used key-value pair.
Each method should be done in \mathcal{O}(1)O(1) time.

Constraints

n ≤ 100,000 where n is the number of calls to get and set.
Example 1
Input
methods = ["constructor", "set", "get", "set", "set", "set", "get", "get"]
arguments = [[3], [1, 10], [1], [2, 20], [3, 30], [4, 40], [1], [4]]`
Output
[null, null, 10, null, null, null, -1, 40]
Explanation
We create an LRUCache of capacity 3.

Set key of 1 to value 10. Size of cache is now 1
We get 1 which has value of 10
Set key of 2 to value 20. Size of cache is now 2
Set key of 3 to value 30. Size of cache is now 3
Set key of 4 to value 40. Size exceeds capacity, so now we evict the least recently used key which is 1.
We get 1 which has been evicted so we return -1
We get 4 which has value of 40

*/
import java.util.*;

class Node{
    int key,val;
    Node prev,next;
    Node(int k,int val){
        key = k;
        this.val = val;
        prev = next = null;
    }
}

class LRUCache {
    int cap = 0;
    Map<Integer,Node> map;
    LinkedHashMap<Integer,Integer> lk;
    Node head = null,tail = null;
    public LRUCache(int capacity) {
        cap = capacity;
        map = new HashMap<>();
        lk = new LinkedHashMap<Integer,Integer>();
    }

    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        Node nn = map.get(key);
        int ans = nn.val;        
        if(head == null){
            head = tail = nn;
        }else{
            if(head.prev == null) tail = head;
            if(nn.prev != null) nn.prev.next = nn.next;
            head.next = nn;
            nn.prev = head;
            head = nn;
            nn.next = null;
        }       

        return ans;
    }

    public void set(int key, int val) {
        if(!map.containsKey(key)){
            if(cap == 0){
                if(tail == null){
                    Map.Entry<Integer,Integer> entry = lk.entrySet().iterator().next();
                    int k = (Integer)(entry.getKey());
                    lk.remove(k);
                    map.remove(k);
                }else{
                    map.remove(tail.key);
                    lk.remove(tail.key);
                    tail = tail.next;
                    if(tail == null) head = null;                    
                }                
            }else{
                cap--;
            }
            Node nn = new Node(key,val);
            map.put(key, nn);
            lk.put(key,-1);
        }else{
            lk.remove(key);
            map.get(key).val = val;
            lk.put(key,-1);
        }        
    }
}
