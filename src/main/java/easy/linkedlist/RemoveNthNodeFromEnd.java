package easy.linkedlist;

public class RemoveNthNodeFromEnd {
    public static void main(String args[]){
        ListNode l1 = new ListNode((2));
        l1.next = new ListNode(4);
        l1.next.next= new ListNode(6);
        l1.next.next.next = new ListNode(8);
        l1.next.next.next.next = new ListNode(10);
        System.out.println(new RemoveNthNodeFromEnd().removeNthFromEnd(l1,2));
    }
    public static ListNode findNthFromLast(ListNode head, int n) {
        if (head == null || n < 1) {
            return null;
        }

        // We will use two pointers head and tail
        // where head and tail are 'n' nodes apart.
        ListNode tail = head;

        while (tail != null && n > 0) {
            tail = tail.next;
            --n;
        }

        // Check out-of-bounds
        if (n != 0) {
            return null;
        }

        // When tail pointer reaches the end of
        // list, head is pointing at nth node.
        ListNode tempNode = null;
        tempNode.next = head;
        while (tail != null) {
            tail = tail.next;
            head = head.next;
        }

        return head;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        ListNode right = dummyHead.next;
        while (n > 0) {
            right = right.next;
            n--;
        }

        ListNode left = dummyHead;
        while (right != null) {
            left = left.next;
            right = right.next;
        }

        left.next = left.next.next;

        return dummyHead.next;

    }

}
