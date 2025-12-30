public class KnapsackUnbounded {
    public static void main(String[] args) {
         int[] price = {1,5,8,9};
         int n = 4;
        System.out.println(cutRod(price,n));

    }
    public static int cutRod(int[] price, int n) {
        int[][] t = new int[n+1][n+1];
        for(int i=0; i<=n; i++){
            for(int j=0; j<=n; j++){
                t[i][j] = 0;
            }
        }
        //logic
        int[] len = new int[n];
        for(int k=0;k<n;k++){
            len[k] = k+1;
        }
        for(int i=1; i<=n; i++){
            for(int j =1; j<=n; j++){
                if(len[i-1]<=j){
                    t[i][j] = Math.max(price[i-1] + t[i][j-len[i-1]], t[i-1][j]);
                }
                else{
                    t[i][j] = t[i-1][j];
                }
            }
        }
        return t[n][n];
    }

    static int coinChangeNumOfWays(int[] coins, int amount){     // Coin Change 2 - Leetcode 518
        int n = coins.length;
        int[][] t = new int[n+1][amount+1];
        for(int i=0; i<=n; i++){
            t[i][0] = 1;
        }
        //logic
        for(int i=1; i<=n; i++){
            for(int j =1; j<=amount; j++){
                if(coins[i-1]<=j){
                    t[i][j] = t[i][j-coins[i-1]] + t[i-1][j];
                }
                else{
                    t[i][j] = t[i-1][j];
                }
            }
        }
        return t[n][amount];
    }
}
