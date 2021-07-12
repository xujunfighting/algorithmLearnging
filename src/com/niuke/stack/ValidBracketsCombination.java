package com.niuke.stack;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @version v1.0.0
 * @Description
 * @Author xujun
 * @Since 1.0
 * @Date 2021/7/9
 **/
public class ValidBracketsCombination {
    static List<String> lists=new ArrayList<>();
    static Set<String> sets=new HashSet<>();
    static int num=0;
    public static void main(String[] args) {
       getResult(3);
    }
    public static List<String> getResult(int n){
//        if(n==1){
//            List<String> lists=new ArrayList<>();
//            lists.add("()");
//            return lists;
//        }
//
//        String s="()";
//        method(s,n-1);
//        List<String> collect = sets.parallelStream().collect(Collectors.toList());
//        return collect;
        num=n;
        methodEnhance("",0,0);
        return lists;
    }
    public static void method(String sb,int n){
        if(n==0){
            sets.add(sb);
            return;
        }
        int len=sb.length();
        for(int i=1;i<=len;i++){
            String s=sb;
            String pre=sb.substring(0,i);
            String next=sb.substring(i,len);
            sb=pre+"()"+next;
            n--;
            method(sb,n);
            n++;
            sb=s;
        }
    }
    public static void methodEnhance(String sb,int left,int right){
        /**
         * 进行剪枝 左括号大于需要的个数 或者后括号大于需要的个数 以及右括号个数大于左括号的个数
         */
        if(left>num||right>num||right>left){
            return;
        }
        /**
         * 左右括号数满足当前需要的个数 将结果添加到结果集中 
         */
        if(left==num&&right==num){
            lists.add(sb);
            return;
        }

        methodEnhance(sb+"(",left+1,right);
        methodEnhance(sb+")",left,right+1);
    }
}
