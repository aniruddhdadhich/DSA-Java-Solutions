public class DLL {

    private Node head;
    private Node tail;
    private int size;

    DLL(){
        this.size = 0;
    }

    // display size
    public int getSize(){
        return size;
    }

    // display the doubly linked list
    public void display(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.value+"<===>");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    // insert at first position
    public void insertFirst(int val){
        // make a new node
        Node node = new Node(val);
        //what if there is no head, meaning head = null;
        if(head==null){
            head = node;
            size++;
            return;
        }

        node.next = head;
        head.prev = node;
        node.prev = null;
        head = node;
        size++;
    }

    // insert at index- rough implementation
    public void insertAt(int val , int pos){
        //base conditions
        if(pos==0 || head==null){
            insertFirst(val);
            return;
        }
        // main implementation
        Node temp = head;
        for(int i = 1; i<pos; i++){
            temp = temp.next;
        }
        Node node = new Node(val);
        node.next = temp.next;
        temp.next.prev = node;
        temp.next =  node;
        node.prev = temp;

        size++;
    }



    private class Node{
        private int value;
        private Node next;
        private Node prev;

        public Node(int value){
            this.value = value;
        }
    }
}
