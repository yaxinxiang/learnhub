package leetcode;

public class LC1405 {
    public String longestDiverseString(int a, int b, int c) {
        int[] arr = new int[]{a, b, c};
        StringBuffer sb = new StringBuffer();
        boolean isRun = true;
        int max;
        int min;
        int mid;
        int last = 3;
        while(isRun){
            isRun = false;
            max = Math.max(arr[0], Math.max(arr[1], arr[2]));
            min = Math.min(arr[0], Math.min(arr[1], arr[2]));
            mid = arr[0] + arr[1] + arr[2] - max - min;
            if(max == 0){
                isRun = false;
                break;
            }
            for (int i = 0; i < 3; i++) {
                if (max == arr[i] && last != i){
                    int flag = 2;
                    while(flag > 0 && arr[i] > 0){
                        sb.append((char)(i + 97));
                        flag--;
                        arr[i]--;
                    }
                    isRun = true;
                    last = i;
                    break;
                }
            }
            if (!isRun){
                if(mid == 0){
                    break;
                }
                for (int i = 0; i < 3; i++) {
                    if (mid == arr[i] && last != i){
                        int flag = 1;
                        while(flag > 0 && arr[i] > 0){
                            sb.append((char)(i + 97));
                            flag--;
                            arr[i]--;
                        }
                        isRun = true;
                        last = i;
                        break;
                    }
                }
            }
        }
        return sb.toString();
    }
}
