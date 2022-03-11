package leetcode;

public class LC258 {
    public int addDigits(int num) {
        while(num > 9){
            int tmp = 0;
            while(num > 0){
                tmp += num % 10;
                num /= 10;
            }
            num = tmp;
        }
        return num;
    }

    //公式：
    public int addDigits1(int num){
        return (num - 1) % 9 + 1;
    }
}
