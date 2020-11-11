package com.zto.masterworker;

import java.util.Map;
import java.util.Set;

/**
 * Created by xujun on 2019-01-28.
 */
public class Client {
    public static void main(String[] args) {
        Master m = new Master(new Worker(), 5);//启动五个线程处理
        for (int i = 0; i < 100; i++) {//提交100个任务任务队列
            m.submit(i);
        }
        m.execute();
        int re = 0;
        Map<String, Object> resultMap = m.getResultMap();
        while(resultMap.size()>0||!m.isComplete()){
            Set<String> keys = resultMap.keySet();
            String key =  null;
            for(String k:keys){
                key=k;
                break;
            }
            Integer i = null;
            if(key != null){
                i = (Integer) resultMap.get(key);
            }
            if(i!=null){
                re+=i;//并行计算结果集
            }

            if(key!=null){
                resultMap.remove(key);//将计算完成的结果移除
            }
        }

        System.out.println(re);
    }
}
