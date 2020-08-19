package easy.linkedlist;

public class MergeTwoSortedLinkedLists {

    public static void main(String args[]){
        ListNode l1 = new ListNode((4));
        l1.next = new ListNode(8);
        l1.next.next= new ListNode(15);
        l1.next.next.next = new ListNode(19);
        l1.next.next.next.next = new ListNode(22);

        ListNode l2 = new ListNode((7));
        l2.next = new ListNode(9);
        l2.next.next= new ListNode(10);
        l2.next.next.next = new ListNode(16);

        mergeTwoLists(l1,l2);

    }
    public  static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

    ListNode mergedHead = null;

    if(l1.val<=l2.val){
        mergedHead = l1;
        l1 = l1.next;
    } else {
        mergedHead = l2;
        l2 = l2.next;
    }
        ListNode mergedTail = mergedHead;
    while(l1!=null || l2!=null){
       int first = l1!=null?l1.val:0;
       int second = l2!=null?l2.val:0;
       ListNode temp = null;
       if(first<=second){

           if(l1!=null) {
               temp = l1;
               l1 = l1.next;
           } else {
               temp =l2;
               l2  = l2.next;
           }
       } else {

           if(l2!=null) {
               temp  =l2;
               l2 = l2.next;
           } else {
               temp = l1;
               l1 = l1.next;
           }
       }
       mergedTail.next = temp;
       mergedTail = temp;
    }
        if (l1 != null) {
            mergedTail.next = l1;
        } else if (l2 != null) {
            mergedTail.next = l2;
        }
    return mergedHead;
    }
}
