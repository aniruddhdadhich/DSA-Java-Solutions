import com.sun.jdi.IntegerType;

import java.lang.reflect.Array;
import java.util.*;

public class Easy {
    public static void main(String[] args) {
        System.out.println("Here are all the EASY Array problems discussed in Striver's DSA sheet.");
        int[] arr = {-1,0,1,2,-1,-4};

        System.out.println(threeSum(arr));

    }



    // find the largest value in array
    static int largest(int[] arr){
        //brute force
        if(arr.length==0){
            return -1;
        }
        int max = Integer.MIN_VALUE;
        for(int i=0; i<arr.length;i++){
            if(arr[i]>max) {
                max = arr[i];
            }
        }
        return max;
    }




    // Find the second largest value in the array
    static int secondLargest(int[] arr){
        int max = arr[0];
        int sMax = Integer.MIN_VALUE;
        for(int i=0;i<arr.length; i++){
            if(arr[i]>max){
                sMax = max;
                max = arr[i];
            }
            else if(arr[i]<max && arr[i]>sMax){
                sMax = arr[i];
            }
        }
        // if all the values are same
        if(sMax == Integer.MIN_VALUE) return -1;
        else return sMax;

    }



    // Find the second smallest value in the array
    static int secondSmallest(int[] arr){
        int min = arr[0];
        int secondMin = Integer.MAX_VALUE;
        for(int i=0;i<arr.length;i++){
            if(arr[i]<min){
                secondMin = min;
                min = arr[i];
            }
            //for the last one
            else if(arr[i] != min && arr[i]<secondMin){
                secondMin = arr[i];
            }
        }
        //if all values are same => secondMin will never change
        if(secondMin==Integer.MAX_VALUE) return -1;
        else return secondMin;
    }



    // Remove the duplicate values from the array
    static int removeDuplicate(int[] arr){
        int p1 =0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]!=arr[p1]){
                arr[p1+1]= arr[i];
                p1++;
            }
        }
        System.out.println(Arrays.toString(arr));
        return p1+1;
    }



    // Left rotate the array by 1 value
    static void leftRotateByOne(int[] arr){
        //Optimal
        int temp = arr[0];
        for(int i=0;i<arr.length-1;i++){
            arr[i] = arr[i+1]; //left shifting
        }
        arr[arr.length-1] = temp;
    }



    // Left rotate the array by k
    static void leftRotateByK(int[] arr, int k){
        //Brute Force
        //temp arr
//        int[] temp = new int[k];
//        for(int i=0;i<k;i++){
//            temp[i] = arr[i];
//        }
//
//        // shifting the remaining array
//        for(int i=k;i<arr.length;i++){
//            arr[i-k] = arr[i];
//        }
//
//        // restoring temp at the last places
//        for(int i=0;i< k;i++){
//            arr[i+k+1] = temp[i];
//        }

        // Optimal Approach using - reversal algorithm   //TC = O(k)+O(n-k)+ O(n) = O(2n) But space C = O(1); No extra space.
        k = k%arr.length;
        reverse(arr,0,k-1);
        reverse(arr,k,arr.length-1);
        reverse(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));

        // If asked for right rotation
        //reverse(arr,0,n-k-1);  // n is length and k is rotation places.
        //reverse(arr,n-k,n-1);
        //reverse(arr,0,n-1);
    }



    // Reverse the array
    static void reverse(int[] arr, int start, int end){
        while(start<=end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }



    // Move all the zeros to the end
    static void moveAllZerosToEnd(int[] arr){
        // Two Pointer Approach

        //find the first zero
//        int j = -1; // index for the first zero
//        for(int i=0;i<arr.length;i++){
//            if(arr[i]==0){
//                j = i;
//                break;
//            }
//        }
//
//        // traverse the array for the logical operations
//        for(int i=j+1;i<arr.length;i++){
//            if(arr[i]!=0){
//                int temp = arr[i];
//                arr[i] = arr[j];
//                arr[j] = temp;
//                j++;
//            }
//        }
//        System.out.println(Arrays.toString(arr));


        //Single pointer approach
        int p = 0;
        for(int i=0;i<arr.length; i++){
            if(arr[i]!=0){
                arr[p] = arr[i];
                p++;
            }
        }
        // Now fill the zeros at the end
        while(p<arr.length){
            arr[p]  = 0;
            p++;
        }
        System.out.println(Arrays.toString(arr));
        // Time comp => O(n)+O(n-p) = O(2n); Space = O(1)
    }



    // Union of Two sorted Arrays
    static ArrayList<Integer> unionOfArrays(int[] arr1, int[] arr2, int m, int n){
        ArrayList<Integer> union = new ArrayList<>();
        int i=0, j =0;

        // The case where m and n aren't exhausted
        while(i<m && j<n){
            if(arr1[i]<=arr2[j]){
                if(union.isEmpty() || union.get(union.size()-1)!=arr1[i]){
                    union.add(arr1[i]);
                }
                i++;
            }

            else{
                if(union.isEmpty() || union.get(union.size()-1) != arr2[j]){
                     union.add(arr2[j]);
                    }
                j++;
                }
            }


        // The case where n is done.
        while(i<m){
            if(union.get(union.size()-1) != arr1[i]) {
                union.add(arr1[i]);
            }
            i++;
        }
        // the case where m is done.
        while(j<n){
            if(union.get(union.size()-1)!= arr2[j]){
                union.add(arr2[j]);

            }
            j++;
        }
        System.out.println(union);
        return union;
    }



    // Intersection of the two sorted arrays
    static ArrayList<Integer> intersectionOfArrays(int[] a, int[] b){
        int m = a.length;
        int n = b.length;

        int i = 0;
        int j = 0;

        ArrayList<Integer> intersection = new ArrayList<>();

        while(i<m && j<n){
            if(a[i]==b[j]){
                intersection.add(a[i]);
                i++;
                j++;
            }
            else{
                if(a[i]<b[j]){
                    i++;
                }
                else{
                    j++;
                }
            }
        }
     return intersection;
    }



    // Find the missing value in the array containing n-1 values out of the 1 to n values.
    // Brute force => Linear Search -> Nested loops -> O(n^2)
    // Better => Use Hashmap
    // Optimal Approach => Use 1toN sum; TC = O(N) SC =O(1);
    static int missingValueBySum(int[] arr, int N){
        int target = (N*(N+1))/2;
        int sum = 0;
        for(int i=0; i<N-1; i++){
            sum += arr[i];
        }
        return target - sum;
    }
    // Optimal Approach => Use XOR - 2 equal no. XOR is 0 and 0's XOR with any num is the num itself.
    static int missingValueByXor(int[] arr, int N){
        //XOR the array with XOR of 1 to N; everyone will form a pair but the missing, pairs return 0, 0 with missing =>  missing

        // O(2n)
//        int xor1 = 0;
//        for(int i=0; i<N-1; i++){
//            xor1 = xor1^arr[i];
//        }
//        int xor2 = 0;
//        for(int i=1; i<=N; i++){
//            xor2 = xor2^i;
//        }
//        return xor1^xor2;

        //O(N)
        int xor = 0;
        for(int i=0; i<N-1; i++){
            xor = xor^arr[i];
            xor = xor^(i+1); // start with 1, goes till N-1 but N is missed so take xor with N in next step;
        }
        xor = xor^N;
        return xor;
    }



    // Find Maximum consecutive ones in the arrays of 0s and 1s. //[1,1,0,1,1,1]
    static int maximumConsecutiveOnes(int[] arr){              // O(N) time complexity
        int i = 0;
        int count =0;
        int maxCount = 0;
        while(i<arr.length){
            if(arr[i]==1){
                count++;
                maxCount = Math.max(count,maxCount);
            }
            else{
                count = 0;
            }
            i++;
        }
        return maxCount;
    }



    // Find the number that appears once   {1,1,2,2,3}
    static int appearsOnce(int[] arr){
       // Try XOR
        int xor = 0;
        for(int i=0; i<arr.length; i++){
            xor = xor^arr[i];
        }
        return xor;

    }



    // Find the longest subarray with sum k(positive);
    // Brute Approach
    static int longestSubarrayWithSumBrute(int[] arr, int k){
        int n = arr.length;
        int maxCount =0;


        for(int i=0;i<n; i++){
            int count = 0 ;
            int sum =0;
            for(int j=i; j<n; j++){
                sum +=arr[j];
                count++;

                if(sum == k){
                    maxCount = Math.max(count,maxCount);
                    break;
                }
                if( sum > k){
                    break;
                }
            }

        }
        return maxCount;
    }
    // Better Approach => Using Hashmap
    static int longestSubarrayWithSumHash(int[] arr, int k){
        HashMap<Integer,Integer> map = new HashMap<>();
        int maxLen =0;
        int sum = 0;
        for(int i=0; i<arr.length; i++){
            sum += arr[i];
            if(sum==k){
                maxLen = Math.max(maxLen,i+1);
            }
            int rem = sum - k;
            if(map.containsKey(rem)){
                int len = i - map.get(rem);
                maxLen   = Math.max(maxLen,len);
            }
            if(!map.containsKey(sum)){         // If this sum previously doesn't exist then only put it there.
                map.put(sum,i);
            }

        }
        return maxLen;
    }
    // Optimal Approach => Using Two Pointers => BUT ONLY FOR POSITIVE AND ZEROS
    static int longestSubarrayWithSumTwoPointer(int[] arr, int k){
        int n = arr.length;
        int left= 0;
        int right=0;
        int sum = arr[0];
        int maxLen = 0;
        while(right<n){           // untill we haven't crossed the array length
            while(left<=right && sum>k){       // left and right haven't crossed and sum is greater than required.
                sum -= arr[left];              // Start removing from left side and increase left index
                left++;
            }
            if(sum ==k){                  // If sum is equal to target at this point then just find out the length and compare with maxLen.
                maxLen = Math.max(maxLen,right-left+1);
            }
            // Last case where sum is still lower than target,
            right++; // move to the next element and then sum
            if(right<n) sum += arr[right];      // check that we haven't crossed the limit and then increase the sum by the index value.
        }
        return maxLen;                          // Return the max length.
    }


    // Given an array return true if the number of occurences of each value in the array is unique. (Leetcode 1207)
    static boolean uniqueOccurences(int[] arr){
        HashMap<Integer,Integer> map = new HashMap<>();
        // create map from arr
        for(int i: arr){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        // create a set from the map
        HashSet<Integer> st = new HashSet<>();
        for(int j:map.keySet()){
            st.add(map.get(j));
        }

        // now compare => are the sizes of both map and set are same?
        // if same then there is no repetition in no. of occ.
        // if no then there is some no(s) which are coming twice or more so they
        // weren't included in the set second time onwards.
        if(map.size() == st.size()) return true;
        else return false;
    }

    // find the value which comes twice in an array
    // 1. sum method 2. XOR method.
    public static int findDuplicate(ArrayList<Integer> arr) {
        int n = arr.size();
        int arrSum = 0;
        int nSum;
        for(int i=0; i<n; i++){
            arrSum += arr.get(i);
        }
        nSum= (n*(n-1))/2;

        return nSum-arrSum;
    }

    // find the values and return them in an array which comes twice in input array (Leetcode 442)
    public static List<Integer> findDuplicates(int[] arr){
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int val:arr){
            map.put(val,map.getOrDefault(val,0)+1);
        }

        List<Integer> list = new ArrayList<>();
        for(int i:map.keySet()){
            if(map.get(i)==2){
                list.add(i);
            }
        }
        return list;
    }

    //optimized approach
        //=> Given an integer array nums of length n where all the integers of nums are in the range [1, n] and each integer appears once or twice, return an array of all the integers that appears twice.

        // shouldn't use extra space and linear runtime
    public static List<Integer> findDuplicatesOptimize(int[] arr){
        List<Integer> output = new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            int index = Math.abs(arr[i]) - 1;

            //if already negative means you visited this prev. => this is a duplicate
            if(arr[index]<0) output.add(index+1);
            else arr[index] = -1*arr[index];
        }
        return output;
    }


    //3Sum
    public static List<List<Integer>> threeSum(int[] nums){
        List<List<Integer>> output = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0; i<nums.length-2; i++){
            int p1 = i+1;
            int p2 = nums.length-1;
            while(p1<p2){
                if(nums[p1]+nums[p2]==-nums[i]){
                    output.add(Arrays.asList(nums[i],nums[p1],nums[p2]));
                    while(p1<p2 && nums[p1]==nums[p1+1]) p1++;  // to avoid duplicates shift until you get different value
                    while(p1<p2 && nums[p2]==nums[p2-1]) p2--;  // same for last pointer
                    p1++; // shift once if you get a differernt value
                    p2--;
                }
                else if(nums[p1]+nums[p2]>-nums[i]){
                    p2--;
                }
                else{
                    p1++;
                }
            }
        }

        return output;
    }
}
