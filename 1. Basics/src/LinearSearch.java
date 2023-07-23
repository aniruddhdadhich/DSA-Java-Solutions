import java.util.List;

public class LinearSearch{

 // MAIN METHOD /////////////////////////////////////////////////
    public static void main(String[] args) {
//        int[] nums = {1,6,85,45,24,69};

        // Q1 Call.
//        System.out.println(isExists(nums,4));

        //Q2 Call
//        int[] evenDigNums = {12,1,0,455,2689,254785};
//        System.out.println(evenDigits(evenDigNums));

        //Q3 Call
        int[][] wealth = {{1,2,3},{4,5,2},{0,1,20,2}};
        System.out.println(maxWealth(wealth));
    }

// Other Methods ////////////////////////////////////////////////////

    // Q1. Find whether 24 exists in an array
    static int isExists(int[] arr, int value){
        //If array length is 0
        if(arr.length==0){
            return -1;
        }

        // Traverse and Search
        for(int i=0;i<arr.length;i++){
            if(arr[i]==value){
                return i;
            }
        }
        return -1;
    }
///////////////////////////////////////////////////////////////

    // Q2. In an array, return how many are of even digits. like 23, 3542 are in even digits but 123 & 9 is not.

    static int evenDigits(int[] arr){
        if(arr.length!=0){
            int count = 0;
            for(int i=0; i<arr.length; i++){
                int flag = 0;
                if(arr[i]==0){
                    continue;
                }
                while(arr[i]!=0) {
                    arr[i] = arr[i] / 10;
                    flag = flag == 0 ? 1 : 0;
                }
                count = flag==0? count+1: count;

            }
            return count;
    }
        return 0;
    }

///////////////////////////////////////////////////////////////////
    //Q3. Richest Customer wealth. 2D array given, where rows are persons, columns are their money in different banks. Which cust has max wealth.
    static int maxWealth(int[][] arr){
        int max=0;
        for(int i=0;i<arr.length; i++){
            int sum = 0;
            for(int j=0; j<arr[i].length; j++){
                sum += arr[i][j];
            }
            max = Math.max(sum,max);
        }
        return max;
    }

////////////////////////////////////////////////////////////////////
    //Q4. Shuffle the Array. Given the array nums consisting of 2n elements in the form [x1,x2,...,xn,y1,y2,...,yn].
    //Return the array in the form [x1,y1,x2,y2,...,xn,yn].
    static int[] shuffle(int[] nums, int n) {
        int[] ans = new int[2*n];
        for(int i=0;i<2*n;i++){
            if(i%2==0){
                ans[i] = nums[i/2];
            }
            else{
                ans[i] = nums[n+i/2];
            }
        }
        return ans;
    }

//////////////////////////////////////////////////////////////////
//class Solution {
//    static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
//        // brute force approach
//        for(int i =0; i<candies.length; i++){
//            int temp = candies[i] + extraCandies;
//            for(int j=1; j<candies.length; j++){
//                if(temp<candies[j]){
//
//                }
//            }
//        }
//    }
//}



}