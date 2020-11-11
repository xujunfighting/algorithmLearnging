package com.zto.thread;

import java.util.Random;

/**
 * Created by xujun on 2019-01-24.
 */
public class newTest {
    public static void main(String[] args) {
        int[] arr = new Random().ints(10).toArray();  //生成10个int范围类的个数。
        System.out.println(arr.length);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
