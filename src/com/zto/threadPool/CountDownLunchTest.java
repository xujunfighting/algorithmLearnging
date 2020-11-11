package com.zto.threadPool;

import java.util.concurrent.CountDownLatch;

/**
 * Created by xujun on 2019-01-29.
 */
public class CountDownLunchTest implements Runnable{
    private String name;
    CountDownLatch countDownLatch;
    public CountDownLunchTest(String name,CountDownLatch countDownLatch){
        this.name=name;
        this.countDownLatch=countDownLatch;
    }
    public static void main(String[] args){
        CountDownLatch countDownLatch=new CountDownLatch(3);
        CountDownLunchTest test1=new CountDownLunchTest("线程1",countDownLatch);
        CountDownLunchTest test2=new CountDownLunchTest("线程2",countDownLatch);
        CountDownLunchTest test3=new CountDownLunchTest("线程3",countDownLatch);
        new Thread(test1).start();
        new Thread(test2).start();
        new Thread(test3).start();
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("开始上课");
    }

    @Override
    public void run() {
        System.out.println(name+"准备好了");
        countDownLatch.countDown();
    }
}
