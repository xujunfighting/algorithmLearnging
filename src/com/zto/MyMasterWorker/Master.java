package com.zto.MyMasterWorker;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by xujun on 2019-01-28.
 */
public class Master {
    private Queue<Integer> queue = new ConcurrentLinkedQueue<>();//任务
    private Map<String, Thread> workers = new HashMap<>();
    private Map<String, Integer> results = new HashMap<>();

    public Master(Worker worker, int count) {
        worker.setTask(queue);
        worker.setResultMap(results);
        for (int i = 0; i < count; i++) {
            workers.put(String.valueOf(i), new Thread(worker, "worker" + i));
        }
    }

    public void submit(Integer i) {
        queue.add(i);
    }

    public void execute() {
        for (Map.Entry<String, Thread> map : workers.entrySet()) {
            map.getValue().start();
        }
    }

    public Queue<Integer> getQueue() {
        return queue;
    }

    public void setQueue(Queue<Integer> queue) {
        this.queue = queue;
    }

    public Map<String, Thread> getWorkers() {
        return workers;
    }

    public void setWorkers(Map<String, Thread> workers) {
        this.workers = workers;
    }

    public Map<String, Integer> getResults() {
        return results;
    }

    public void setResults(Map<String, Integer> results) {
        this.results = results;
    }
    public boolean isComplete(){
        if(queue.isEmpty()){
            return true;
        }else{
            return false;
        }
    }
}
