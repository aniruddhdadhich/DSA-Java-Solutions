//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Knapsack01 {
    public static void main(String[] args){
        int[] arr = {};
        System.out.println(arr[0]);
    }


    // Knapsack 01 based problems

    // subset Sum problem
    static boolean subsetSum(int[] arr, int sum){
        // initialize t array of [n+1][sum+1] with boolean values
        // write the knapsack logic
        // return t[n][sum] value -> basically the last value of 2D array
        int n = arr.length;
        boolean[][] t = new boolean[n+1][sum+1];
        // initialization
        for(int i=0;i<=n; i++){
            for(int j=0;j<=sum;j++){
                if(j==0){
                    t[i][j] = true;
                }
                if(i==0 && j>0){
                    t[i][j] = false;
                }
            }
        }
        //logic
        for(int i=1; i<=n; i++){
            for(int j=1; j<=sum; j++){
                if(arr[i-1]<=j){
                    t[i][j] = t[i-1][j-arr[i-1]] || t[i-1][j];
                }
                else{
                    t[i][j] = t[i-1][j];
                }
            }
        }
        return t[n][sum];
    }

    //subset Sum problem recursive solution
    static Boolean[][] dp;  // normal boolean wouldn't be able to store null value, their default is 'false'. we need null checks.
    static boolean subsetSumMemo(int[] arr, int n, int sum) {
        // base cases
        if (sum == 0) return true;
        if (n == 0) return false;
        // memo check
        if (dp[n][sum] != null) {
            return dp[n][sum];
        }
        // choice diagram
        if (arr[n - 1] <= sum) {
            dp[n][sum] =
                    subsetSumMemo(arr, n - 1, sum - arr[n - 1]) ||
                            subsetSumMemo(arr, n - 1, sum);
        } else {
            dp[n][sum] = subsetSumMemo(arr, n - 1, sum);
        }

        return dp[n][sum];
    }



    // Equal sum partition problem - can this array be divided in two subsets where both of their sum is equal.
    static boolean equalSumSubsets(int[] arr){
        int sum = 0;
        for(int x: arr){
            sum+=x;
        }
        if(sum%2!=0) return false; // odd sum can't be divided in two parts
        else{
            return subsetSum(arr, sum/2); // if we can find a subset with half sum then other half will also exist with same sum.
        }
    }

    // Count the subsets of given sum in array
    static int countSubsetSum(int[] arr, int sum){
        //initialize with int values
        // logic, this time add the choices
        // return last guy in 2D matrix
        int n = arr.length;
        int[][] t = new int[n+1][sum+1];
        for(int i=0; i<n+1; i++){
            for(int j=0; j<sum+1; j++){
                if(j==0){
                    t[i][j] = 1;
                }
                if(i==0 && j>0){
                    t[i][j] = 0;
                }
            }
        }

        for(int i=1; i<n+1; i++){
            for(int j=1; j<sum+1; j++){
                if(arr[i-1]<=j){
                    t[i][j] = t[i-1][j-arr[i-1]] + t[i-1][j];
                }
                else{
                    t[i][j] = t[i-1][j];
                }
            }
        }
        return t[n][sum];

    }


    // Minimize the difference between two subsets of array
    // How to approach -> you have one array -> you have to divide it into 2 parts such that difference is minimum.
    // Best case -> if both the subsets have equal sum(which will be totalSum/2), then the difference will be 0.
    // ALMOST best case -> if we can somehow get any subset closer to totalSum/2. the other subset we don't have to explicitly calculate, bcs that will be totalSum - s1.
    // So we have to minimize this function -> [s2-s1] = [totalSum-s1 - s1] = [totalSum-2s1]
    // what can be s1 now -> anything from 0 to totalSum/2 -> so question becomes -> IS THERE ANY SUBSET of ARRAY of size n WITH SUM s1, where s1 goes from 0 to totalSum/2 -> basically a loop.
    // this is essentially the subsetSum problem -> we have to find out all t[n][j] boolean values, where j is from 0 to totalSum/2. and whichever are true there, for that subset possibility
    // we have to find [totalSum-2s1] value, whichever guy gives us the smallest value that's the closes guy to totalSum/2 and the minimum [totalSum-2s1] is the answer.

    static int minimumSubsetDiff(int[] arr){
        int n = arr.length;
        int sum =0;
        for(int x: arr){
            sum +=x;
        }
        boolean[][] t = new boolean[n+1][sum+1];
        //init the t matrix
        for(int i=0; i<=n; i++){
            t[i][0] = true;
        }

        // logic for subset Sum
        for(int i=1; i<=n; i++){
            for(int j=1; j<=sum; j++){
                if(arr[i-1]<=j){
                    t[i][j] = t[i-1][j-arr[i-1]] || t[i-1][j];
                }
                else{
                    t[i][j] = t[i-1][j];
                }
            }
        }

        // traverse the t[n][j] row till the half point to find out which all subsets are possible and minimize the diff
        int minDiff = Integer.MAX_VALUE;
        for(int j=0; j<=sum/2; j++){
            if(t[n][j]){
                minDiff = Math.min(minDiff, sum-2*j);
            }
        }
        return minDiff;
    }


    // Count the subset pairs with given difference
    // WHAT NOT TO DO? after filling matrix, traversing last row and finding for t[n][j] and t[n][j-diff] together -> why doesn't work? when we t[n][j], that works bcs
    // if j sum is in one subset then definitely sum-j will be in the remaining subset. Here we don't have that. eg. {1,2,3,1} => if diff is 1 -> {3} and {2} also fulfils if(t[n][j] && t[n][diff-j])
    // condition but that's not the answer.

    // WHAT TO DO? if s1-s2 = diff and s1+s2= Sum => 2s1 = Sum+diff => s1 = (Sum+diff)/2 => we have to count  subsets with (s+d)/2 sum. that's it.

    static int countSubsetsWithDiff(int[] arr, int diff){
        int sum = 0;
        for(int x: arr){
            sum+=x;
        }
        if((sum+diff)%2 != 0) return 0;
        if(diff>sum) return 0;
        return countSubsetSum(arr,(sum+diff)/2);
    }

    // REVISIT the Target SUM LEETCODE 494 -> Almost same as above but considers zeros with signs.
}
