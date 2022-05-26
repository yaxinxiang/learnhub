package lanqiao.java_2013;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class LC1441 {
    public static void main(String[] args) {
        int res = 0;
        List<Integer> list = new ArrayList<>(Arrays.asList(0));
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt(), n = sc.nextInt();
        for (int i = 1; i < n; i++) {
            if(i % 2 != 0){
                list.add(i);
            }
        }
        int pos = 2;//最后一个幸运数下标位置
        while(true){
            List<Integer> tmp = new ArrayList<>(Arrays.asList(0));
            int last = list.get(pos);
            for(int i = 1; i <= pos; i++){
                tmp.add(list.get(i));
            }
            for (int i = pos + 1; i < list.size(); i++) {
                if(i % last != 0){
                    tmp.add(list.get(i));
                }
            }
            list = tmp;
            pos++;
            if(pos >= list.size()){
                break;
            }
        }
        for(int i = list.size() - 1; i >= 1; i--){
            int num = list.get(i);
            if(num <= m){
                break;
            }
            res++;
        }
        System.out.println(res);
        sc.close();
    }
}
