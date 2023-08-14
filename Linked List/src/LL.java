public class LL {

    private Node head;
    private Node tail;

    private int size;

    // constructor
    public LL(){
        this.size = 0;
    }
    //display the size
    public void displaySize(){
        System.out.println(size);
    }

    // insert at first position
    public void insertAtFirst(int val){
        Node node = new Node(val);
        node.next = head;
        head = node;

        if(tail==null){  // only one node in LL.
            tail = head;
        }

        size++; // increase the size by 1 of the linkedlist
    }
    // insert at last position
    public void insertAtLast(int val){
        Node node = new Node(val);
        if(tail==null){  // there is no node
            insertAtFirst(val);
            return;
        }
        tail.next = node;
        tail = node; // tail has been updated to the last node
        size++;
    }

    // insert in the middle
    public void insertAt(int val, int pos){
        //base conditions
        if(pos==0){
            insertAtFirst(val);
            return;
        }
        if(pos==size){
            insertAtLast(val);
            return;
        }
        if(pos > size){
            throw new Error("Index out of bounds");
        }

        // main implementation

        Node temp = head;
        for(int i = 1; i<pos; i++){
            temp = temp.next;
        }
        Node node = new Node(val, temp.next);
        temp.next =  node;
        size++;
    }

    // display the LL
    public void display(){
        Node temp  = head;
        while(temp!=null){
            System.out.print(temp.value+"-->");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    // get the node at index
    public Node get(int index){
        Node temp = head;
        for(int i=1; i<=index; i++){
            temp = temp.next;
        }
        return temp;
    }


    // delete the first node
    public int deleteFirst(){
        int val = head.value;
        head = head.next;
        if(head==null) {
            tail = null; // if head now points to null means we had only one node,
        }                   // so tail should also be removed from there.
        size--;
        return val;
    }
    //delete last item
    public int deleteLast(){
        if(size==1){
            return deleteFirst();
        }
        int val = tail.value;
        Node secondLast = get(size-2);
        tail = secondLast;
        tail.next = null;
        return val;
    }

    // Delete at any index
    public int deleteAt(int index){
        if(index==0){
            int val = deleteFirst();
            return val;
        }
        if(index==size-1){
            int val = deleteLast();
            return val;
        }

        // main implementation  // how do you access=> prev, deletable(prev.next), next(prev.next.next)
        Node prev = get(index-1);
        int val = prev.next.value;
        prev.next = prev.next.next;
        return val;
    }

    // Find the index if given a value // if there is no value then return -1;
    public Node find(int val){
        Node temp = head;
        while(temp!=null){
            if(temp.value == val){
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }





    private class Node{
        private int value;
        private Node next;

        public Node(int value){
            this.value = value;
        }
        public Node(int value, Node next){
            this.value = value;
            this.next = next;
        }
    }
}


