package com.asynTest;

/**
 * @Description
 * @Author xujun
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/8/28
 */
public class Bootstrap {
    public static void main(String[] args) {
        Bootstrap bootstrap = new Bootstrap();

        Worker worker = bootstrap.newWorker();

        Wrapper wrapper = new Wrapper();
        wrapper.setWorker(worker);
        wrapper.setParam("hello");

        bootstrap.doWork(wrapper).setListener(new Listener() {
            @Override
            public void result(Object result) {
                System.out.println(Thread.currentThread().getName());
                System.out.println(result);
            }
        });

        System.out.println(Thread.currentThread().getName());
    }


    private Wrapper doWork(Wrapper wrapper){
        new Thread(()->{
            Worker worker=wrapper.getWorker();
            String result = worker.action(wrapper.getParam());
            wrapper.getListener().result(result);
        }).start();
        return wrapper;
    }
    private Worker newWorker(){
        return new Worker() {
            @Override
            public String action(Object o) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return o+"world";
            }
        };
    }
}
