package lanqiao.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QueueHandle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> queue = new ArrayList<>();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int op = sc.nextInt();
            if(op == 1){
                queue.add(sc.nextInt());
            }else if (op == 2) {
                if(queue.isEmpty()){
                    System.out.println("no");
                    return;
                }else{
                    System.out.println(queue.get(0));
                    queue.remove(0);
                }
            }else{
                System.out.println(queue.size());
            }
        }
        sc.close();
    }
}
