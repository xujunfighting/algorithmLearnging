package com.zto.threadPool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by xujun on 2019-01-28.
 */
public class ThreadPoolTest1 {
    public static void main(String[] args){
//        Lock lock=new ReentrantLock();
//        lock.lock();
        ExecutorService service= new ThreadPoolExecutor(2,3,3, TimeUnit.SECONDS,new ArrayBlockingQueue<Runnable>(2),new ThreadPoolExecutor.CallerRunsPolicy());
        service.submit(new MyThread("1"));// 1 2 3 4 5 6
        service.submit(new MyThread("2"));
        service.submit(new MyThread("3"));
        service.submit(new MyThread("4"));
        service.submit(new MyThread("5"));
        service.submit(new MyThread("6"));
        service.shutdown();
    }
}
