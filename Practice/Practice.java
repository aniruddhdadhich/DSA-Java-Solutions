package Practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Practice {
    public static void main(String[] args) {
        Node fourth = new Node(5);
        Node third = new Node(4,fourth);
        Node second = new Node(3, third);
        Node first = new Node(2, second);
        fourth.next = second;
    }

    public static Node reverseLL(Node head){
      if(head == null || head.next == null){
        return head;
      }
      Node newHead = reverseLL(head.next);
      head.next.next = head;
      head.next =null;
      return newHead;
    }

    public static boolean checkCycle(Node head){
        Node slow = head;
        Node fast = head;
        while(fast!=null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow==fast){
                return true;
            }
        }
        return false;
    }

    public static int lengthOfCycle(Node head){
        HashMap<Node,Integer> visitedNodes = new HashMap<>();

        Node temp = head;
        int timer =0;

        while(temp!=null){
            if(visitedNodes.containsKey(temp)){
                int loopLen = timer - visitedNodes.get(temp);
                return loopLen;
            }
            visitedNodes.put(temp, timer);
            temp = temp.next;
            timer++;
        }
        return 0;
    }   
}

class Node{
    int data;
    Node next;


    Node(int data1){
        this.data = data1;

    }
    Node(int data1, Node nextNode ){
        this.data = data1;
        this.next = nextNode;
    }
}


