package com.zto.offer;

/**
 * Created by xujun on 2018-11-28.
 */
public class DataContainsOne {
    public static void main(String[] args){

        System.out.print( method1(5));
    }
    public static int method(int res){
        int result=0;
        while(res!=0){
            System.out.println("----");
            result+=res&1;
            res=res>>1;
        }
        return result;
    }
    public static int method1(int res){
        int result=0;
        while(res!=0){
            result++;
            res=res&(res-1);
            System.out.println(res+" ");
        }
        return result;
    }
}
