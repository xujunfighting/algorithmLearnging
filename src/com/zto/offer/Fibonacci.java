package com.zto.offer;

/**
 * Created by xujun on 2018-11-28.
 */
public class Fibonacci {
    public static void main(String[] args){
        int result=getResult1(10);
        System.out.print(result);
    }
    public static int getResult(int n){
        if(n==1||n==2){
            return 1;
        }
        return getResult(n-1)+getResult(n-2);
    }
    public static int getResult1(int n){
        if(n==1||n==2){
            return 1;
        }
        int result=0;
        int pre1=1;
        int pre2=1;
        for(int i=3;i<=n;i++){
            result=pre1+pre2;
            pre1=pre2;
            pre2=result;
        }
        return  result;
    }
}
