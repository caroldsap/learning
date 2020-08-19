package easy.linkedlist;

public class ReverseLinkedList {
    public static void main(String args[]){
    ListNode l1 = new ListNode((2));
    l1.next = new ListNode(4);
    l1.next.next= new ListNode(6);
    l1.next.next.next = new ListNode(8);
    l1.next.next.next.next = new ListNode(10);
    System.out.println(new ReverseLinkedList().reverse(l1));
    }
    public ListNode reverseList(ListNode head) {
        ListNode reversed=null;
        ListNode curr = head;
        while(curr!=null){
            ListNode nextTemp =curr.next;
           curr.next = reversed;
            reversed =curr;
            curr = nextTemp;

        }
        return reversed;
    }

    /**
     * Iteratice
     * @param head
     * @return
     */
    public ListNode reverseListMethod2(ListNode head){
        if (head == null || head.next ==null){
            return head;
        }
        ListNode todoNode = head.next;
        ListNode reversedList = head;
        reversedList.next = null;
        while (todoNode!=null){
            ListNode tempNode = todoNode;
            todoNode = todoNode.next;
            tempNode.next = reversedList;
            reversedList = tempNode;

        }
        return reversedList;
    }

    /**
     * Recursive
     * @param head
     * @return
     */
    public ListNode reverse(ListNode head){
        if (head == null || head.next == null) {
            return head;
        }

        ListNode reversedList = reverse(head.next);

        head.next.next = head;
        head.next = null;
        return reversedList;
    }

}
