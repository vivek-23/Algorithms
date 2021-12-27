class DailyCodingProblemDay26 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow = head,fast = head, prev = null;
        for(int i=1; i <= n ; ++i) fast = fast.next;
        
        while(fast != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next;
        }
        
        if(prev == null) return head.next;        
        prev.next = prev.next.next;
        return head;
    }
}
