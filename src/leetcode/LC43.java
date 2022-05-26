package leetcode;

public class LC43 {
    public String multiply(String num1, String num2) {
        if(num1.length() < num2.length()){
            String tmp = num1; num1 = num2; num2 = tmp;
        }
        if(num2.equals("0")){
            return "0";
        }
        int len2 = num2.length();
        String[] nums = new String[len2];
        for (int i = len2 - 1; i >= 0 ; i--) {
            nums[i] = multi(num1, num2.charAt(i) - '0', len2 - 1 - i);
        }
        return addStrings(nums);
    }

    public String multi(String num, int n, int append){
        StringBuffer sb = new StringBuffer("");
        for (int i = 0; i < append; i++) {
            sb.append("0");
        }
        int plus = 0;
        for (int i = num.length() - 1; i >= 0; i--) {
            int a = num.charAt(i) - '0';
            int b = a * n + plus; plus = b / 10;
            sb.append((b % 10));
        }
        if(plus > 0){
            sb.append(plus);
        }
        return sb.reverse().toString();
    }

    /**
     * 多数相加
     * @param nums 要相加的String数组
     * @return
     */
    public String addStrings(String[] nums){
        String sum = "";
        for (String num : nums){
            sum = addString(num, sum);
        }
        return sum;
    }

    /**
     * 两数相加（字符串）
     * @param num1 整数1
     * @param num2 整数2
     * @return 两数之和
     */
    public String addString(String num1, String num2){
        int plus = 0;
        int pos1 = num1.length() - 1, pos2 = num2.length() - 1;
        StringBuffer sb = new StringBuffer("");
        while(pos1 >= 0 || pos2 >= 0){
            int a = pos1 >= 0 ? num1.charAt(pos1--) - '0' : 0;
            int b = pos2 >= 0 ? num2.charAt(pos2--) - '0' : 0;
            int c = a + b + plus; plus = c / 10;
            sb.append((c % 10));
        }
        if(plus > 0){
            sb.append(1);
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String a = "11111", b = "22222222222";
        System.out.println(new LC43().multiply(a, b));
        System.out.println(new LC43().multiplyPlus(a, b));
        System.out.println(new LC43().multiplyPlus2(a, b));
    }

    public String multiplyPlus(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")){
            return "0";
        }
        int[] nums = new int[num1.length() + num2.length()];
        for (int i = 0; i < num1.length(); i++) {
            int a = num1.charAt(i) - '0';
            for (int j = 0; j < num2.length(); j++) {
                int b = num2.charAt(j) - '0';
                nums[i + j + 1] += a * b;
            }
        }
        for (int i = nums.length - 1; i > 0; i--) {
            nums[i - 1] += nums[i] / 10;
            nums[i] %= 10;
        }
        int pos = nums[0] == 0 ? 1 : 0;
        StringBuilder sb = new StringBuilder();
        while(pos < nums.length){
            sb.append(nums[pos++]);
        }
        return sb.toString();
    }

    public String multiplyPlus2(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")){
            return "0";
        }
        int len1 = num1.length(), len2 = num2.length();
        int[] nums = new int[len1 + len2];
        for (int i = len1 - 1; i >= 0; i--) {
            int a = num1.charAt(i) - '0';
            for (int j = len2 - 1; j >= 0; j--) {
                int b = num2.charAt(j) - '0';
                int sum = nums[i + j + 1] + a * b;
                nums[i + j + 1] = sum % 10;
                nums[i + j] += sum / 10;
            }
        }
        int pos = nums[0] == 0 ? 1 : 0;
        StringBuilder sb = new StringBuilder();
        while(pos < nums.length){
            sb.append(nums[pos++]);
        }
        return sb.toString();
    }
}
