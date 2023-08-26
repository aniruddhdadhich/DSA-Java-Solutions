public class Problems {

    // compiling here is little complicated but understand the logic here.
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
//           tail.next = (head1 != null) ? head1 : head2;
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
//        // // if only one element exists in the linked list => two cases either it points to null or itself.
//        // if(head.next != null){   // single
//        //     return false;
//        // }
//        // if(head.next == head){    // circular
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
//                    //The moment you find the cycle then keep the fast at this position and move slow
                      // Slow will cover all of the points of circle.
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


//        Q.5. Finding the starting of the cycle in linked list
        // approach
// 1. Find if cycle exists
// 2. if yes then find the length,
//. 3. then start a pointer at head another one at cycle length ahead of the head.
// keep moving them one place at a time to meet at head.
//        public ListNode detectCycle(ListNode head) {
//            ListNode slow = head;
//            ListNode fast = head;
//            while(fast != null && fast.next != null){
//                slow = slow.next;
//                fast = fast.next.next;
//                if(slow==fast){
//                    // we have found a cycle
//                    // now get the length -> stop the fast and continue the slow
//                    int len = 0;
//                    do{
//                        slow = slow.next;
//                        len++;
//                    }while(slow!= fast);
//                    // now you have the len. start 2 pointers
//                    ListNode first = head;
//                    ListNode second = head;
//                    for(int i=1; i<=len; i++){
//                        second = second.next;
//                    }
//
//                    // now traverse equally until they reach the same point
//                    while(first != second){
//                        first  = first.next;
//                        second = second.next;
//                    }
//                    return first; // or second
//                }
//            }
//            return null;
//
//        }

        // Q.6a. Finding the middle of the linked list
//        public ListNode middleNode(ListNode head) {
//            ListNode slow = head;
//            ListNode fast = head;
//            while(fast != null  && fast.next != null){
//                slow = slow.next;
//                fast = fast.next.next;
//            }
//            return slow;
//        }

        //Q.6b. Finding the middle with different approach, which is used when you have to split list in the middle.
//        public static ListNode getMiddleNode(ListNode head) {
//            if (head == null || head.next == null) {
//                return head;
//            }
//            ListNode midPrev = null;
//            while (head != null && head.next != null) {
//                midPrev = (midPrev == null) ? head : midPrev.next;
//                head = head.next.next;
//            }
//            ListNode mid = midPrev.next;
//            midPrev.next = null;              // breaking at midpoint
//            return mid;
//        }
//

        // Q7 Reversing a linked list using iterative method
//        public ListNode reverseList(ListNode head) {
//            ListNode p = null;
//            ListNode c = head;
//            ListNode n;
//
//            while(c != null){
//                n = c.next;
//                c.next = p;
//                p = c;
//                c = n;
//            }
//
//            return p;
//
//        }

        // Q8 Reversing a linked list using recursive approach
//        public ListNode reverseList(ListNode head) {
//
//            // base case
//            if(head == null || head.next == null){
//                return head;
//            }
//            // implementation
//            ListNode newHead = reverseList(head.next);
//            head.next.next = head;
//            head.next = null;
//            return newHead;
//        }


        // Q9 Finding the palindrome in the linked list
        // approach -> find the middle point, reverse ahead of the mid and compare with two pointer
//        public boolean isPalindrome(ListNode head) {
//            // approach -> find the middle point, find the reverse linked List and compare till mid
//            if(head==null||head.next==null) return true;
//
//            ListNode slow = head;
//            ListNode fast = head;
//
//            while(fast.next!=null&&fast.next.next!=null) {
//                slow = slow.next;
//                fast = fast.next.next;
//            }
//
//            slow = reverseList(slow.next);
//
//            ListNode dummy = head;
//
//            while(slow!=null) {
//                if(dummy.val != slow.val) return false;
//                dummy = dummy.next;
//                slow = slow.next;
//            }
//            return true;
//        }


        // Q10. Happy Number? if the square sums equals to one.
//        public boolean isHappy(int n) {
//            if(n==1) return true;
//            int slow = n;
//            int fast = n;
//
//            do{
//                slow = squareSum(slow);
//                fast = squareSum(squareSum(fast));
//                if(slow==1 || fast == 1) return true;
//            }while(slow!=fast);
//            return false; // we reach here if cycle exists.
//        }
//
//        public int squareSum(int n){
//            int sum = 0;
//            while(n!=0){
//                int dig = n%10;
//                sum += dig*dig;
//                n = n/10;
//            }
//            return sum;
//        }


        // Q11. sort a linked list
        // approach => Merge sort => 1) find middle 2) split in two parts and sort them, 3) bring them back and merge them.
//        public ListNode sortList(ListNode head) {
//            // merge sort
//            // recursively divide the list and then merge
//
//            //base case
//            if(head==null || head.next == null){
//                return head;    // .next logic => if single node then it would be sorted by itself
//            }
//
//            //find the mid
//            ListNode mid = getMiddleNode(head);       // Q.6b
//            ListNode leftHalf = sortList(head);
//            ListNode rightHalf = sortList( mid);
//            return merge(leftHalf,rightHalf);          // Merging two sorted lists. Q.2.
//        }


    }




}
