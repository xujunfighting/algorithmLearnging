package com.zto.thread;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * Created by xujun on 2019-01-24.
 */
public class RecursiveTaskTest {
    static class Sum extends RecursiveTask<Long> {
        public static long sum(int[] array) {
            return ForkJoinPool.commonPool().invoke(new Sum(array, 0, array.length));
        }

        private final int[] array;
        private final int lo, hi;

        private Sum(int[] array, int lo, int hi) {
            this.array = array;
            this.lo = lo;
            this.hi = hi;
        }

        private static final int THRESHOLD = 600;

        @Override
        protected Long compute() {
            if (hi - lo < THRESHOLD) {
                return sumSequentially();
            } else {
                int middle = (lo + hi) >>> 1;
                Sum left = new Sum(array, lo, middle);
                Sum right = new Sum(array, middle, hi);
                right.fork();
                //left.fork();
                long leftAns = left.compute();
                long rightAns = right.compute();
                // 注意subTask2.fork要在subTask1.compute之前
                // 因为这里的subTask1.compute实际上是同步计算的
                return leftAns + rightAns;
            }
        }

        private long sumSequentially() {
            long sum = 0;
            for (int i = lo; i < hi; i++) {
                sum += array[i];
            }
            return sum;
        }
    }

    public static void main(String[] args) {
        int[] array =new int[103];
        for(int i=0;i<array.length;i++){
            array[i]=i+1;
        }
        Long sum = Sum.sum(array);
        System.out.println(sum);
    }
}

