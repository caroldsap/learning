package LinkedList;

import java.util.List;

public class AddTwoNumbers {

    public static void main(String args[]){
        ListNode l1 = new ListNode(2);
        ListNode l11= new ListNode(4);
        ListNode l12= new ListNode(7);
        l1.next = l11;
        l1.next.next= l12;
        ListNode l2 = new ListNode(5);
        ListNode l21= new ListNode(6);
        ListNode l22= new ListNode(4);
        l2.next = l21;
        l2.next.next= l22;
        ListNode result = addTwoNumbers(l1,l2);
        System.out.println(result);

    }
    public  static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int sum =0;
        int carry =0;
        ListNode resultNode = null;
        ListNode tail = null;
        while(l1!=null && l2!=null){
            int val1 = l1!=null?l1.val:0;
            int val2 = l2!=null?l2.val:0;
            sum = carry + val1+ val2;
            carry = sum /10;
            sum = sum %10;
            ListNode tempNode = new ListNode(sum);
            if(resultNode ==null ){
                resultNode = tempNode;
            } else{
                // tail.next = tempNode;
                tail.next = tempNode;
                //resultNode = tempNode;
            }
            tail = tempNode;

            if(l1!=null) l1 = l1.next;
            if(l2!=null) l2 = l2.next;
        }

        if(carry>0){
            ListNode tempNode = new ListNode(carry);
            tail.next = tempNode;
            tail = tempNode;
        }

        return resultNode;
    }
}
