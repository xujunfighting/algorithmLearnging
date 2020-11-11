package com.zto.thread;

import java.util.Calendar;

/**
 * Created by xujun on 2018-07-26.
 */
public class RreaderResult  extends Thread{
    Calculator calculator;
    public RreaderResult(Calculator c){
        this.calculator=c;
    }
    public void run(){
        synchronized (calculator){
              System.out.println("等待计算结果");
            try {
                calculator.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("计算结果为:"+ calculator.total);
        }
    }
    public static  void main(String[] args){
        Calculator calculator=new Calculator();
        new RreaderResult(calculator).start();
        new RreaderResult(calculator).start();
        new RreaderResult(calculator).start();
        calculator.start();
    }
}
