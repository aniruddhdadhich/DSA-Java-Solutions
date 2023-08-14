public class Main {
    public static void main(String[] args) {
            DLL dll = new DLL();

            dll.insertFirst(12);
            dll.insertFirst(13);
            dll.insertFirst(10);
            dll.display();
            dll.insertAt(25, 2);
            dll.display();

            int len = dll.getSize();
            System.out.println(len);
    }
}

