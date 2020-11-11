package com.zto.masterworker;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

/**
 * Created by xujun on 2019-01-28.
 */
public class Worker implements Runnable {
    //任务队列
    protected Queue<Object> workQueue;
    //子任务结果集
    protected Map<String,Object> resultMap = new HashMap<String, Object>();


    public void setWorkQueue(Queue<Object> workQueue) {
        this.workQueue = workQueue;
    }
    public void setResultMap(Map<String, Object> resultMap) {
        this.resultMap = resultMap;
    }

    public Object handle(Object input){
        Integer i=(Integer)input;
        return i*i*i;
    }
    @Override
    public void run() {
        while(true){
            Object input = workQueue.poll();//取出任务

            if(null==input) break;
            //处理子任务
            Object re = handle(input);
            resultMap.put(Integer.toString(input.hashCode()),re);
            //System.out.println(re.toString());
        }
    }

}
