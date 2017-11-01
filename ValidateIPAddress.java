class Solution {
    private final String IPv4 = "IPv4";
    private final String IPv6 = "IPv6";
    private final String NEITHER = "Neither";
    
    public String validIPAddress(String IP) {
        String[] possible_ipv4 = split(IP,'.');                
        if(possible_ipv4.length == 4) return validateIPv4Data(possible_ipv4);
        String[] possible_ipv6 = split(IP,':');
        if(possible_ipv6.length == 8) return validateIPv6Data(possible_ipv6);        
        return NEITHER;
    }
    
    public String[] split(String s,char delimiter){
        List<String> d = new ArrayList<String>();
        int last_ptr = 0;
        int len  = s.length();
        for(int i=0;i<len;++i){
            if(s.charAt(i) == delimiter){
                d.add(s.substring(last_ptr,i));
                last_ptr = i+1;
            }
        }
        if(last_ptr == len) d.add("");
        else d.add(s.substring(last_ptr,len));
        
        return d.toArray(new String[d.size()]);
    }
    
    public String validateIPv4Data(String[] ip){ 
        
        for(int i=0;i<ip.length;++i){
            if(!(ip[i].matches("\\d+") && ip[i].length() < 4)) return NEITHER;
            int num = Integer.parseInt(ip[i]);
            if(!(num%256 == num && String.valueOf(num).equals(ip[i]))) return NEITHER;
        }        
        return IPv4;
    }
    
    public String validateIPv6Data(String[] ip){     
        for(int i=0;i<ip.length;++i){
            if(ip[i].length() == 0 || ip[i].length() > 4) return NEITHER;
            int num = hexaToDecimal(ip[i]);
            if(num%65536 != num) return NEITHER;
        }        
        return IPv6;
    }
    
    public int hexaToDecimal(String s){
        int len = s.length();
        int dec = 0;
        int pow = 1;
        for(int i=len-1;i>=0;--i,pow*=16){            
            switch(s.charAt(i)){
                case 'a':case 'A': dec += pow*10;break;
                case 'b':case 'B': dec += pow*11;break;
                case 'c':case 'C': dec += pow*12;break;
                case 'd':case 'D': dec += pow*13;break;
                case 'e':case 'E': dec += pow*14;break;
                case 'f':case 'F': dec += pow*15;break;
                default: 
                if(s.charAt(i) >= '0' && s.charAt(i) <= '9') dec += pow*(s.charAt(i)-'0');    
                else return 65536;
            }
        }
        return dec;
    }
}
