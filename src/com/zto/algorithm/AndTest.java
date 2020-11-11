package com.zto.algorithm;

/**
 * Created by xujun on 2018-08-23.
 */
public class AndTest {
    public static void main(String[] args){
        int[] a={1,1,1,1,2,1,1};
        int result=0;
        for(int i:a){
            result=result&i;
        }
        System.out.print(result);
    }
}
