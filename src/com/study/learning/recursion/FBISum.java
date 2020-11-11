package com.study.learning.recursion;

/**
 * Author xujun
 * Create date 2020-01-01.
 * desc:
 */
public class FBISum {
    public static void main(String[] args) {
       int res = getSum(4);
        System.out.println(res);
    }
    public static int getSum(int n){
        if(n==1||n==2){
            return 1;
        }
        return getSum(n-1)+getSum(n-2);
    }
}
