package lanqiao.java_2021;

public class Card {
    public static void main(String[] args) {
        int[] nums = new int[11];
        int sum = 0;
        for(int i = 0; i < 10; i++){
            nums[i] = 2021;
        }
        for(int i = 1; i < 20210; i++){
            int tmp = i;
            boolean flag = true;
            while(tmp > 0 && flag){
                int pos = tmp % 10;
                tmp /= 10;
                if(--nums[pos] < 0){
                    flag = false;
                }
            }
            if(!flag){
                break;
            }
            sum += 1;
        }
        System.out.println(sum);
    }
}


