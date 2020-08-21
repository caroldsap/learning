package LinkedList;

public class ReverseLinkedList {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l11 = new ListNode(2);
        ListNode l12 = new ListNode(3);

        ListNode l13 = new ListNode(4);
        ListNode l14 = new ListNode(5);
        ListNode l15 = new ListNode(6);
        l1.next = l11;
        l1.next.next = l12;
        l1.next.next=l13;
        l1.next.next.next = l14;
        l1.next.next.next.next =l15;
       // l1.next.next.next.next.next = l16;
        reverseList(l1);
    }

    public static ListNode reverseList(ListNode head) {
        if (head == null) return null;
        ListNode curr = head;
        ListNode prev = null;
        ListNode next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
