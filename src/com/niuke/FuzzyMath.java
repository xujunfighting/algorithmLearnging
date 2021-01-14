package com.niuke;

/**
 * @Description
 * @Author xujun
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2021/1/13
 */
public class FuzzyMath {
    public static void main(String[] args) {
       //? 匹配单个字符
       // *匹配任意长度字符
    }
    public static boolean isMatch(String s,String p){
        boolean result=false;
        //数据长度不相等 且没有包含*
        //模糊字符串长度大于当前字符串长度
        if(s.length()!=p.length()&&!p.contains("*")||s.length()<p.length()&&!p.contains("*")){
            return false;
        }
        //s.length>=p.length;
        //最大*匹配长度
        int dif=s.length()-p.length();
        return result;
    }
}
