package leetcode;

public class LC796 {
    public boolean rotateString(String s, String goal) {
        char first = goal.charAt(0);
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == first){
                boolean flag = true;
                for (int j = 0; j < goal.length(); j++) {
                    if(goal.charAt(j) != s.charAt((j + i) % s.length())){
                        flag = false;
                        break;
                    }
                }
                if(flag){
                    return true;
                }
            }
        }
        return false;
    }
}
