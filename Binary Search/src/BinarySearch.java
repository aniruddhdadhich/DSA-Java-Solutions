public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {3,1};  // 0

        int id = searchInRotatedUnique(arr, 1);
        System.out.println(id);
    }



    // 1. Binary Search implementation
    static int binarySearch(int[] nums, int target){
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
            int i = (start + end)/2;
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
        int ub = arr.length;
        while(start<=end){
            int i = (start+end)/2;
            if(arr[i]==value){
                System.out.println("Floor and Ceil both are: "+ arr[i]);
                return;
            }
            else if(arr[i]>value){
                ub = i;
                end = i-1;
            }
            else{
                start = i+1;
            }
        }
        System.out.println("Floor is :"+ (arr[ub-1]));
        System.out.println("Ceil is :" + (arr[ub]));
    }

    // 6. First and last occurrence of an element in the sorted array
    static int lastOccurence(int[] arr, int value){
        int start  = 0;
        int end = arr.length -1;
        int ub = -1;
        // first occurrence will always be lower bound and last will be arr[upperbound -1]
        while(start<=end){
            int i = (start+end)/2;
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
            if(arr[i]>=arr[start]){                   //{3,1};  1
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

}
