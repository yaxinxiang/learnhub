package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LC22 {
    List<String> parenthesisList;
    public List<String> generateParenthesis(int n) {
        parenthesisList = new ArrayList<>();
        addParenthesis(n, n, new StringBuilder());
        return parenthesisList;
    }

    public void addParenthesis(int leftRes, int rightRes, StringBuilder sb){
        if(leftRes == 0 && rightRes == 0){
            parenthesisList.add(new String(sb.toString()));
        }
        if(leftRes > 0){
            sb.append("(");
            addParenthesis(leftRes - 1, rightRes, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
        if(rightRes > 0 && rightRes > leftRes){
            sb.append(")");
            addParenthesis(leftRes, rightRes - 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
