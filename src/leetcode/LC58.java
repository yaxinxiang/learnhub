package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LC58 {
    public String compressString(String S) {
        StringBuilder sb = new StringBuilder();
        char pre = 0;
        int num = 0, len = S.length();
        for (int i = 0; i <= len; i++) {
            char ch = i < len ? S.charAt(i) : 1;
            if(ch != pre){
                if(pre != 0){
                    sb.append(pre);
                    sb.append(num);
                }
                pre = ch; num = 1;
            }else {
                num++;
            }
        }
        if(sb.length() < len){
            return sb.toString();
        }
        return S;
    }
}
