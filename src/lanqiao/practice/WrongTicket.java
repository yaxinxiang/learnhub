package lanqiao.practice;

import java.util.*;

public class WrongTicket {
    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        Scanner sc = new Scanner(System.in);
        int lines = Integer.parseInt(sc.nextLine());
        while (lines-- > 0){
            String s = sc.nextLine();
            String[] arr = s.split(" ");
            for (String s1 : arr){
                int num = Integer.parseInt(s1);
                min = Math.min(num, min);
                max = Math.max(num, max);
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
        }
        int m = -1, n = -1;
        for (Integer num : map.keySet()){
            if(num != min && map.getOrDefault(num - 1, 0) == 0){
                m = num - 1;
            }
            if(num != max && map.getOrDefault(num + 1, 0) == 0){
                m = num + 1;
            }
            if(map.get(num) > 1){
                n = num;
            }
        }
        System.out.println(m + " " + n);
        sc.close();
    }
}
