public class Problems {


    public static void main(String[] args) {

        // Non-runnable solutions, solve in leetcode

        //Q1. remove duplicates from the linked list
//        public ListNode deleteDuplicates(ListNode head) {
//            ListNode node = head;
//            while(node!=null && node.next!= null){
//                if(node.val==node.next.val){
//                    node.next = node.next.next;
//                }
//                else{
//                    node = node.next;
//                }
//            }
//            return head;
//        }




        // Q2. Merge two sorted lists
//        public ListNode mergeTwoLists(ListNode head1, ListNode head2) {
//            // create a dummy node and then add onto that.
//            // when returning, return tail.next as head;
//            ListNode dummyNode = new ListNode();
//            ListNode tail = dummyNode;
//
//            while(head1!= null && head2 != null){
//                if(head1.val<head2.val){
//                    tail.next = head1;
//                    head1 = head1.next;
//                    tail = tail.next;
//                }
//                else{
//                    tail.next = head2;
//                    head2= head2.next;
//                    tail = tail.next;
//                }
//            }
//
//            if(head1 == null){
//                while(head2 != null){
//                    tail.next = head2;
//                    head2 = head2.next;
//                    tail = tail.next;
//                }
//            }
//            else{
//                while(head1 != null){
//                    tail.next = head1;
//                    head1 = head1.next;
//                    tail = tail.next;
//                }
//            }
//
//
//            return dummyNode.next;
//
//        }

        // Q3 Detecting a cycle in a linked list
//        public boolean hasCycle(ListNode head) {
//        ListNode slow = head;
//        ListNode fast = head;
//
//        // //only one element
//        // if(head.next != null){
//        //     return false;
//        // }
//        // if(head.next == head){
//        //     return true;
//        // }
//
//        while(fast != null && fast.next != null){
//            fast  = fast.next.next;
//            slow = slow.next;
//            if(slow==fast){
//                return true;
//            }
//        }
//        return false;
//}
        // 4. Finding the length of the cycle if it exists
//        public static int lengthOfLoop(Node head) {
//            // Write your code here
//            Node slow = head;
//            Node fast = head;
//
//            while(fast != null && fast.next != null){
//                slow = slow.next;
//                fast = fast.next.next;
//                if(slow==fast){
//                    //keep the fast at this position and move slow
//                    int count = 0;
//                    do{
//                        slow = slow.next;
//                        count++;
//                    }while(slow!= fast);
//                    return count;
//                }
//            }
//            return 0;
//        }



    }




}
