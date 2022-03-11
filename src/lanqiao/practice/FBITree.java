package lanqiao.practice;

import java.util.Scanner;

public class FBITree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        s = sc.nextLine();
        printNode(s);
        sc.close();
    }

    public static void printNode(String s){
        if(s.length() > 1){
            printNode(s.substring(0, s.length()/2));
            printNode(s.substring(s.length()/2));
        }

        if(s.contains("1") && s.contains("0")){
            System.out.print("F");
        }else if(s.contains("0")){
            System.out.print("B");
        }else{
            System.out.print("I");
        }
    }
}

class TreeNode{
    char val;
    TreeNode left;
    TreeNode right;
    public TreeNode(char val){
        this.val = val;
    }
}
