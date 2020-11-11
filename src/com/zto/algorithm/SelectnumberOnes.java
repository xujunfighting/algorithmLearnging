package com.zto.algorithm;

/**
 * Created by xujun on 2018-08-27.
 */
public class SelectnumberOnes {
    public static void main(String[] args){
         int i=9;
         int result=selectones2(9);
         System.out.print(result);
    }
    public static int selectones(int n){
        int result=0;
        while(n!=0){
            result+=(n&1);
            n>>>=1;
        }
        return result;
    }
    public static  int selectones2(int n){
        int result=0;
        while(n!=0){
            result++;
            n=n&(n-1);
        }
        return result;
    }
}
