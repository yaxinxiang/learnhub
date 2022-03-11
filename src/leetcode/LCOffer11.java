package leetcode;

public class LCOffer11 {
    public int minArray(int[] numbers) {
        int left = 0, right = numbers.length - 1;
        while(left < right){
            int mid = left + (right - left) / 2;
            if(numbers[mid] > numbers[right]){
                left = mid + 1;
            }else if(numbers[mid] < numbers[right]){
                right = mid;
            }else{
                right--;
            }
        }
        return numbers[left];
    }
}
