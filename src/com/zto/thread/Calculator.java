package com.zto.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by xujun on 2018-07-26.
 */
public class Calculator extends Thread {
     int total;
     public void run(){
         synchronized (this){
             for(int i=0;i<101;i++){
                 total+=i;
             }
         }
         Lock lock=new ReentrantLock();
         lock.lock();
         notifyAll();
     }
}
