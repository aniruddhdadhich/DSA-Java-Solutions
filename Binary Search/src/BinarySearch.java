import java.util.Stack;

public class BinarySearch {

    public static <Char> void main(String[] args) {
//        int[] arr = {1,4,9,16,25,36,49,64,81,100,121,144,169,196,225,256,289,324,361,400,441,484};  // ans = 8, index = 6
        System.out.println(squareRoot(357604));

    }



    // 1. Binary Search implementation
    static int binarySearch(int[] nums, int target) {
        int start=0;
        int end = nums.length-1;

        while(start<=end){
            int i = (start + end)/2;
            if(nums[i]==target){
                return i;
            }
            else if(nums[i]<target){
                start = i+1;
            }
            else{
                end = i-1;
            }
        }
        return -1;
    }

    // 2. Lower Bound => smallest index with number equal or bigger than the target
    static int lowerBound(int[] arr, int target){
        int start = 0;
        int end = arr.length-1;
        int ans = arr.length;
        while(start<=end){
            int i = start+(end-start)/2;   // optimization if start and end range in 2^31-1 levels.
            if(arr[i]>=target){
                ans = i;
                end = i-1;
            }
            else{
                start = i+1;
            }
        }
        return ans;
    }

    // 3. Upper Bound
    static int upperBound(int[] arr, int target){
        int start = 0;
        int end = arr.length-1;
        int ans = arr.length;
        while(start<=end){
            int i = (start + end)/2;
            if(arr[i]>target){
                ans = i;
                end = i-1;
            }
            else{
                start = i+1;
            }
        }
        return ans;
    }

    // 4. Search Insert Position => Basically lower bound implementation
    static int serachInsert(int [] nums, int target){
        int start = 0;
        int end = nums.length-1;
        int lb = nums.length;
        while(start<=end){
            int i = (start+end)/2;
            if(nums[i]>=target){
                lb =  i;
                end = i-1;
            }
            else{
                start = i+1;
            }
        }
        return lb;

    }

    // 5. floor and ceil of a number in the given sorted array
    static void floorAndCeil(int[] arr, int value){
        int start = 0;
        int end = arr.length-1;
        int lb = arr.length;
        while(start<=end){
            int i = (start+end)/2;
            if(arr[i]==value){
                System.out.println("Floor and Ceil both are: "+ arr[i]);
                return;
            }
            else if(arr[i]>value){
                lb = i;
                end = i-1;
            }
            else{
                start = i+1;
            }
        }
        System.out.println("Floor is :"+ (arr[lb-1]));
        System.out.println("Ceil is :" + (arr[lb]));
    }

    // 6. First and last occurrence of an element in the sorted array
    static int lastOccurence(int[] arr, int value){
        int start  = 0;
        int end = arr.length -1;
        int ub = -1;
        // first occurrence will always be lower bound and last will be arr[upperbound -1]
        while(start<=end){
            int i = start + (end-start)/2;
            if(arr[i]>value){
                ub = i;
                end = i-1;
            }
            else{
                start = i+1;
            }
        }
        return ub-1;
    }

    // 6a. Leetcode variant of first and last occ.
    public int[] searchRange(int[] nums, int target) {
        int[] ans = {-1,-1};
        ans[0] = firstIndex(nums,target);
        ans[1] = lastIndex(nums,target);
        return ans;
    }

    public int firstIndex(int[] nums, int target){
        int s = 0;
        int e = nums.length-1;
        int f = -1;
        while(s<=e){
            int mid = s + (e-s)/2;
            if(nums[mid]>=target){    // hume equal bhi mile to bhi hum peeche jayenge to find first
                e = mid-1;
            }
            else if(nums[mid]<target){
                s = mid+1;
            }
            if(nums[mid]==target) f = mid;
        }
        return f;
    }
    public int lastIndex(int[] nums, int target){
        int s = 0;
        int e = nums.length-1;
        int l = -1;
        while(s<=e){
            int mid = s + (e-s)/2;
            if(nums[mid]>target){
                e = mid-1;
            }
            else if(nums[mid]<=target){    // hume equal bhi mile to bhi hum aage jayenge to find last
                s = mid+1;
            }
            if(nums[mid]==target) l = mid;
        }
        return l;
    }

    //7. Count the occurences of an element in an sorted array
    // the ans = (upperbound index - lower bound index);

    //8. Find the value in rotated sorted array (all distinct values)
    static int searchInRotatedUnique(int[] arr, int value){
        int start = 0;
        int end = arr.length - 1;
        int ans = -1;

        while(start<=end){
            int i = (start+end)/2;
            if(arr[i]==value){
                ans = i;
                break;
            }
            if(arr[i]>=arr[start]){
                //left half is sorted
                if(value>=arr[start] && value<=arr[i]){
                    end = i-1;
                }
                else{
                    start = i+1;
                }
            }
            else{
                //right half is sorted
                if(value<=arr[end] && value>=arr[i]){
                    start = i+1;
                }
                else{
                    end = i-1;
                }
            }

        }
    return ans;
    }

    // 9. Find the value in rotated Sorted Array(may contain duplicate value)
    static boolean searchInRotatedDuplicate(int[] arr, int value){
        int start = 0;
        int end = arr.length - 1;

        while(start<=end){
            int i = (start+end)/2;
            if(arr[i]==value){
                return true;
            }

            // edge case which didn't exist in unique element array
            if(arr[i]==arr[start] && arr[i] == arr[end]){
                start++;
                end--;
                continue;
            }


            if(arr[i]>=arr[start]){
                //left half is sorted
                if(value>=arr[start] && value<=arr[i]){
                    end = i-1;
                }
                else{
                    start = i+1;
                }
            }
            else{
                //right half is sorted
                if(value<=arr[end] && value>=arr[i]){
                    start = i+1;
                }
                else{
                    end = i-1;
                }
            }

        }
        return false;
    }

    //10. Find the minimum in rotated sorted array(unique values)
    static int searchMinimumInRotated(int[] arr){
        int start = 0;
        int end = arr.length - 1;
        int min = Integer.MAX_VALUE;
        while(start<=end){
            int i = (start+end)/2;

            if(arr[i]>=arr[start]){
                // left half is sorted
                min = Math.min(min,arr[start]);
                // now discard the left half
                start = i+1;
            }
            else{
                // right half is sorted
                min = Math.min(min,arr[i]);
                // now discard the right half
                end = i-1;
            }
        }
        return min;
    }

    // 11. Find the minimum no. of times array is rotated.
    // approach - find the index of minimum number in array that's the answer.
    static int numberOfRotations(int[] arr){
        int start = 0;
        int end = arr.length - 1;
        int min = Integer.MAX_VALUE;
        int mini = -1;
        while(start<=end){            //{1,2,3}
            int i = (start+end)/2;
            if(arr[i]>=arr[start]){
                // left half is sorted
                if(arr[start]<min) {
                    min = arr[start];
                    mini = start;
                }
                // now discard the left half
                start = i+1;
            }
            else{
                // right half is sorted
                if(arr[i]<min) {
                    min = arr[i];
                    mini = i;
                }
                // now discard the right half
                end = i-1;
            }
        }
        return mini;
    }

    // 12. all elements are occurring twice except one, find that single element. in a sorted array
    // {1,1,2,2,3,4,4,5,5,6,6}
    // approach => all pair elements should have even index then odd index, but when the single one comes
    // it changes to their indices as odd-even. so if you hit odd-even then go left otherwise go right.
    static int findSingleElement(int[] arr){
        int n = arr.length;

        //edge cases
        //1. if only one element
        if(n == 1){
            return arr[0];
        }
        // 2. if ans at boundaries
        if(arr[0]!=arr[1]) return arr[0];
        if(arr[n-1]!= arr[n-2]) return arr[n-1];

        //
        int start = 1;
        int end = n-2;
        int ans = -1; // no single element then -1

        while(start<=end){
            int i = (start+end)/2;

            // check for ans
            if(arr[i]!=arr[i+1] && arr[i]!=arr[i-1]){
                return arr[i];
            }
            else{
                // you have hit a pair
                // is this the first one && it's index is even => this is left, go to the right
                if(arr[i]==arr[i+1] && i%2==0){
                    start = i+2;
                }
                // is this the second one && it's index is odd => this is left, go to the right
                else if(arr[i]==arr[i-1] && i%2!=0){
                    start = i+1;
                }
                // is this the first one and it's index is odd => this is right, to the left;
                else if(arr[i]==arr[i+1] && i%2!=0){
                    end = i-1;
                }
                // is this the second one and it's index is even = any way last case
                else{
                    end = i-2;
                }
            }
        }
        return ans;
    }

    //13. Find the peak element index, if multiple then return any one of them
    static int peakElement(int[] arr){
        int n = arr.length;
        //edge case
        // only one element
        if(n==1){
            return 0;
        }
        // boundary elements ==> easy cases to return and get answer
        if(arr[0]>arr[1]){
            return 0;
        }
        if(arr[n-1]>arr[n-2]){
            return n-1;
        }

        //main implementation
        int start = 1;
        int end = n-2;

        while(start<=end){
            int i = (start+end)/2;

            // check ans
            if(arr[i]>arr[i+1] && arr[i]>arr[i-1]){
                return i;
            }
            // if not the ans
            if(arr[i]>arr[i-1]){
                // we are on increment curve, peak can't be on left, go right
                start = i+1;
            }
            else{
                // we are on decrement curve, peak can't be on right, go left
                end = i-1;
            }
        }
        return -1;
    }


    // 14. Find square root integer part by binary search
    static int squareRoot(int n){
        int low = 0;
        int high = n;
        int ans= 1;
        if(n==1){
            return 1;
        }
        while(low<=high){
            int mid = low + (high-low)/2;
            if((mid*mid)==n){
                return mid;
            }
            else if((mid*mid)>n){
                high = mid-1;
            }
            else{
                ans = mid;
                low = mid+1;
            }
        }
        return ans;
    }
}
