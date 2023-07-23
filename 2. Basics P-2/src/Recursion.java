import java.util.Arrays;

public class Recursion {
    public static void main(String[] args) {
        String s = "ABBA";
        System.out.println(palindromeCheck(s,0,s.length()));

    }


    //1. Print from 1 to N recursively
    static void printTill(int N){
        //base
        if (N == 0) {
            return;
        }
        //logic
        printTill(N-1);
        System.out.print(N+" ");
    }

    //2. Print a name N times;
    static void printName(String name,int N){
        //base
        if(N==0){
            return;
        }

        System.out.println(name);
        printName(name,N-1);
    }

    //3. Sum of first N numbers.
    static int sumN(int N){
        //base
        if(N==1){
            return 1;
        }
        //logic
        int sum=0;
        sum = N+ sumN(N-1);
        return sum;
    }

    //4. Factorial of N numbers
    static int fact(int N){
        //base ( Not checking for negatives) depends on constraints
        if(N==1 || N==0){
            return 1;
        }
        //logic
        int factorial = 1;
        factorial = N*fact(N-1);
        return factorial;
    }

    //5. Reverse an Array recursively
    static void reverseArray(int i, int n, int[] arr){    // n is array length and i is 0 for now.
        if(i>=n/2){
            System.out.println(Arrays.toString(arr));
            return;
        }
        int temp;
        temp = arr[i];
        arr[i] = arr[n-i-1];
        arr[n-i-1] = temp;
        reverseArray(i+1,n,arr);


    }

    //6. check if a string is palindrome or not
    static boolean palindromeCheck(String s,int i, int n){
        //base
        if(i>=n/2){
            return true;
        }

        //logic                                       //ACCBA
        if(s.charAt(i)!=s.charAt(n-i-1)){
            return false;
        }
        return palindromeCheck(s,i+1,n);

    }

}
