package leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class LC155 {
    Deque<Integer> stack;
    Deque<Integer> mStack;

    public LC155() {
        this.stack = new LinkedList<>();
        this.mStack = new LinkedList<>();
        mStack.push(Integer.MAX_VALUE);
    }

    public void push(int val) {
        stack.push(val);
        mStack.push(Math.min(mStack.peek(), val));
    }

    public void pop() {
        stack.pop();
        mStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return mStack.peek();
    }
}
