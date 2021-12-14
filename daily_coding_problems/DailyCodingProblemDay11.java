import java.util.*;
public class DailyCodingProblemDay11 {
    public static void main(String args[]) {
      System.out.println(prefixSearch(new String[]{"dog", "deer", "deal"}, "de").toString());
    }
    
    private static List<String> prefixSearch(String[] set, String prefix){
        Map<String,Set<String>> map = new HashMap<>();
        for(String s : set){
            for(int i=0;i<s.length();++i){
                String sub = s.substring(0, i + 1);
                map.putIfAbsent(sub , new HashSet<>());
                map.get(sub).add(s);
            }
        } 
       
        List<String> ans = new ArrayList<>();
        Iterator it = map.getOrDefault(prefix, new HashSet<>()).iterator();
        while(it.hasNext()){
            ans.add((String)it.next());
        }
        return ans;
    }
}
