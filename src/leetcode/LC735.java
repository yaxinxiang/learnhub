package leetcode;

import java.util.ArrayDeque;

/**
 * @author Yaxin
 * @date 2022/7/14 8:41
 */
public class LC735 {
    public int[] asteroidCollision(int[] asteroids) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (Integer star : asteroids) {
            boolean alive = true;
            while(alive && star < 0 && !stack.isEmpty() && stack.peek() > 0){
                alive = stack.peek() < -star;
                if(stack.peek() <= -star){
                    stack.pop();
                }
            }
            if(alive){
                stack.push(star);
            }
        }
        int[] res = new int[stack.size()];
        for (int i = stack.size() - 1; i > -1; i--) {
            res[i] = stack.pop();
        }
        return res;
    }
}
