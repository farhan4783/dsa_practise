
import java.util.PriorityQueue;

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;

        




        PriorityQueue<ListNode> heap = new PriorityQueue<>((a, b) -> a.val - b.val);

        


        for (ListNode node : lists) {

            if (node != null) {



                heap.offer(node);


            }
        }

      


        ListNode dummy = new ListNode(0);

        ListNode current = dummy;

       
        while (!heap.isEmpty()) {


            ListNode smallest = heap.poll();

            current.next = smallest;

            current = current.next;
            

            


            if (smallest.next != null) {


                heap.offer(smallest.next);

            }
        }

        return dummy.next;





    }
}
