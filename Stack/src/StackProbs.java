package Stack;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class StackProbs {
    public static void main(String[] args) {

        Stack<Integer> st = new Stack<>();

    }

    // Stack sorting using recursion
    private static void sortStack(){

    }
}

class StackImplement {
    // Queue using LL
    int size = 0;
    Node start = null;
    Node end = null;

    //push function
    void push(int x){
        Node temp = new Node(x);
        if(start==null && end == null){
            start = end = temp;
        }
        else{
            end.next = temp;
            end = temp;
        }
        size++;
    }
    int pop(){
        int val = start==null?-1:start.data;
        if(start == null){
            return val;
        }
        else{
            start = start.next;
        }
        if(start==null){
            end = null;
        }
        size--;
        return val;
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


// MinStack implementaiton - Approach 1 using extra space for minimum values
class MinStack {
    int size;
    Stack<int[]> st;

    public MinStack() {
        size = 0;
        st = new Stack<>();
    }
    
    public void push(int val) {
        if(st.isEmpty()){
            st.push(new int[]{val,val});
        }
        else{
            if(val<st.peek()[1]){
                st.push(new int[]{val, val});
            }
            else{
                st.push(new int[]{val,st.peek()[1]});
            }
        }
    }

    public int pop(){
        int[] ans = st.pop();
        return ans[0];
    }
    public int top(){
        return st.peek()[0];
    }  
    public int getMin(){
        return st.peek()[1];
    }
}

// Min stack implementation approach 2 using the mathematical formula trick
// checkout video sol

   