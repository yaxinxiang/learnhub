package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LC447 {
    public List<String> simplifiedFractions(int n) {
        List<String> list = new ArrayList<>();
        for (int i = 2; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if(gcd(j, i) == 1){
                    list.add(j + "/" + i);
                }
            }
        }
        return list;
    }

    public int gcd(int a, int b){
        return b == 0 ? a : gcd(b, a % b);
    }
}
