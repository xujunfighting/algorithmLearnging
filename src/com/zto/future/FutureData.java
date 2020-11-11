package com.zto.future;

/**
 * Created by xujun on 2019-01-28.
 */
public class FutureData implements Data {
    RealData realData = null; // FutureData是RealData的封装
    boolean isReady = false; // 是否已经准备好

    public synchronized void setRealData(RealData realData) {
        if (isReady)
            return;
        this.realData = realData;
        isReady = true;
        notifyAll(); // RealData已经被注入到FutureData中了，通知getResult()方法
    }

    @Override
    public String getResult() throws InterruptedException {
        if (!isReady) {
            wait(); // 一直等到RealData注入到FutureData中
        }
//        return realData.getResult();
        return null;
    }
}
