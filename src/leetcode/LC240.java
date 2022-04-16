package leetcode;

public class LC240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int tail = matrix[0].length - 1;
        for (int[] arr : matrix){
            if(arr[tail] < target){
                continue;
            }else{
                if(isContains(arr, target)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isContains(int[] arr, int target){
        int left = 0, right = arr.length - 1;
        while(left <= right){
            int mid = left + (right - left)>>1;
            if(arr[mid] == target){
                return true;
            }else if(arr[mid] > target){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return false;
    }
}
