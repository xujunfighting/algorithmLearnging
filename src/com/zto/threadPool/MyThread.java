package com.zto.threadPool;

/**
 * Created by xujun on 2019-01-28.
 */
public class MyThread implements Runnable {
    private String name;
    public MyThread(String name){
        this.name=name;
    }
    @Override
    public void run() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("当前线程名称为："+name);
    }
}
