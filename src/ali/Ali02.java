package ali;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Ali02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        Map<Integer, int[]> row = new HashMap<>();
        Map<Integer, int[]> lin = new HashMap<>();
        int[][] nums = new int[n][m];
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                nums[i][j] = sc.nextInt();
                if(nums[i][j] == 1){
                    int[] tmp1 = row.getOrDefault(i, new int[m]);
                    tmp1[j] = 1;
                    row.put(1, tmp1);

                    int[]tmp2 = lin.getOrDefault(j, new int[n]);
                    tmp2[i] = 1;
                    lin.put(j, tmp2);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(nums[i][j] == 0){
                    for (int k = 0; k < m; k++) {
                        if(k < j && row.get(i)[k] == 1){
                            res++;
                            k = j;
                        }
                        if(k > j && row.get(i)[k] == 1){
                            res++;
                            break;
                        }
                    }
                    for (int k = 0; k < n; k++) {
                        if(k < i && lin.get(j)[k] == 1){
                            res++;
                            k = i;
                        }
                        if(k > i && lin.get(j)[k] == 1){
                            res++;
                            break;
                        }
                    }
                }
            }
        }
        System.out.println(res);
        sc.close();
    }
}
