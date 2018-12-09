class Word{
    String s;
    int freq;
    Word(String s,int f){
        this.s = s;
        this.freq = f;
    }
}

public class HeapSort {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String,Word> map = new HashMap<String,Word>();
        int len = words.length;
        List<Word> ws = new ArrayList<Word>();
        List<String> res = new ArrayList<String>();
        
        for(int i=0;i<len;++i){
            if(map.containsKey(words[i])) map.get(words[i]).freq++;
            else{
                Word w = new Word(words[i],1);
                map.put(words[i],w);
                ws.add(w);
            }
        }
        
        int size = ws.size();
        buildHeap(ws,size);
        topKFrequentWords(ws,size,k,res);
        return res;
    }
    
    public void buildHeap(List<Word> ws,int size){
        int half = size/2;
        for(int i=half-1;i>=0;--i){
            heapify(ws,i,size);
        }
    }
    
    public void heapify(List<Word> ws,int index,int size){
        if(index*2+1 >= size) return;
        int max_index = maxIndex(ws,index,index*2+1,index*2+2 >= size ? index*2+1 : index*2+2,size);
        if(max_index == index) return;
        swap(ws,index,max_index);
        heapify(ws,max_index,size);
    }
    
    public void topKFrequentWords(List<Word> ws,int size,int k,List<String> res){
        for(int i=size-1;k>0;--k,i--){
            res.add(ws.get(0).s);
            swap(ws,0,i);
            heapify(ws,0,i);
        }
    }
    
    public int maxIndex(List<Word> ws,int p,int c1,int c2,int size){
        if(c2 >= size) c2 = size-1;
        Word pw = ws.get(p);
        Word cw1 = ws.get(c1);
        Word cw2 = ws.get(c2);
        
        if(isBigger(pw,cw1) && isBigger(pw,cw2)) return p;
        if(isBigger(cw1,pw) && isBigger(cw1,cw2)) return c1;
        return c2;
    }
    
    public boolean isBigger(Word w1,Word w2){
          if(w1.freq > w2.freq) return true;
          if(w2.freq > w1.freq) return false;
          return isSmallerWord(w1.s,w2.s);
    }
    
    public boolean isSmallerWord(String s1,String s2){
        int len1 = s1.length();
        int len2 = s2.length();
        
        for(int i=0;i<len1;++i){
            if(i >= len2) return false;
            if(s1.charAt(i) > s2.charAt(i)) return false;
            if(s2.charAt(i) > s1.charAt(i)) return true;
        }        
        
        return len1 <= len2;
    }
    
    
    public void swap(List<Word> ws,int index_1,int index_2){
        Word w = ws.get(index_1);
        ws.set(index_1,ws.get(index_2));
        ws.set(index_2,w);
    }
    
}
