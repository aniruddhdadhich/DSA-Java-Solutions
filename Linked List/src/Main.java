public class Main {
    public static void main(String[] args) {
        LL list = new LL();

        list.insertAtFirst(5);
        list.insertAtFirst(6);
        list.insertAtFirst(9);
        list.insertAtFirst(10);
        list.insertAtFirst(12);
        list.insertAtFirst(19);
        list.insertAtFirst(60);
        list.insertAtFirst(40);
        list.insertAtLast(56);
        list.display();
        int id = list.getIndex(10);
        System.out.println(id);

    }
}

