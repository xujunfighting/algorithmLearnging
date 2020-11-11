package com.study.learning.dynamicProgramming;

/**
 * Author xujun
 * Create date 2020-01-02.
 * desc:
 */
public class FBISum1 {
    public static void main(String[] args) {
        int res = getSum(4);
        System.out.println(res);
    }
    public static int getSum(int n){
        if(n==1||n==2){
            return 1;
        }
        int a=1;
        int b=1;
        int sum=0;
        for(int i=2;i<n;i++){
            sum=a+b;
            a=b;
            b=sum;
        }
        return sum;
    }
}
