package com.leetcode;

/**
 * @author xujun
 * @date 2022-02-08
 **/
public class MaxDivisor {
    public static void main(String[] args) {
        int result = getResult(18, 4);
        System.out.println(result);
        System.out.println(18*4/result);

    }
    public static int getResult(int a,int b){
        while(b!=0) {
            int i=a%b;
            a=b;
            b=i;
        }
        return a;
    }
}

