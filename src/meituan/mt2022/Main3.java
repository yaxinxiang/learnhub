package meituan.mt2022;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

//18%AC
public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int n = Integer.parseInt(s.substring(0, 1));
        int maxL = n, maxW = n, maxH = n;
        List<Integer> x = new ArrayList<>(); x.add(0);x.add(n);
        List<Integer> y = new ArrayList<>(); y.add(0);y.add(n);
        List<Integer> z = new ArrayList<>(); z.add(0);z.add(n);
        int m = Integer.parseInt(s.substring(2, 3));
        char[] chars = new char[m];
        for(int i = 0; i < m; i++){
            chars[i] = sc.next().charAt(0);
        }

        for (int i = 0; i < m; i++) {
            int pos = n - sc.nextInt();
            if(chars[i] == 'x'){
                maxL = getMaxL(n, x, pos);
            }
            if(chars[i] == 'y'){
                maxW = getMaxL(n, y, pos);
            }
            if(chars[i] == 'z'){
                maxH = getMaxL(n, z, pos);
            }
            System.out.println(maxL * maxW * maxH);
        }
        sc.close();
    }

    private static int getMaxL(int n, List<Integer> list, int pos) {
        int maxL;
        list.add(pos);
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        maxL = findMax(list) == -1 ? n : findMax(list);
        return maxL;
    }

    public static int findMax(List<Integer> list){
        int res = -1;
        for(int i = 1; i < list.size(); i++){
            res = Math.max(res, list.get(i) - list.get(i - 1));
        }
        return res;
    }
}
