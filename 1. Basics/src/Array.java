import java.util.Arrays;

public class Array {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6,45,98,44,1};
        System.out.println(max(nums));

    }

    // Function that takes array and two indices, and then swaps the values of those two indices.
    public static int max(int[] arr) {
        int max = arr[0];
        for (int val : arr) {
            if (max < val) {
                max = val;
            }
        }
        return max;
    }
}
