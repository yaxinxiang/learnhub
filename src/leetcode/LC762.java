package leetcode;

public class LC762 {
    public int countPrimeSetBits(int left, int right) {
        int res = 0;
        for(int i = left; i <= right; i++){
            res += count(i);
        }
        return res;
    }

    public int count(int n){
        int bit = 0;
        while(n > 0){
            bit += (n & 1);
            n >>= 1;
        }
        if(bit < 2){
            return 0;
        }
        for(int i = 2; i < Math.sqrt(bit); i++){
            if(bit % i == 0){
                return 0;
            }
        }
        return 1;
    }
}
