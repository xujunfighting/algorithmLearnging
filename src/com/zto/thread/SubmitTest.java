package com.zto.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Author xujun
 * Create date 2019-08-01.
 * desc:
 */
public class SubmitTest {
    public static void main(String[] args) {
        List< Future<Boolean>> lists=new ArrayList<>();
        ExecutorService executorService= Executors.newFixedThreadPool(10);
        for(int i=0;i<10;i++){
            Future<Boolean> res=executorService.submit(new TaskRunnable());
            try {
                lists.add(res);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        try {
            for(int i=0;i<lists.size();i++) {
                boolean bool = lists.get(i).get();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("程序结束");
    }
    public  static class TaskRunnable implements Callable<Boolean>{
        public TaskRunnable() {
        }

        @Override
        public Boolean call() throws Exception {
            System.out.println("线程运行中");
            Thread.sleep(10000);
            return true;
        }
    }
}
