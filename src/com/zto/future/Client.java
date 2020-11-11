package com.zto.future;

/**
 * Created by xujun on 2019-01-28.
 */
public class Client {
    public Data request(final String string) {
        final FutureData futureData = new FutureData();

        new Thread(new Runnable() {
            @Override
            public void run() {
                // RealData的构建很慢，所以放在单独的线程中运行
                RealData realData = new RealData(string);
                futureData.setRealData(realData);
            }
        }).start();
        return futureData; // 先直接返回FutureData
    }
}