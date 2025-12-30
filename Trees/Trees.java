
import java.util.*;

import javax.swing.tree.TreeNode;


public class Trees{

    public static void main(String[] args) {
        // Tree
//                      1
//                  2      3
//               4    5  6   7
//                  8     9   10



        //level 4 
        Node n9 = new Node(9);
        Node n10 = new Node(10);
        Node n8 =new Node(8);
        // Level 3 (leaf nodes)
        Node n4 = new Node(4);
        Node n5 = new Node(5,n8,null);
        Node n6 = new Node(6,null,n9);
        Node n7 = new Node(7,null,n10);

        // Level 2
        Node n2 = new Node(2, n4, n5);
        Node n3 = new Node(3, n6, n7);

        // Level 1 (root)
        Node root = new Node(1, n2, n3);


        


    }
    public static void preOrderTraversal(Node root){
        if(root==null) return;
        System.out.print(root.data+" ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }
    
    public static void inorder(Node root){
        if(root==null) return;
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }
    
    public static void postorder(Node root){
        if(root==null) return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data+" ");
    }

    public static ArrayList<ArrayList<Integer>> levelOrder(Node root){
    Queue<Node> q = new LinkedList<>();
    ArrayList<ArrayList<Integer>> finalList = new ArrayList<ArrayList<Integer>>();
    if (root == null) return finalList ;
    q.add(root); //init queue
    while (!q.isEmpty()) {
        int size = q.size();
        ArrayList<Integer> subList = new ArrayList<>();
        for(int i=0; i<size; i++){      
            if (q.peek().left != null) q.offer(q.peek().left);   
            if (q.peek().right != null) q.add(q.peek().right);  
            subList.add(q.poll().data);
        }  
        finalList.add(subList);   
    }
    return finalList;
    }

    public static List<Integer> preorderIterative(Node root) {
        List<Integer> ans = new ArrayList<>();
        if(root==null) return ans;
        Stack<Node> st = new Stack<>();
        st.add(root);
        while(!st.isEmpty()){
            int size = st.size();
            for(int i=0; i<size; i++){
                Node curr = st.pop();
                if(curr.right!=null) st.add(curr.right);
                if(curr.left!=null) st.add(curr.left);
                ans.add(curr.data);
            }
        }
        return ans;
    }

    public static List<Integer> postorderIterative(Node root) {
        List<Integer> ans = new ArrayList<>();
        if(root==null) return ans;
        Stack<Node> st = new Stack<>();
        st.add(root.left);
        while(!st.isEmpty()){
            int size = st.size();
            for(int i=0; i<size; i++){
                Node curr = st.pop();
                if(curr.right!=null) st.add(curr.right);
                if(curr.left!=null) st.add(curr.left);
                ans.add(curr.data);
            }
        }
        return ans;
    }

}

class Node{
    int data;
    Node left;
    Node right;

    Node(int val){
        data = val;
    }
    Node(int val, Node l, Node r){
        data = val;
        left = l;
        right = r;
    }


}