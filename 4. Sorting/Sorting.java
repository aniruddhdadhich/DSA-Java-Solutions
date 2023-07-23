import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Sorting{
    public static void main(String[] args) {
        int[] nums = {13,24,20,9,46,54,52};
        System.out.println(Arrays.toString(nums));
        quickSort(nums,0,nums.length-1);
        System.out.println(Arrays.toString(nums));


    }

    // Selection Sort => Take the minimum, swap it with the first place of concerned unsorted part.
    static int[] selection(int[] arr){
        for(int i=0; i<arr.length-1;i++){   // outer loop which will run till n-2
            int minIndex = i;                // initializing min index at the first place of unsorted array
            for(int j=i; j<arr.length;j++){     // inner loop to traverse unsorted part
                if(arr[j]<arr[minIndex]){       // finding the minimum
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];   // swapping with the first place.
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
        return arr;
    }

    // Bubble Sort => Take the maximum and put it at the last place through iterative adjacent swapping.
    static void bubble(int[] arr){
        for(int i=arr.length-1;i>0;i--){
            int didSwap=0;         //for optimization
            for(int j=0;j<i;j++){
                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    didSwap = 1;
                }
            }
            if(didSwap==0){
                break;
            }
            System.out.println("Runs");
        }
    }
    // Worst case Time complexity => O(N^2); Best case=> O(N) => How? optimization, if no swap happened then just break out bcs it's sorted.

    //Insertion Sort
    static void insertion(int[] arr){
        for(int i=1;i<arr.length;i++){
            int j=i;
            while(j!=0 && arr[j]<arr[j-1]){    // applying 2nd condition here bcs left part will always sorted.
                int temp = arr[j];
                arr[j]= arr[j-1];
                arr[j-1]= temp;
                j--;
            }
        }
    }

    // Merge Sort And Merge logic
    static void mergeSort(int[] arr, int low, int high){
        //base
        if(low==high){
            return;
        }

        int mid= (low+high)/2;
        mergeSort(arr,low,mid);
        mergeSort(arr,mid+1,high);
        merge(arr,low,mid,high);
    }
    static void merge(int[] arr, int low, int mid, int high){

        int p1= low;
        int p2 = mid+1;
        ArrayList<Integer> temp = new ArrayList<>();

        // When they don't reach the boundaries
        while(p1<=mid && p2<=high){
            if(arr[p1]>arr[p2]){
                temp.add(arr[p2]);
                p2++;
            }
            else{
                temp.add(arr[p1]);
                p1++;
            }
        }
        //Boundary condition for right => left array still have values left
        while(p1<=mid){
            temp.add(arr[p1]);
            p1++;
        }
        //Boundary condition for left => right array still have values left
        while(p2<=high){
            temp.add(arr[p2]);
            p2++;
        }

        // Transferring all the values from arrayList to array
        for(int i=low; i<=high;i++){
            arr[i] = temp.get(i-low);
        }


    }

    // Bubble Sort using recursion
    static void recursiveBubble(int[] arr, int n){
        //base
        if(n==1){
            return;
        }

        for(int i =0;i<n-1;i++){
            if(arr[i]>arr[i+1]){
               int temp = arr[i];
               arr[i] = arr[i+1];
               arr[i+1] = temp;
            }
        }
        recursiveBubble(arr, n-1);
    }


    //Quick Sort
    static void quickSort(int[] arr, int low, int high){
        if(low<high){
            int part = partition(arr,low,high);
            quickSort(arr,low,part-1);
            quickSort(arr,part+1,high);
        }

    }
    static int partition(int[] arr, int low, int high){
        int pivot = arr[low];  // Can take anything, taking the first value
        int i = low;
        int j = high;

        while(i<j){
            while(arr[i]<=pivot && i<=high-1){
                i++;
            }
            while(arr[j]>pivot && j>=low+1){
                j--;
            }
            if(i<j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp2 = arr[low];
        arr[low] = arr[j];
        arr[j] = temp2;
        return j;
    }

}