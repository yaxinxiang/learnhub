package lanqiao.java_2020;

import java.util.Scanner;

public class Find2020 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        char[][] chars = new char[300][310];
        int res = 0;
        for (int i = 0; i < 300; i++) {
            chars[i] = scan.nextLine().toCharArray();
        }
            for(int i = 0; i < chars.length; i++){
            for (int j = 0; j < chars[0].length; j++) {
                if(chars[i][j] != '2'){
                    continue;
                }
                if(j + 3 < chars[0].length){
                    res += chars[i][j] == '2' && chars[i][j + 1] == '0' && chars[i][j + 2] == '2' && chars[i][j + 3] == '0' ? 1 : 0;
                }
                if(i + 3 < chars.length){
                    res += chars[i][j] == '2' && chars[i + 1][j] == '0' && chars[i + 2][j] == '2' && chars[i + 3][j] == '0' ? 1 : 0;
                }
                if(j + 3 < chars[0].length && i + 3 < chars.length){
                    res += chars[i][j] == '2' && chars[i + 1][j + 1] == '0' && chars[i + 2][j + 2] == '2' && chars[i + 3][j + 3] == '0' ? 1 : 0;
                }
            }
        }
        System.out.println(res);
        scan.close();
    }
}
