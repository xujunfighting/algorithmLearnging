package com.zto.algorithm;

/**
 * Created by xujun on 2018-08-30.
 */
public class ContainOnceTest {
    public static void main(String[] args){
        int[] res={1,1,2,3,3,4,4};
        int result=fun(res);
        System.out.print(result);
    }
    public  static int fun(int[] res){
        int sum=0;
        for(int i:res){
         sum=sum^i;
        }
        return sum;
    }
}
