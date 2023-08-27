import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Recursion {
    public static void main(String[] args) {
//        printNTimes(5,"Jai Shree Krishna");
//        oneToN(5);
//        NtoOne(5);
//        System.out.println(sumTillN(3,0));
//        sumTillNPrint(100,0);

//        int[] arr = {10,24,65,14,23,87,98,45};
//        reverseArr(arr,0,arr.length-1);

//        String str = "MADAM";
//        boolean flag = isPalindrome(str,0);
//        System.out.println(flag);

//        System.out.println(fibonacci(8));
        int[] arr= {3,1,2};
        ArrayList<Integer> ans = new ArrayList<Integer>();
        subsets(arr);


    }

    // BASIC Problems

    // Q1. Print something N times
    public static void printNTimes(int N, String s){
        //base
        if(N==0){
            return;
        }
        System.out.println(s);
        printNTimes(N-1,s);
    }

    // Q2. Print from 1 to N;
    public static void oneToN(int N){
        // base case
        if(N==0){
            return;
        }

        oneToN(N-1);
        System.out.println(N);
    }

    //Q3. Print from N to 1;
    public static void NtoOne(int N){
        // base
        if(N==0){
            return;
        }
        System.out.println(N);
        NtoOne(N-1);
    }

    //Q4 sum of first N numbers  => Functional way
    public static int sumTillN(int N,int sum){
        //base
        if(N==0){
            return 0;
        }
        return N + sumTillN(N-1, sum);                    // logic => f(3) = 3 + f(2);...
    }

    //Q5 sum of first N numbers => Parameterized way
    public static void sumTillNPrint(int N, int sum){
        //base
        if(N==0){
            System.out.println(sum);
            return;
        }
        sum = sum + N;
        sumTillNPrint(N-1,sum);
    }

    // Q6 Reverse an array  // can also be done with one pointer, as shown in next question
    public static void reverseArr(int[] arr, int i, int j){
        //base
        if(i>j){
            System.out.println(Arrays.toString(arr));
            return;
        }
        //swap i and j values
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        // call next pointers
        reverseArr(arr, i+1, j-1);

    }

    //Q7 Check if string is palindrome
    public static boolean isPalindrome(String s, int i){
        //base
        if(i>s.length()/2){
            return true;
        }

        if(s.charAt(i) == s.charAt(s.length()-i-1)){
            return isPalindrome(s,i+1);
        }
        return false;
    }

    //Q8 Fibonacci -> example of multiple recursion calls
    public static int fibonacci(int n){
        //base case
        if(n==0 || n==1){
            return n;
        }
        return fibonacci(n-1) + fibonacci(n-2);
    }

    //Q9a print all the subseq of array
    public static void printSubseq(int[] arr, ArrayList<Integer> ans, int i){
        if(i>=arr.length){
            System.out.println(ans);
            return;
        }
        ans.add(arr[i]);
        printSubseq(arr, ans, i+1);

        ans.remove(ans.size()-1);
        printSubseq(arr,ans,i+1);
    }

    //Q9b Leetcode variant of the same question
    public static List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> output = new ArrayList<List<Integer>>();

        util(nums,new ArrayList<>(),0,output);
        System.out.println(output);
        return output;

    }

    public static void util(int[] arr, List<Integer> ans, int i,List<List<Integer>> output ){
        if(i>=arr.length){
            output.add(new ArrayList<>(ans));
            return;
        }
        //take
        ans.add(arr[i]);
        util(arr, ans, i+1,output);

        //don't take
        ans.remove(ans.size()-1);
        util(arr,ans,i+1,output);
    }
}



