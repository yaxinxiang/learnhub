package meituan.mt2021;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class MT03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int orderNum = sc.nextInt();
        int n = sc.nextInt();
        Order[] orders = new Order[orderNum];
        Order[] res = new Order[n];
        for (int i = 0; i < orderNum; i++) {
            int price = sc.nextInt() + 2 * sc.nextInt();
            orders[i] = new Order(i + 1, price);
        }
        Arrays.sort(orders, new Comparator<Order>() {
            @Override
            public int compare(Order o1, Order o2) {
                return o2.price - o1.price;
            }
        });
        System.arraycopy(orders, 0, res, 0, n);
        Arrays.sort(res, new Comparator<Order>() {
            @Override
            public int compare(Order o1, Order o2) {
                return o1.number - o2.number;
            }
        });
        for (int i = 0; i < n; i++) {
            System.out.println(res[i].number + " ");
        }
    }
}

class Order{
    int number;
    int price;

    public Order(int number, int price){
        this.number = number;
        this.price = price;
    }
}
