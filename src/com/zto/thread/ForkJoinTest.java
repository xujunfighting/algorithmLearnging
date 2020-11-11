package com.zto.thread;

import java.util.concurrent.RecursiveTask;

/**
 * Created by xujun on 2019-01-24.
 */
public class ForkJoinTest {
    static class MyTask extends RecursiveTask{
        @Override
        protected Object compute() {
            return null;
        }
    }
}
