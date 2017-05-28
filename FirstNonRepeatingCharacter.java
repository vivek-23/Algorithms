import java.util.*;
class Node
{
	Node prev,next;
	char data;
	Node(char data)
	{
		this.prev = null;
		this.next = null;
		this.data = data;
	}
}

class DLL
{
	Node head,tail;
}

class RandomStuff
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		
		int T = Integer.parseInt(sc.nextLine());
		int N = 0;
		
		while(T-- > 0)
		{
			N = Integer.parseInt(sc.nextLine());
			String s[] = sc.nextLine().split("\\s+");
			char[] ch = new char[N];
			for(int i=0;i<N;++i) ch[i] = s[i].charAt(0);
			nonRepeatingChars(ch);
			System.out.println();
		}		
    }
	
	public static void nonRepeatingChars(char[] ch){
		DLL nodes = new DLL();
		int len = ch.length;
		Map<Character,Node> map = new HashMap<Character,Node>();
		
		for(int i=0;i<len;++i){
			if(nodes.head == null && !map.containsKey(ch[i])){
				nodes.head = new Node(ch[i]);
				nodes.tail = nodes.head;
				map.put(ch[i],nodes.head);
			}
			else if(map.containsKey(ch[i]) && map.get(ch[i]) != null){
				Node temp = map.get(ch[i]);
				if(temp == nodes.head){
					if(temp.next != null) temp.next.prev = null;
					nodes.head = temp.next;
				}
				else if(temp == nodes.tail){
					if(temp.prev != null) temp.prev.next = null;
					nodes.tail = temp.prev;
				}
				else{
					temp.prev.next = temp.next;
					temp.next.prev = temp.prev;
				}
				map.put(ch[i],null);	
			}
			else if(!map.containsKey(ch[i])){
				Node n = new Node(ch[i]);
				nodes.tail.next = n;
				n.prev = nodes.tail;
				nodes.tail = n;
				map.put(ch[i],nodes.tail);
			}
			
			if(nodes.head == null)
				System.out.print("-1" + " ");
			else
				System.out.print(nodes.head.data + " ");
		}
	}	
}
