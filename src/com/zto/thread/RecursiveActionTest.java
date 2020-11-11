package com.zto.thread;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

/**
 * Created by xujun on 2019-01-24.
 */
public class RecursiveActionTest {
    static class Sorter extends RecursiveAction {
        public static void sort(int[] array) {
            ForkJoinPool.commonPool().invoke(new Sorter(array, 0, array.length));
        }

        private final int[] array;
        private final int lo, hi;

        private Sorter(int[] array, int lo, int hi) {
            this.array = array;
            this.lo = lo;
            this.hi = hi;
        }

        private static final int THRESHOLD = 2;

        protected void compute() {
            // 数组长度小于1000直接排序
            if (hi - lo < THRESHOLD)
                Arrays.sort(array, lo, hi);
            else {
                int mid = (lo + hi)/2;
                // 数组长度大于1000，将数组平分为两份
                // 由两个子任务进行排序
                Sorter left = new Sorter(array, lo, mid);
                Sorter right = new Sorter(array, mid, hi);
                invokeAll(left, right);
                // 排序完成后合并排序结果
                merge(lo, mid, hi);
            }
        }

        private void merge(int lo, int mid, int hi) {
            int[] buf = Arrays.copyOfRange(array, lo, mid);
            for (int i = 0, j = lo, k = mid; i < buf.length; j++) {
                if (k == hi || buf[i] < array[k]) {
                    array[j] = buf[i++];
                } else {
                    array[j] = array[k++];
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] array=new int[100];
        for(int i=0;i<array.length;i++){
            array[i]=(int) (Math.random() * 100);
        }
        Sorter.sort(array);
        System.out.println(Arrays.toString(array));
    }
}

