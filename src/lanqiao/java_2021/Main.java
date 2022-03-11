package lanqiao.java_2021;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
// 1:无需package
// 2: 类名必须Main, 不可修改

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //在此输入您的代码...
        String day = "20220103";
        DateFormat df = new SimpleDateFormat("yyyyMMdd");
        try {
            Date date = df.parse(day);
            //“E”指定星期几这样的格式
            SimpleDateFormat s1=new SimpleDateFormat("E", Locale.ENGLISH);
            //将date转换成String
            String str02 = s1.format(date);
            System.out.println(str02);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        scan.close();
    }
    static int findMax(int[][] dp, int x, int y){
        int maxValue = Integer.MIN_VALUE;
        for(int i = 0; i <= 3; i++){
            for(int j = 0; j <= 3; j++){
                if(i == 0 && j == 0){
                    continue;
                }
                if(x - i >= 0 && y - j >= 0){
                    maxValue = Math.max(dp[x - i][y - j], maxValue);
                }
            }
        }
        return maxValue != Integer.MIN_VALUE ? maxValue : 0;
    }
    static boolean isLeapYear(int n){
        return (n % 400 == 0) || (n % 4 == 0 && n % 100 != 0);
    }

    static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    Map<String, String> weekMap(){
        String[] days = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        Map<String, String> map = new HashMap<>();
        for(int i = 0; i < 7; i++){
            map.put(days[i].substring(0, 3), days[i]);
        }
        return map;
    }
}