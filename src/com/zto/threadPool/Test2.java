package com.zto.threadPool;

/**
 * Created by xujun on 2019-02-02.
 */
public class Test2 {
    private int min=0;
    private int max=0;
    public void method(int[] a){
        for(int i=0;i<a.length;i++){
            if(a[i]>max){
                max=a[i];
            }
            if(min<a[i]){
                min=a[i];
            }
        }
    }
    public static void main(){

    }
}
