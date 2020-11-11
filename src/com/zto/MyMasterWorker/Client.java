package com.zto.MyMasterWorker;

import java.util.Map;

/**
 * Created by xujun on 2019-01-28.
 */
public class Client {
    public static void main(String[] args){
        Master master=new Master(new Worker(),5);
        for(int i=0;i<100;i++){
            master.submit(i);
        }
        master.execute();
        while(!master.isComplete()){
            System.out.println("任务进行中。。。。");
        }
        Map<String,Integer> res=master.getResults();
        int value=0;
        for(Map.Entry<String,Integer> result:res.entrySet()){
            value+=result.getValue();
        }
        System.out.println(value);
    }
}
