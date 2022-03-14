package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 在数字中加.返回所有可能的ip
 */
public class LC93 {
    List<String> ipList;
    public List<String> restoreIpAddresses(String s) {
        ipList = new ArrayList<>();
        if(s.length() > 12){
            return ipList;
        }
        makeIp(s, 3);
        return ipList;
    }

    public void makeIp(String s, int resPoint){
        if(resPoint == 0){
            if(isIPValid(s)){
                ipList.add(new String(s));
            }
            return;
        }
        for (int i = s.lastIndexOf(".") + 1; i < s.length(); i++) {
            if(isNumValid(s.substring(s.lastIndexOf(".") + 1, i + 1))){
                makeIp(s.substring(0, i + 1) + "." + s.substring(i + 1, s.length()), resPoint - 1);
            }
        }
    }
    public boolean isIPValid(String ip){
        if(ip.charAt(0) == '.' || ip.charAt(ip.length() - 1) == '.'){
            return false;
        }
        String[] res = ip.split("\\.");
        if(res.length < 4){
            return false;
        }
        for(String s : res){
            if(!isNumValid(s)){
                return false;
            }
        }
        return true;
    }

    public boolean isNumValid(String s){
        if(s.length() > 3){
            return false;
        }
        int num = Integer.parseInt(s);
        if((num + "").length() < s.length()){
            return false;
        }
        return num <= 255;
    }
}
