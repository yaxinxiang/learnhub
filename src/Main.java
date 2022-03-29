import java.util.ArrayList;
import java.util.List;

/**
 *题目：根据一个字符串的字符组恒，生成其所有可能的字符串。
 * 例如，输入字符串abc，则输出由字符a、b、c 所能排列出来的所有字符串abc、acb、bac、bca、cab 和cba。
 */

public class Main{
    static List<String> list = new ArrayList<>();
    static boolean[] vis;
    public static void main(String[] args){
        String s = "abc";
        vis = new boolean[s.length()];
        soutString(s, 0, "");
        for(String s1 : list){
            System.out.println(s1);
        }
    }
    public static void soutString(String s, int pos, String d){
        if(pos == s.length()){
            list.add(d);
            return;
        }
        for(int i = 0; i < s.length(); i++){
            if(!vis[i]){
                vis[i] = true;
                d += s.substring(i, i + 1);
                soutString(s,pos+1, d);
                vis[i] = false;
                d = d.substring(0, d.length() -1);
            }
        }
    }
}