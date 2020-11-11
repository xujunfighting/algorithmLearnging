package com.zto.threadPool.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Author xujun
 * Create date 2019-02-25.
 * desc:
 */
public class AutomicTest {
    public static void main(String[] args) {
        AtomicInteger atomicInteger=new AtomicInteger();
        atomicInteger.addAndGet(1);
        System.out.println(atomicInteger.get());
    }

}
