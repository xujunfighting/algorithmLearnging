package com.zto.thread;

import java.util.concurrent.CountDownLatch;

/**
 * Created by xujun on 2018-12-24.
 */
public class CountDownLunchTest {
    public static int v=0;
    public static void main(String[] args){
        CountDownLatch countDownLatch=new CountDownLatch(5);
        for(int i=0;i<5;i++){
            Thread thread=new Thread(){
                @Override
                public void run() {
                    v++;
                  System.out.println("工作编号"+v);
                  countDownLatch.countDown();
                  System.out.println("线程"+v+"结束");
                }
            };
            thread.start();
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.print("主线程工作结束");
    }
}
