package com.zto.solution;

/**
 * Author xujun
 * Create date 2019-03-02.
 * desc:
 */
public class Solution {
    public static void main(String[] args) {

    }
    public String replaceSpace(StringBuffer str) {
        int n=0;
        StringBuffer sb=new StringBuffer();
        char[] chars=str.toString().toCharArray();
        for(int i=0;i<chars.length;i++){
            if(String.valueOf(chars[i]).trim().equals("")){
                sb.append("%20");
            }else{
                sb.append(String.valueOf(chars[i]));
            }
        }
        return sb.toString();
    }
}
