import java.lang.reflect.Array;
import java.util.*;

public class Medium {
    public static void main(String[] args) {
        List<Integer> A = Arrays.asList(new Integer[] {1,2,3});
        List<Integer> ans = nextPermutation(A);

        System.out.print("The next permutation is: [");
        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }
        System.out.println("]");



    }


    // ***TWO SUM***
    // Variation 1 => Return indices
    // Variation 2 => Return true or false (The sum exists or not)
    static int[] twoSumIndices(int[] arr , int k){
        //Hashmap method => for indices
        HashMap<Integer,Integer> map = new HashMap<>();
        int[] ans = {-1,-1};
        for(int i=0; i<arr.length; i++){
            if(map.containsKey(k-arr[i])){
                ans[0] = map.get(k-arr[i]);
                ans[1] = i;
                return ans;
            }
            map.put(arr[i],i);
        }

        return ans;
    }
    // You can use hashmap but optimal solution would be to use two pointer from both sides
    static boolean twoSumExists(int[] arr, int k){
        //first sort the array   // This is the reason we can't get indices because we have manipulated the array
        Arrays.sort(arr);
        // Now start with 2 pointers     //{2, 6, 5, 8, 11}  //14  {2,5,6,8,11}
        int left = 0;
        int right = arr.length-1;
        while(left<right){
            if(arr[left]+arr[right]==k){
                return true;
            }
            else if(arr[left]+arr[right]<k){
                left++;
            }
            else{
                right--;
            }
        }
        return false;
    }

    // *** Sort the array of 0s, 1s and 2s. ***
    static int[] sortZeroOneTwoCountMethod(int[] nums){
        // Count method
        int countRed =0;
        int countWhite = 0;
        int countBlue = 0;
        // Get the count
        for(int i=0; i<nums.length; i++){
            if(nums[i]==0){
                countRed++;
            }
            else if(nums[i] == 1){
                countWhite++;
            }
            else{
                countBlue++;
            }
        }
        // Fill the array again
        for(int i=0; i<countRed; i++){
            nums[i] = 0;
        }
        for(int i=0; i<countWhite; i++){
            nums[i + countRed] = 1;
        }
        for(int i=0; i<countBlue; i++){
            nums[i + countRed + countWhite] = 2;
        }
        return nums;
    }
    static int[] sortZeroOneTwoDNFMethod(int[] nums){
        int low = 0;
        int mid = 0;
        int high = nums.length -1;

        while(mid<=high){     // How do we decide this condition => till the unsorted part is over. which is mid to high-1;
            if(nums[mid]==0){
                int temp = nums[mid];
                nums[mid] = nums[low];
                nums[low] = temp;
                low++;
                mid++;
            }
            else if(nums[mid]==1){
                mid++;
            }
            else{
                int temp = nums[mid];
                nums[mid] = nums[high];
                nums[high] = temp;
                high--;
            }
        }
        return nums;
    }

    // *** Find the element that occurs more than N/2 times ***
    static int majorityElement(int[] nums){
        // Using Moore's Voting Algo.
        int el = nums[0];
        int count = 0;
        for(int i=0;i<nums.length; i++){
            if(nums[i]==el){
                count++;
            }
            else{
                count--;
            }
            if(count==0){
                el = nums[i+1];
            }
        }
        return el;
    }

    // ***Kadane's Algo => Maximum sum subarray ***
    static int maxSumSubarray(int[] arr){
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++){
            sum += arr[i];
            maxSum = Math.max(sum,maxSum);
            // if sum is negative then discard the sum,
            if(sum<0){
                sum = 0;
            }
        }
        return maxSum;
    }

    // *** Kadan'es Algo => Printing the maxSum subarray ***
    static void maxSumSubarrayPrint(int[] arr){
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        int startIndex = -1;
        int endIndex = -1;
        int start=0;
        for(int i=0; i<arr.length; i++){
            if(sum == 0){
                start = i;
            }
            sum += arr[i];
            if(sum>maxSum){
                maxSum = sum;
                startIndex = start;
                endIndex = i;
            }
            // if sum is negative then discard the sum,
            if(sum<0){
                sum = 0;
            }
        }
        for(int i=startIndex; i<=endIndex ; i++){
            System.out.print(arr[i]+" ");
        }

    }

    // *** Stocks Buy and Sell ***
    static int stocksBuySell(int[] arr){
        int profit = 0;          // {12,6,4,8,7,12,14,4}
        int maxProfit  = 0;
        int min = arr[0];
        for(int i=1; i<arr.length; i++){
            profit = arr[i] - min;
            maxProfit = Math.max(profit,maxProfit);
            min = Math.min(min, arr[i]);
        }
        return maxProfit;
    }

    // *** Rearrange +ve and -ve values alternatively ***
    static int[] alternativeSigns(int[] arr){
        int n = arr.length;
        int[] ans = new int[n];
        int pos=0;
        int neg=1;
        for(int i=0; i<n; i++){
            if(arr[i]>0){
                ans[pos] = arr[i];
                pos = pos+2;
            }
            else{
                ans[neg] = arr[i];
                neg = neg+2;
            }
        }
        return ans;
    }

    // ** Next Permutation **
    static List<Integer> nextPermutation(List<Integer> arr){
         int n = arr.size();

        //step 1 -  find the breakpoint
        int index = -1;
        for(int i= n-2; i>=0; i--){
            if(arr.get(i)<arr.get(i+1)) {
                index = i;
                break;
            }
        }
        // if there is no break point => meaning it is the last permutation so just revert to the the first permutation by reversing
        if(index == -1){
            Collections.reverse(arr);
            return arr;
        }
        // find the just bigger value than the breakpoint in right side of breakpoint and swap with breakpoint
        for(int i=n-1; i>index; i--){
            if(arr.get(i)>arr.get(index)){
                int temp = arr.get(i);
                arr.set(i, arr.get(index));
                arr.set(index, temp);
                break;
            }
        }

        // reverse the right side.
        List<Integer> sublist = arr.subList(index+1, n);
        Collections.reverse(sublist);

        return arr;

    }



}
