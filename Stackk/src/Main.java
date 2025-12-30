import java.util.*;//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(1); 
        st.push(2);
        st.push(3);
        st.push(4);
        st.push(5);

        int mid = 1 + st.size()/2 ; //3
        deleteMid(st,mid);
        System.out.println(st);
    }

    private static void deleteMid(Stack<Integer> st, int n){
        if(st.size()==n){
            st.pop();
            return;
        }
        int lastVal = st.pop();
        deleteMid(st, n);
        st.push(lastVal);

    }
}