import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int[] ar = {4,3,7,1,2};
        int ans = avgWaitTimeSAF(ar);
        System.out.println(ans);
    }

    // Q4 Shortest Algo First - Average waiting time
    static int avgWaitTimeSAF(int[] arr){
        Arrays.sort(arr);
        int totalWaitTime = 0;
        int currentWaitTime=0;
        for(int i=1; i<arr.length;i++){
            currentWaitTime += arr[i-1];
            totalWaitTime += currentWaitTime;
        }

        return totalWaitTime/arr.length;
    }
}