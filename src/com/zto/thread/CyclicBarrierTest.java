package com.zto.thread;

import java.util.concurrent.CyclicBarrier;

/**
 * Created by xujun on 2018-12-24.
 */
public class CyclicBarrierTest {
    public static void main(String[] args) {
       CyclicBarrier cyclicBarrier=new CyclicBarrier(4);
       new Thread(){
           @Override
           public void run() {
              System.out.println("线程1开始工作");
               try {
                   cyclicBarrier.await();
               } catch (Exception e) {
                   e.printStackTrace();
               }
               System.out.println("开始执行线程1的任务");
           }
       }.start();
        new Thread(){
            @Override
            public void run() {
                System.out.println("线程2开始工作");
                try {
                    cyclicBarrier.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println("开始执行线程2的任务");
            }
        }.start();
        new Thread(){
            @Override
            public void run() {
                System.out.println("线程3开始工作");
                try {
                    cyclicBarrier.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println("开始执行线程3的任务");
            }
        }.start();
        new Thread(){
            @Override
            public void run() {
                System.out.println("线程4开始工作");
                try {
                    cyclicBarrier.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println("开始执行线程4的任务");
            }
        }.start();
        System.out.print("主线程工作结束");
    }
}
