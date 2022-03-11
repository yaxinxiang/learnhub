package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LC1414 {
    public int findMinFibonacciNumbers(int k) {
        int a = 1, b = 1, res = 0;
        List<Integer> fibonaccis = new ArrayList<>();
        fibonaccis.add(1);
        while(b <= k){
            fibonaccis.add(b);
            int tmp = b;
            b = a + b;
            a = tmp;
        }
        while(k > 0){
            int num = fibonaccis.get(fibonaccis.size() - 1);
            if(k >= num){
                res++;
                k -= num;
            }
            fibonaccis.remove(fibonaccis.size() - 1);
        }
        return res;
    }
}
