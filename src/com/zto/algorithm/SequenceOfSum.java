package com.zto.algorithm;

/**
 * Created by xujun on 2018-11-07.
 */
public class SequenceOfSum {
    public static int sum=0;
    public static void main(String[] args){
        int start=1;
        int end=10;
        //int sum=0;
        //sum(start,end);
        int result=sum1(100);
        System.out.print(result);
    }
    public static void sum(int start,int end){
        if(start>end){
            return;
        }else{
            sum+=start;
             sum(++start,end);
        }
    }
    public static int sum1(int end){
        if(end==1){
            return 1;
        }else{
            return end+sum1(end-1);
        }
    }
}
