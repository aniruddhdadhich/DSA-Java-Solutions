public class maths {
    public static void main(String[] args) {

        System.out.println(gcdEuclidean(29,58));


    }
    // Check that the no. is palindrome or not.
    static boolean palindrome(int N){
        int rev = reverse(N);
        if(N==rev){
            return true;
        }
        else{
            return false;
        }
    }

    // Reverse the digits of a given no.
    static int reverse(int N){
        boolean neg = false;
        if(N<0){
            N = -1*N;
            neg = true;
        }

        int dig;
        int num=0;
        while(N>0){
            dig = N%10;
            num = 10*num + dig;
            N = N/10;
        }
        if(neg){
            return -1*num;
        }
        return num;
    }

    // Print all the divisors of a given no.
    static void printDivisors(int N){

        for(int i =1 ; i*i<=N; i++){              // can use sqrt(N) but that function call will increase complexity.
            if(N%i==0){
                System.out.print(i+" ");
                if(i!=N/i){
                    System.out.print(N/i+" ");
                }
            }
        }
    }

    //Given a no. check if it is prime
    static void prime(int N){
        if(N==1){
            System.out.println("Not Prime");
            return;
        }
        for(int i=2;i*i<N; i++){             // Time complexity O(Sqrt(N))
            if(N%i==0){
                System.out.println("Not Prime");
                return;
            }
        }
        System.out.println("Prime");
    }

    //Find the GCD/HCF of 2 no.
    //Brute force
    static int gcd(int m, int n){
        int lowest = Math.min(m,n);   // 10,15
        int hcf=1;
        for(int i=1;i<=lowest;i++){
            if(m%i==0 && n%i==0){
                hcf=i;
            }
        }
        return hcf;

    }

    //Euclidean Algo (using recursion) => GCD(a,b) => GCD(a-b,b) Further break down the bigger number, till one of them becomes zero
    // The moment one becomes 0 other will be the HCF.
    static int gcdEuclidean(int a, int b){

        //Base condition
        if(a==0||b==0){
            return a>b?a:b;
        }
        // Recursive logic
        if(a>b){
            return gcdEuclidean(a-b,b);
        }
        else{
            return gcdEuclidean(a,b-a);
        }
    }

}
