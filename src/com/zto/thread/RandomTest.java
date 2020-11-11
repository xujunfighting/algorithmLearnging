package com.zto.thread;

/**
 * Created by xujun on 2019-01-24.
 */
public class RandomTest {
    public static void main(String[] args){
        int[] array=new int[100];
        for (int i=0;i<array.length;i++){
            array[i]=(int) (Math.random() * 100);
            System.out.println(array[i]);
        }
    }
}
