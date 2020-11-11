package com.zto.MyMasterWorker;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by xujun on 2019-01-28.
 */
public class Worker implements  Runnable{
    private Queue<Integer> task=new ConcurrentLinkedQueue<>();
    private Map<String,Integer> resultMap=new HashMap<>();
    @Override
    public void run() {
        while (true) {
            if(task.isEmpty()){
                break;
            }
            Integer i = (Integer) task.poll();
            resultMap.put(""+i, i);
        }
    }

    public Queue<Integer> getTask() {
        return task;
    }

    public void setTask(Queue<Integer> task) {
        this.task = task;
    }

    public Map<String, Integer> getResultMap() {
        return resultMap;
    }

    public void setResultMap(Map<String, Integer> resultMap) {
        this.resultMap = resultMap;
    }
}
