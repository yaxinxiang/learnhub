package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LC77 {
    List<List<Integer>> res;
    public List<List<Integer>> combine(int n, int k) {
        res = new ArrayList<>();
        search(1, n, k, new ArrayList<>());
        return res;
    }

    public void search(int pos, int n, int k, List<Integer> list){
        if(list.size() == k){
            res.add(new ArrayList<>(list));
            return;
        }
        if(list.size() + n - pos + 1 < k){
            return;
        }
        list.add(pos);
        search(pos + 1, n, k, list);
        list.remove(list.size() - 1);

        search(pos + 1, n, k, list);
    }
}
