public class Patterns{
    public static void main(String[] args){
        //A1
        //fiveByFive();

        //A2
        //upperRightTri();

        //A3
        //upperRightTriNums();

        //A4
        //upperRightTriRepeatNums();

        //A5
         //lowerRightTri();

        //A5
        //lowerRightTriNums();

        //A6
        //fullUpperTri();

        //A7
        //fullDownTri();

        //A8
        //alternateOneZero(8);

        //A9
//        oneToN(5);
        //A10
        //crown(5);

        //A11
        //abcde(5);

        //A12
        //eeeee(5);

        //A13
        //alphaHillPattern(4);

        //A14
//        alphaTrianglePattern(5);

        //A15
        borderPattern(4);

    }


    // Q1. simple 5x5 star pattern
    static void fiveByFive(){
        for(int i=0;i<5;i++){
            for(int j=0; j<5; j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    //Q2 upper right triangle (1 to 5)
    static void upperRightTri(){
        for(int i=0;i<5;i++){
            for(int j=0;j<=i;j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    //Q3 upper right triangle (1, 1-2, 1-3, 1-4, 1-5)
    static void upperRightTriNums(){
        for(int i=0;i<5; i++){
            for(int j = 0; j<=i; j++) {
                System.out.print(j + 1);
            }
            System.out.println();
        }
    }

    //Q4 upper right triangle with repeating nums(1,22,333,4444,55555)
    static void upperRightTriRepeatNums(){
        for(int i=0;i<5; i++){
            for(int j=0; j<=i;j++){
                System.out.print(i+1);
            }
            System.out.println();
        }
    }

    //Q5 lower right triangle star pattern
    static void lowerRightTri(){
        for(int i=0;i<5;i++){
            for(int j=5;j>i;j--){
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    //Q6 lower Right triangle with number(1-5,1-4,1-3..)
    static void lowerRightTriNums(){
        for(int i=0;i<5;i++){
            for(int j=5; j>i;j--){
                System.out.print(5-j+1);
            }
            System.out.println();
        }
    }

    //Q7 Full upper triangle
    static void fullUpperTri(){
        for(int i=0;i<5;i++){
            for(int j=5; j>i+1; j--){
                System.out.print("  ");
            }
            for(int k=0; k<=i; k++){
                System.out.print("* ");
            }
            for( int l=0;l<i;l++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    // Q8. Full Down triangle
    static void fullDownTri(){
         for(int i=0;i<5;i++){
             for(int j = 0; j<i; j++){
                 System.out.print("  ");
             }
             for(int k=0; k<2*(5-i)-1;k++) {
                 System.out.print("* ");
             }
             System.out.println();
         }
        }

    // Q9. This one
    /*
    1
    0 1
    1 0 1
    0 1 0 1
    1 0 1 0 1
    */

    static void alternateOneZero(int n){

        for(int i = 0 ; i<n; i++){
            if(i%2==0){
                int flag = 1;
                for (int j = 0; j <= i; j++) {
                    System.out.print(flag);
                    flag = flag == 0 ? 1 : 0;
                }
            }
            else{
                int flag = 0;
                for (int j = 0; j <= i; j++) {
                    System.out.print(flag);
                    flag = flag == 0 ? 1 : 0;
                }
            }

            System.out.println();
        }
    }

    // Q10
//    1
//    2 3
//    4 5 6
//    7 8 9 10
//    11 12 13 14 15
    static void oneToN(int n) {
        int val = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(val);
                val++;
            }
            System.out.println();

        }
    }

    //Q11. Number crown Pattern

    static void crown(int n){
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                System.out.print(j);
            }
            for(int k=1;k<=(n-i)*2;k++){
                System.out.print(" ");
            }
            for(int l=0;l<i;l++){
                System.out.print(i-l);
            }
            System.out.println();
        }
    }

    //Q12 A to ABCDE
    static void abcde(int n){
        for(int i=0;i<n;i++){
            char start = 65;
            for(int j=0;j<=i;j++){
                System.out.print(start);
                start++;
            }
            System.out.println();
        }
    }

    //Q13 A -> BB -> CCC -> DDDD -> EEEEE
    static void eeeee(int n){
        char start = 65;
        for(int i =0;i <n;i++){

            for(int j =0; j<=i;j++){
                System.out.print(start);
            }
            start++;
            System.out.println();
        }
    }

    //Q14
    static void alphaHillPattern(int n){
        for(int i=0;i<n;i++){
            for(int j=0;j<n-i;j++){
                System.out.print(" ");
            }

            int pivot = i;
            char alpha = 'A';
            for(int l=0; l<2*i+1;l++){
                System.out.print(alpha);
                if(l<pivot) alpha++;
                else alpha--;
            }

            for(int j=0;j<n-i;j++){
                System.out.print(" ");
            }
            System.out.println();

        }
    }

    //Q15
    static void alphaTrianglePattern(int n){
        for(int i=0; i<n; i++){
            char alpha = (char)(65+n-i-1);
            for(int j=0;j<i+1;j++){

                System.out.print(alpha);
                if(j<i){
                    alpha++;
                }
                else{
                    alpha = (char)(65+n-i-2);
                }
            }
            System.out.println();


        }
    }

}

    //Q16 Border Number pattern
