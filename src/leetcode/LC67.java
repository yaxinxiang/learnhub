package leetcode;

public class LC67 {
    //模拟算法：
    public String addBinary(String a, String b) {
        int plus = 0, posA = a.length() - 1, posB = b.length() - 1;
        StringBuilder sb = new StringBuilder();
        while(posA >= 0 || posB >= 0){
            int res = getNum(a, posA) + getNum(b, posB) + plus;
            sb.append(res % 2);
            plus = res > 1 ? 1 : 0;
            posA--;posB--;
        }
        if(plus > 0){
            sb.append(1);
        }
        return sb.reverse().toString();
    }
    public int getNum(String str, int pos){
        return pos >= 0 ? str.charAt(pos) - '0' : 0;
    }
}
