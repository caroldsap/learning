package easy.linkedlist;

import java.util.PriorityQueue;

public class MergeKSortedLinkedList {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(6);
        l1.next.next = new ListNode(8);

        ListNode l2 = new ListNode(3);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(7);

        ListNode l3 = new ListNode(1);
        l3.next = new ListNode(3);
        l3.next.next = new ListNode(4);

        ListNode result = MergeKSortedLinkedList.mergeKLists(new ListNode[]{l1, l2, l3});
        System.out.print("Here are the elements form the merged list: ");
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }

    static ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> minHeap = new PriorityQueue<ListNode>((n1, n2) -> n1.val - n2.val);
        // Initialize the variables we need to begin building the sorted list

        ListNode resultHead = new ListNode(0);
        ListNode resultTail = resultHead;


         /*
      Add the head of each linked list to the Priority Queue, the queue will
      move the node with the smallest value to the front.
        */

        for (ListNode root : lists) {
            if (root != null) {
                minHeap.add(root);
            }
        }

        /*
      Process each node in the queue while there are nodes to process across
      all k lists
         */


        while (!minHeap.isEmpty()) {
            ListNode smallestNode = minHeap.poll();

            // Append the node to the final list
            resultTail.next = smallestNode;

            // Advance the tail pointer to the node that we just added
            resultTail = smallestNode;

      /*
        Add the node that is after the node we just appended...to the priority
        queue for consideration (if it is not null)
      */
            if (smallestNode.next != null) {
                minHeap.add(smallestNode.next);
            }


        }

        return resultHead.next;
    }
}
