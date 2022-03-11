package leetcode;

public class LC717 {
    public boolean isOneBitCharacter(int[] bits) {
        int head = 0, tail = bits.length - 1;
        while(head < tail){
            head += bits[head] + 1;
        }
        return head == tail;
    }
}
