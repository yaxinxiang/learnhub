package leetcode;

public class LC34 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int res = -1, len = gas.length;
        int pos = 0;
        while (pos < len) {
            int sumGas = 0, needGas = 0;
            int i;
            for (i = 0; i < len; i++) {
                int j = (i + pos) % len;
                sumGas += gas[j];
                needGas += cost[j];
                if (sumGas < needGas) {
                    break;
                }
            }
            if (i == len) {
                res = pos;
                break;
            } else {
                pos = pos + i;
            }
        }
        return res;
    }
}
