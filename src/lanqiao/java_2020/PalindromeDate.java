package lanqiao.java_2020;

import java.time.LocalDate;
import java.util.Scanner;

public class PalindromeDate {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int year = Integer.parseInt(str.substring(0, 4));
        int month = Integer.parseInt(str.substring(4, 6));
        int day = Integer.parseInt(str.substring(6, 8));
        LocalDate localDate = LocalDate.now();
        localDate = localDate.withYear(year);
        localDate = localDate.withMonth(month);
        localDate = localDate.withDayOfMonth(day);
        localDate = localDate.plusDays(1);
        boolean isFind = false;
        String a = "", b = "";
        while(true){
            String datestr = localDate.toString().replace("-", "");
            if(isPalindromeDate(datestr) && (!isFind)){
                isFind = true;
                a = datestr;
            }
            if(isABABBABA(datestr)){
                b = datestr;
                break;
            }
            localDate = localDate.plusDays(1);
        }
        System.out.println(a);
        System.out.println(b);
        sc.close();
    }

    static boolean isPalindromeDate(String date) {
        for (int i = 0; i < date.length() / 2; i++) {
            if (date.charAt(i) != date.charAt(date.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    static boolean isABABBABA(String date) {
        char[] c = date.toCharArray();
        return c[0] == c[2] && c[2] == c[5] && c[5] == c[7] && c[1] == c[3] && c[3] == c[4] && c[4] == c[6];
    }
}
