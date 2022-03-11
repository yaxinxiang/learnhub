package leetcode;

import java.util.Stack;

public class CQueue {
    Stack<Integer> stackOne;
    Stack<Integer> stackTwo;
    public CQueue() {
        this.stackOne = new Stack<>();
        this.stackTwo = new Stack<>();
    }

    public void appendTail(int value) {
        stackOne.push(value);
    }

    public int deleteHead() {
        if(stackOne.isEmpty()){
            return -1;
        }
        while (stackOne.size() > 1){
            stackTwo.push(stackOne.pop());
        }
        int res = stackOne.pop();
        while(!stackTwo.isEmpty()){
            stackOne.push(stackTwo.pop());
        }
        return res;
    }
}
