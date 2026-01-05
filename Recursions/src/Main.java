import java.lang.reflect.Array;
import java.security.spec.RSAOtherPrimeInfo;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        int num = 12234;
        char[] arr = Integer.toString(num).toCharArray();
        System.out.println(arr.length);

    }


    // BASIC Problems

    // Q1. Print something N times
    public static void printNTimes(int N, String s) {
        //base
        if (N == 0) {
            return;
        }
        System.out.println(s);
        printNTimes(N - 1, s);
    }

    // Q2. Print from 1 to N;
    public static void oneToN(int N) {
        // base case
        if (N == 0) {
            return;
        }

        oneToN(N - 1);
        System.out.println(N);
    }

    //Q3. Print from N to 1;
    public static void NtoOne(int N) {
        // base
        if (N == 0) {
            return;
        }
        System.out.println(N);
        NtoOne(N - 1);
    }

    //Q4 sum of first N numbers  => Functional way
    public static int sumTillN(int N, int sum) {
        //base
        if (N == 0) {
            return 0;
        }
        return N + sumTillN(N - 1, sum);                    // logic => f(3) = 3 + f(2);...
    }

    //Q5 sum of first N numbers => Parameterized way
    public static void sumTillNPrint(int N, int sum) {
        //base
        if (N == 0) {
            System.out.println(sum);
            return;
        }
        sum = sum + N;
        sumTillNPrint(N - 1, sum);
    }

    // Q6 Reverse an array  // can also be done with one pointer, as shown in next question
    public static void reverseArr(int[] arr, int i, int j) {
        //base
        if (i > j) {
            System.out.println(Arrays.toString(arr));
            return;
        }
        //swap i and j values
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        // call next pointers
        reverseArr(arr, i + 1, j - 1);

    }

    //Q7 Check if string is palindrome
    public static boolean isPalindrome(String s, int i) {
        //base
        if (i > s.length() / 2) {
            return true;
        }

        if (s.charAt(i) == s.charAt(s.length() - i - 1)) {
            return isPalindrome(s, i + 1);
        }
        return false;
    }

    //Q8 Fibonacci -> example of multiple recursion calls
    public static int fibonacci(int n) {
        //base case
        if (n == 0 || n == 1) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    //Q9a print all the subseq of array
    public static void printSubseq(int[] arr, ArrayList<Integer> ans, int i) {
        if (i == arr.length) {
            System.out.println(ans);
            return;
        }

        // First choice - without taking it
        printSubseq(arr, ans, i + 1);

        // Second choice - with taking it
        if (i == 0 || (arr[i] != arr[i - 1])) {
            ans.add(arr[i]);
            printSubseq(arr, ans, i + 1);
            ans.remove(ans.size() - 1); // backtrack so that the value we added shouldn't be there when we go to previous func
        }

    }

    //Q9b Leetcode variant of the same question
    public static List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> output = new ArrayList<List<Integer>>();

        util(nums, new ArrayList<>(), 0, output);
        System.out.println(output);
        return output;

    }

    public static void util(int[] arr, List<Integer> ans, int i, List<List<Integer>> output) {
        if (i >= arr.length) {
            output.add(new ArrayList<>(ans));
            return;
        }
        //take
        ans.add(arr[i]);
        util(arr, ans, i + 1, output);
        ans.remove(ans.size() - 1);

        //don't take
        util(arr, ans, i + 1, output);
    }

    // Q10. Print all the subseq of an array if the sum of the subseq is target;
    public static void printSubseqWithKSum(int[] arr, ArrayList<Integer> ans, int i, int target, int sum) {
        //base
        if (i >= arr.length) {
            if (sum == target) {
                System.out.println(ans);
            }
            return;
        }
        //take
        ans.add(arr[i]);
        sum += arr[i];
        printSubseqWithKSum(arr, ans, i + 1, target, sum);

        //not take
        ans.remove(ans.size() - 1);
        sum -= arr[i];
        printSubseqWithKSum(arr, ans, i + 1, target, sum);
    }

    ///Q11. Print any subseq of an array if the sum of subseq is target
    public static boolean printAnySubseqWithKSum(int[] arr, ArrayList<Integer> ans, int i, int target, int sum) {
        //base
        if (i >= arr.length) {
            // if condition is satisfied then return true
            if (sum == target) {
                System.out.println(ans);
                return true;
            }
            return false;
        }
        //take

        ans.add(arr[i]);
        sum += arr[i];
        if (printAnySubseqWithKSum(arr, ans, i + 1, target, sum)) return true;

        //not take
        ans.remove(ans.size() - 1);
        sum -= arr[i];
        if (printAnySubseqWithKSum(arr, ans, i + 1, target, sum)) return true;

        return false;
    }

    //Q12. Print the count of subsequence with the given sum
    public static int countSubseqWithKSum(int[] arr, ArrayList<Integer> ans, int i, int target, int sum) {
        //base
        if (i >= arr.length) {
            // another base case to reduce complexity
            if (sum > target) {   // Assuming Array contains only positives
                return 0;   // no need to call next recursions because this will never add up to target.
            }
            // if condition is satisfied then return true
            if (sum == target) {
                return 1;
            }
            return 0;
        }
        //take

        ans.add(arr[i]);
        sum += arr[i];
        int l = countSubseqWithKSum(arr, ans, i + 1, target, sum);

        //not take
        ans.remove(ans.size() - 1);
        sum -= arr[i];
        int r = countSubseqWithKSum(arr, ans, i + 1, target, sum);

        return l + r;
    }

    //Q13. Merge Sort => check sorting folder
    //Q14. Quick Sort => check sorting folder

    //Q15. Combination sum - 1
    // Given an array of distinct integers and a target,
    // you have to return the list of all unique combinations where the chosen numbers sum to target. You may return the combinations in any order.
    //The same number may be chosen from the given array an unlimited number of times.
    // Two combinations are unique if the frequency of at least one of the chosen numbers is different.


    // leetcode variant
    public static List<List<Integer>> findCombo(int[] arr, int target) {
        List<List<Integer>> output = new ArrayList<List<Integer>>();
        combinationSumOne(0, arr, new ArrayList<>(), target, output);
        return output;
    }

    public static void combinationSumOne(int i, int[] arr, ArrayList<Integer> list, int target, List<List<Integer>> output) {
        //base
        if (i >= arr.length) {
            if (target == 0) {
                output.add(new ArrayList<>(list));
            }
            return;
        }
        if (arr[i] <= target) {
            //pick
            list.add(arr[i]);
            combinationSumOne(i, arr, list, target - arr[i], output);
            // removing the element
            list.remove(list.size() - 1);
        }
        //not pick
        combinationSumOne(i + 1, arr, list, target, output);
    }

    //Q16 tower of hanoi
    static void hanoi(int n, int source, int dest, int helper) {
        if (n == 1) {
            System.out.println("Moving disk " + n + " from tower " + source + " to " + dest);

            return;
        }
        hanoi(n - 1, source, helper, dest);
        System.out.println("Moving disk " + n + " from tower " + source + " to " + dest);
        hanoi(n - 1, helper, dest, source);
    }

    //Q17 Permutation with spaces
    static ArrayList<String> permutation(String s) {
        ArrayList<String> output = new ArrayList<>();
        String curr = "";
        curr = curr + s.charAt(0);
        helper(s, curr, 1, output);
        return output;
    }

    static void helper(String s, String current, int index, ArrayList<String> output) {
        // base case
        if (index == s.length()) {
            output.add(current.toString());
            return;
        }
//        int len = current.length();

        // not to put space
        char currChar = s.charAt(index);
        helper(s, current + currChar, index + 1, output);
//        current.setLength(len);


        // to put space
//        current.append("_" +s.charAt(index));
        helper(s, current + "_" + currChar, index + 1, output);
//        current.setLength(len);
    }

    //Q18 keypad mapping - given nokia phone string "24" what all combination can be there of msg.
    public static String[] keypad = {".", "abc", "def", "ghi", "jkl", "mno", "pqrs", "uv", "wxyz"};

    static void printKeypadCombination(String str, int i, String combination) {

        //base case
        if (i == str.length()) {
            System.out.println(combination);
            return;
        }

        //first button we pressed is let's say 2 - which is at str's current index
        char currChar = str.charAt(i);
        String characterAtButton = keypad[currChar - '0'];

        for (int j = 0; j < characterAtButton.length(); j++) {
            printKeypadCombination(str, i + 1, combination + characterAtButton.charAt(j));
        }
    }


    //Q19 all permutation of a string
    public static void allPermutation(String s, String output) {
        if (s.length() == 0) {
            System.out.println(output);
            return;
        }
        HashSet<Character> used = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            char currChar = s.charAt(i);

            if (used.contains(currChar)) continue;   // prune duplicate choice
            used.add(currChar);

            String remainingStr = s.substring(0, i) + s.substring(i + 1);
            allPermutation(remainingStr, output + currChar);
        }
    }

    public static void allPermutationBT(String s, int i) {
        s.charAt(i);
        for (int j = 1; j < s.length(); j++) {
            // swap ith and jth

        }
    }

    //Q20 all possible paths from 0,0 to n,m
    public static int totalPaths(int i, int j, int n, int m) {
        if (i == n || j == m) {
            return 0;
        }
        if (i == n - 1 && j == m - 1) {
            return 1;
        }
        int rightChoice = totalPaths(i + 1, j, n, m);
        int downChoice = totalPaths(i, j + 1, n, m);
        return rightChoice + downChoice;
    }

    //Q21 string's case change
    public static void caseChange(String s, int i, String output) {
        if (i == s.length()) {
            System.out.println(output);
            return;
        }
        caseChange(s, i + 1, output + Character.toUpperCase(s.charAt(i)));   // add the guy in caps
        caseChange(s, i + 1, output + s.charAt(i)); // add guy in non-caps
    }

    //Q22 Generate all balanced parentheses
    public static ArrayList<String> allbalanced(int n) {
        ArrayList<String> output = new ArrayList<>();
        helper(output, n, n, "");
        return output;
    }

    public static void helper(ArrayList<String> output, int open, int closed, String current) {
        if (open == 0 && closed == 0) {
            output.add(current);
            return;
        }

        if (open != 0) {
            helper(output, open - 1, closed, current + "(");
        }
        if (open < closed) {
            helper(output, open, closed - 1, current + ")");
        }
    }

    //Q23 Josephus problem - which position guy left in the end
    static int josephus(int n, int k) {
        ArrayList<Integer> positions = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            positions.add(i);
        }
        josephusUtil(n, k, 1, positions);
        return positions.getFirst();
    }

    static void josephusUtil(int n, int k, int i, ArrayList<Integer> positions) {
        if (n == 1) {
            return;
        }
        //remove the i+k-1 th guy
        int nextIndex = (i + k - 1) % n;
        positions.remove(nextIndex);
        josephusUtil(n - 1, k, nextIndex, positions);
    }

    static String max;

    static String largestNumInKSwaps(String num, int k) {
        max = num;
        char[] arr = num.toCharArray();
        solve(arr, k);
        return max;
    }

    static void solve(char[] arr, int k) {
        if (k == 0) return;

        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {

                if (arr[j] > arr[i]) {
                    swap(arr, i, j);

                    String curr = new String(arr);
                    if (curr.compareTo(max) > 0) {
                        max = curr;
                    }

                    solve(arr, k - 1);

                    swap(arr, i, j); // backtrack
                }
            }
        }
    }

    static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }




}






