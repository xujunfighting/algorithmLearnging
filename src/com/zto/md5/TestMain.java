package com.zto.md5;

/**
 * Created by xujun on 2018-08-01.
 */
public class TestMain {
    public static void main(String[] args){
        String test="test";
        HashFunction function=new HashFunction();
        long result=function.hash(test);
        System.out.print(result);
    }
}
