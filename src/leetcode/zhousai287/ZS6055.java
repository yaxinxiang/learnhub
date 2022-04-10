package leetcode.zhousai287;

public class ZS6055 {
    public int convertTime(String current, String correct) {
        int cuH = (current.charAt(0)- '0') * 10 + current.charAt(1) - '0';
        int cuM = (current.charAt(3)- '0') * 10 + current.charAt(4) - '0';
        int coH = (correct.charAt(0)- '0') * 10 + correct.charAt(1) - '0';
        int coM = (correct.charAt(3)- '0') * 10 + correct.charAt(4) - '0';
        int res = 0;
        int tmpH = (coH - cuH);
        if(coM < cuM){
            coM += 60 - cuM;
            tmpH--;
        }else{
            coM -= cuM;
        }
        res += tmpH;
        while(coM > 0){
            if(coM >= 15){
                coM -= 15;
            }else if(coM >= 5){
                coM-= 5;
            }else{
                coM--;
            }
            res++;
        }
        return res;
    }
}
