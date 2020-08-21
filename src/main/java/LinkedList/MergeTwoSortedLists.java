package LinkedList;

public class MergeTwoSortedLists {
    public static void main(String args[]){
        ListNode l1 = new ListNode(1);
        ListNode l11= new ListNode(2);
        ListNode l12= new ListNode(4);
        l1.next = l11;
        l1.next.next= l12;
        ListNode l2 = new ListNode(1);
        ListNode l21= new ListNode(3);
        ListNode l22= new ListNode(4);
        l2.next = l21;
        l2.next.next= l22;
        ListNode result = mergeTwoLists(l1,l2);
        System.out.println(result);

    }
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = null;
        ListNode tailNode = null;
        ListNode tempNode = null;
        while(l1!=null && l2!=null){
            int val1 = l1!=null?l1.val:0;
            int val2 = l2!=null?l2.val:0;
            int val3 = 0;

            if(val1<=val2){
                val3 = val1;
                l1 = l1.next;
            } else {
                val3 = val2;
                l2 = l2.next;
            }
            tempNode = new ListNode(val3);

            if(result == null){
                result = tempNode;
            } else{

                tailNode.next = tempNode;

            }
            tailNode = tempNode;
        }

        ListNode l3 = l1!=null?l1:l2;
        while(l3!=null){
            tempNode = new ListNode(l3.val);
            tailNode.next = tempNode;
            tailNode  = tempNode;
            l3 = l3.next;
        }
        return result;

    }
}
