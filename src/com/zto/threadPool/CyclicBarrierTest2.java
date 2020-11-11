package com.zto.threadPool;

import java.io.IOException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by xujun on 2019-01-29.
 */
public class CyclicBarrierTest2 {

    public static void main(String[] args) throws IOException, InterruptedException {
        //如果将参数改为4，但是下面只加入了3个选手，这永远等待下去
        //Waits until all parties have invoked await on this barrier.
        Thread thread=new Thread(){
            @Override
            public void run() {
                System.out.println("集体开跑");
            }
        };
        CyclicBarrier barrier = new CyclicBarrier(3,thread);

        ExecutorService executor = Executors.newFixedThreadPool(3);

        executor.submit(new Thread(new Runner(barrier, "1号选手")));
        executor.submit(new Thread(new Runner(barrier, "2号选手")));
        executor.submit(new Thread(new Runner(barrier, "3号选手")));

//        try {
//            barrier.await();
//        } catch (BrokenBarrierException e) {
//            e.printStackTrace();
//        } finally {
//        }
        executor.shutdown();
    }
}

