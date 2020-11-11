package com.zto.future;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * Created by xujun on 2019-01-28.
 */
public class RealMain {
    public static void main(String[] args) {
        FutureTask<String> future = new FutureTask<String>(new RealData("liangyongxing"));
        ExecutorService executor = Executors.newFixedThreadPool(1);    // 使用线程池
        //执行FutureTask，相当于上例中的client.request("name")发送请求
        //在这里开启线程进行RealData的call()执行
        executor.submit(future);
        System.out.println("请求完毕");

        try {
            // 这里仍然可以做额外的数据操作，这里使用sleep代替其他业务逻辑的处理
            Thread.sleep(2000);

            /**
             * 相当于上例当中的 data.getResult()，取得call()方法的返回值
             * 如果此时call()方法没有执行完毕，则依然会等待
             */
            System.out.println("数据 = " + future.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }
    }
}
