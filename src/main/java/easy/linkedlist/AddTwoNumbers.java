package easy.linkedlist;

public class AddTwoNumbers {
    public static void main (String args[]) {
        ListNode l1 = new ListNode((2));
        l1.next = new ListNode(4);
        l1.next.next= new ListNode(3);

        ListNode l2 = new ListNode((5));
        l2.next = new ListNode(6);
        l2.next.next= new ListNode(4);
        add(l1,l2);
    }
    static ListNode add(ListNode l1, ListNode l2 ){
        ListNode result = null;
       ListNode temp = null;
        int carry = 0;
        while(l1!=null || l2!=null || carry>0){
            int sum = (l1!=null?l1.val:0) + (l2!=null?l2.val:0) + carry;
            ListNode currNode = new ListNode(sum%10);
            carry = sum /10;
            if(result == null){
                result = currNode;
            } else {
                temp.next = currNode;
            }
            temp = currNode;
            if(l1!=null) l1 = l1.next;
            if(l2!=null) l2= l2.next;

        }
        return result;
    }
}
