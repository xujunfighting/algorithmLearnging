package com.niuke;

/**
 * @Description
 * @Author xujun
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/12/4
 */
public class JudgeString {
    public static void main(String[] args) {
        String res="abba";
        boolean result = getResult(res);
        System.out.println(result);

    }
    public static boolean getResult(String res){
        boolean result=true;
        char[] chars = res.toCharArray();
        int start=0;
        int end=chars.length-1;
        while(start<end){
            if(chars[start]==chars[end]){
                start++;
                end--;
            }else{
                return false;
            }
        }
        return result;
    }
}
