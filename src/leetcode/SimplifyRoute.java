package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class SimplifyRoute {
    public String simplifyPath(String path) {
        String[] names = path.split("/");
        Deque<String> deque = new ArrayDeque<>();
        for(String s : names){
            if(s.equals("") || s.equals(".")){
                continue;
            }
            if(s.equals("..") && deque.size() > 0){
                deque.removeLast();
            }else{
                deque.offerLast(s);
            }
        }
        String res = "";
        while(deque.size() > 0){
            res = res + "/" + deque.pollFirst();
        }
        return res.equals("") ? "/" : res;
    }
}
