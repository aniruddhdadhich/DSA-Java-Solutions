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
//        int[] arr= {1,2,1};
//        ArrayList<Integer> ans = new ArrayList<Integer>();
//        int ct = countSubseqWithKSum(arr,ans,0,2,0);
//        System.out.println(ct);

        int[] arr = {2,3,6,7};
        List<List<Integer>> ans = findCombo(arr, 7);
        System.out.println(ans);

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

    // Q10. Print all the subseq of an array if the sum of the subseq is target;
    public static void printSubseqWithKSum(int[] arr, ArrayList<Integer> ans, int i, int target, int sum){
        //base
        if(i>=arr.length){
            if(sum==target){
                System.out.println(ans);
            }
            return;
        }
        //take
        ans.add(arr[i]);
        sum += arr[i];
        printSubseqWithKSum(arr, ans, i+1, target, sum);

        //not take
        ans.remove(ans.size()-1);
        sum-=arr[i];
        printSubseqWithKSum(arr, ans,i+1, target, sum);
    }

    ///Q11. Print any subseq of an array if the sum of subseq is target
    public static boolean printAnySubseqWithKSum(int[] arr, ArrayList<Integer> ans, int i, int target ,int sum){
        //base
        if(i>=arr.length){
            // if condition is satisfied then return true
            if(sum==target){
                System.out.println(ans);
                return true;
            }
            return false;
        }
        //take

        ans.add(arr[i]);
        sum += arr[i];
        if(printAnySubseqWithKSum(arr, ans, i+1, target, sum)) return true;

        //not take
        ans.remove(ans.size()-1);
        sum-=arr[i];
        if(printAnySubseqWithKSum(arr, ans,i+1, target, sum)) return true;

        return false;
    }

    //Q12. Print the count of subsequence with the given sum
    public static int countSubseqWithKSum(int[] arr, ArrayList<Integer> ans, int i, int target ,int sum){
        //base
        if(i>=arr.length){
            // another base case to reduce complexity
            if(sum>target){   // Assuming Array contains only positives
                return 0;   // no need to call next recursions because this will never add up to target.
            }
            // if condition is satisfied then return true
            if(sum==target){
                return 1;
            }
            return 0;
        }
        //take

        ans.add(arr[i]);
        sum += arr[i];
        int l = countSubseqWithKSum(arr, ans, i+1, target, sum);

        //not take
        ans.remove(ans.size()-1);
        sum-=arr[i];
        int r = countSubseqWithKSum(arr, ans,i+1, target, sum);

        return l+r;
    }

    //Q13. Merge Sort => check sorting folder
    //Q14. Quick Sort => check sorting folder

    //Q15. Combination sum - 1
    // Given an array of distinct integers and a target,
    // you have to return the list of all unique combinations where the chosen numbers sum to target. You may return the combinations in any order.
    //The same number may be chosen from the given array an unlimited number of times.
    // Two combinations are unique if the frequency of at least one of the chosen numbers is different.


    // leetcode variant
    public static List<List<Integer>> findCombo(int[] arr, int target){
        List<List<Integer>> output = new ArrayList<List<Integer>>();
        combinationSumOne(0,arr, new ArrayList<>(), target, output);
        return output;
    }

    public static void combinationSumOne(int i, int[] arr, ArrayList<Integer> list, int target,List<List<Integer>> output ){
        //base
        if(i>=arr.length){
            if(target==0){
                output.add(new ArrayList<>(list));
            }
            return;
        }
        if(arr[i]<=target){
            //pick
            list.add(arr[i]);
            combinationSumOne(i,arr,list,target-arr[i],output);
            // removing the element
            list.remove(list.size()-1);
        }
        //not pick
        combinationSumOne(i+1, arr, list, target,output);
    }





}



