package lanqiao.java_2020;

public class MakeDoorplate {
    public static void main(String[] args) {
        int res = 0;
        for (int i = 1; i < 2021; i++) {
            int x = i;
            while(x > 0){
                if(x % 10 == 2){
                    res++;
                }
                x /= 10;
            }
        }
        System.out.println(res);
    }
}
