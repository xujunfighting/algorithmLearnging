package com.zto.future;

import java.util.concurrent.Callable;

/**
 * Created by xujun on 2019-01-28.
 */
public class RealData implements Callable<String> {
      private String para;

    public RealData(String data) {
        // 利用sleep方法来表示RealData构造过程是非常缓慢的

       this.para=data;
    }

    @Override
    public String call() throws Exception {
        // 利用sleep方法来表示真是业务是非常缓慢的
         StringBuffer sb = new StringBuffer();
            for (int i = 0; i < 10; i++) {
                      sb.append(para);
                      try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                               e.printStackTrace();
                         }
                  }
            return sb.toString();
    }
}
