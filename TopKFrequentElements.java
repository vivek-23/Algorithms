class Element{
    int num,freq;
    Element(int num,int freq){
    	this.num = num;
    	this.freq = freq;
    }
}
public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
    	List<Integer> k_freq = new ArrayList<Integer>();
    	Map<Integer,Element> m = new HashMap<Integer,Element>();
        List<Element> e = new ArrayList<Element>();
        for(int i=0;i<nums.length;++i){
        	if(m.containsKey(nums[i])){
        		m.get(nums[i]).freq++;
        	}else{
        		Element t = new Element(nums[i],1);
        		m.put(nums[i],t);
        		e.add(t);
        	}
        }

        int size = e.size();
        buildMaxHeap(e,size);
		heapifyFrequent(e,k_freq,size,k);        
        return k_freq;
    }

    public void heapifyFrequent(List<Element> l,List<Integer> kf,int size,int k){
    	for(int i=size-1;k>0;i--,k--){
    		kf.add(l.get(0).num);
    		swap(l,0,i);
    		heapify(l,0,i);
    	}
    }

    public void buildMaxHeap(List<Element> l,int size){
    	int half = size/2-1;
    	for(int i=half;i>=0;--i){
    		heapify(l,i,size);
    	}
    }

    public void heapify(List<Element> l,int index,int size){
    	if(index*2+1 >= size) return;
    	int max_index = maxIndex(l,index,index*2+1,index*2+2 >= size ? index*2+1 : index*2+2);
    	if(max_index == index) return;
    	swap(l,max_index,index);
    	heapify(l,max_index,size);
    }

    public int maxIndex(List<Element> l,int p,int c1,int c2){
    	int a = l.get(p).freq;
    	int b = l.get(c1).freq;
    	int c = l.get(c2).freq;
    	
    	if(a >=b && a>=c ) return p;
    	if(b >= a && b >= c) return c1;
    	return c2;
    }

    public void swap(List<Element> l,int index_1,int index_2){
    	Element e = l.get(index_1);
    	l.set(index_1,l.get(index_2));
    	l.set(index_2,e);
    }
}
