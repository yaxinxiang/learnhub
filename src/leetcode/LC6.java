package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LC6 {
    public String convert(String s, int numRows) {
        if(numRows < 2){
            return s;
        }
        List<StringBuilder> list = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            list.add(new StringBuilder());
        }
        int i = 0, flag = -1;
        for(char ch : s.toCharArray()){
            list.get(i).append(ch);
            if(i == 0 || i == numRows - 1){
                flag = -flag;
            }
            i += flag;
        }
        StringBuilder sb = new StringBuilder();
        for (StringBuilder tmp: list) {
            sb.append(tmp);
        }
        return sb.toString();
    }
}
