public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {1,3,3,5,9,16};
        int idx = serachInsert(arr, 8);
        System.out.println(idx);
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

    // 4. Search Insert Position
    static int serachInsert(int [] nums, int target){
        int start = 0;
        int end = nums.length-1;
        int ub = nums.length;
        while(start<=end){
            int i = (start+end)/2;
            if(nums[i]==target){
                return i;
            }
            else if(nums[i]>target){
                ub = i;
                end = i-1;
            }
            else{
                start = i+1;
            }
        }
        return ub;

    }

}
