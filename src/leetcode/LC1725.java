package leetcode;

public class LC1725 {
    public int countGoodRectangles(int[][] rectangles) {
        int maxLen = 0, num = 0;
        for (int[] rectangle : rectangles) {
            int side = Math.min(rectangle[0], rectangle[1]);
            if (side > maxLen) {
                maxLen = side;
                num = 1;
            }else if (side == maxLen) {
                num++;
            }
        }
        return num;
    }
}
