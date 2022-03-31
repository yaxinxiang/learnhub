package leetcode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class LC739 {
    public int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        int[] ans = new int[len];
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < len; i++) {
            int tmp = temperatures[i];
            while(!stack.isEmpty() && tmp > temperatures[stack.peek()]){
                ans[stack.peek()] = i - stack.pop();
            }
            stack.push(i);
        }
        return ans;
    }
}
