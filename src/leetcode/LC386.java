package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LC386 {
    List<Integer> orders;
    public List<Integer> lexicalOrder(int n) {
        orders = new ArrayList<>();
        search(0, 1, n);
        return orders;
    }

    public void search(int base, int head, int n){
        for (int i = head; i < 10; i++) {
            int num = base + i;
            if(num <= n){
                orders.add(num);
                if(num * 10 <= n){
                    search(num * 10, 0, n);
                }
            }
        }
    }
}
