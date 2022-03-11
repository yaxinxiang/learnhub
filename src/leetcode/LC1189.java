package leetcode;

import java.util.Arrays;

public class LC1189 {
    public int maxNumberOfBalloons(String text) {
        int[] num = new int[5];
        for (char ch: text.toCharArray()) {
            if(ch == 'b'){
                num[0]++;
            } else if(ch == 'a'){
                num[1]++;
            } else if(ch == 'l'){
                num[2]++;
            } else if(ch == 'o'){
                num[3]++;
            } else if(ch == 'n'){
                num[4]++;
            }
        }
        num[2] /= 2;
        num[3] /= 2;
        return Arrays.stream(num).min().getAsInt();
    }
}
