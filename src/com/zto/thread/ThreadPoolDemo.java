package com.zto.thread;

/**
 * Author xujun
 * Create date 2019-04-28.
 * desc:
 */
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class ThreadPoolDemo {

    static class WorkThread implements Runnable {
        private String command;

        public WorkThread(String command) {
            this.command = command;
        }

        @Override
        public void run() {
            System.out.println("Thread-" + Thread.currentThread().getId() + " start. Command=" + command);
            processCommand();
            System.out.println("Thread-" + Thread.currentThread().getId() + " end.");
        }

        private void processCommand() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        for (int i = 0; i < 10; i++) {

            Runnable work = new WorkThread("" + i);
            executor.execute(work);
        }
        executor.shutdown();
        while (!executor.isTerminated()) {
        }
        System.out.println("Finish all threads.");
    }
}
