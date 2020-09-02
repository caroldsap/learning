package LinkedList;

import java.util.List;

public class SubListReversal {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l11 = new ListNode(2);
        ListNode l12 = new ListNode(3);

        ListNode l13 = new ListNode(4);
        ListNode l14 = new ListNode(5);
        ListNode l15 = new ListNode(6);
        ListNode l16 = new ListNode(7);
        ListNode l17 = new ListNode(8);
        l1.next = l11;
        l1.next.next = l12;
        l1.next.next.next=l13;
        l1.next.next.next.next = l14;
        l1.next.next.next.next.next =l15;
        l1.next.next.next.next.next.next=l16;
        l1.next.next.next.next.next.next.next=l17;
        // l1.next.next.next.next.next = l16;
        reverseBetween(l1,3,5);
    }
    public static ListNode reverseBetween(ListNode head, int start, int end) {
        if (start == end) {
            return head;
        }

        // Pad a dummy head to the start of the list
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        ListNode nodeBeforeReversedSublist = dummyHead;
        int pos = 1;
        while (pos < start) {
            nodeBeforeReversedSublist = nodeBeforeReversedSublist.next;
            pos++;
        }


        ListNode sublistWorkingPtr = nodeBeforeReversedSublist.next;
        while (start < end) {
            // 1.) Cut out of sublist
            ListNode nodeComingToSublistFront = sublistWorkingPtr.next;
            sublistWorkingPtr.next = nodeComingToSublistFront.next;

            // 2.) Wire into sublist head
            nodeComingToSublistFront.next = nodeBeforeReversedSublist.next;
            nodeBeforeReversedSublist.next = nodeComingToSublistFront;

            start++;
        }

        return dummyHead.next;
    }
    public static ListNode reverseBetweenMyApproach(ListNode head, int m, int n) {

        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;
        int i = 1;
        ListNode start = head;
        ListNode end = null;
        while(curr!=null){

            next = curr.next;

            if(i>=m && i<=n) {

                curr.next = prev;
                prev = curr;
                end = next;
                //prev.next = end;
                //curr = next;
            }
            if(i>=n){

            }
            curr = next;
            i++;
        }

      start.next = prev;
       // prev.next = end;
        return start;
    }

    public static ListNode subListReversal(ListNode l1){
        ListNode curr = l1;
        ListNode prev =null;
        ListNode next = null;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
