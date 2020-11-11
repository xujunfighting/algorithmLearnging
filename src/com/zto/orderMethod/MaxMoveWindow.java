package com.zto.orderMethod;

import java.util.LinkedList;

/**
 * Author xujun
 * Create date 2019-08-01.
 * desc:
 */
public class MaxMoveWindow {
    private static LinkedList<Integer> list=new LinkedList<>();
    public static void main(String[] args) {
        int[] res=new int[]{2,3,4,2,1,6,2,5,1};
        int len=3;
        method(res,3);
    }
    public static void method(int[] res,int len){
           for(int i=0;i<res.length;i++) {
               if (list.size()!=0) {//当list对象内容没有达到指定长度
                       if(i-list.getFirst()>2){//角标存储越界
                           list.removeFirst();
                       }
                      while(list.size()!=0&&res[i]>res[list.peekLast()]){
                          list.removeLast();
                      }
                       list.addLast(i);
               } else {
                     list.addFirst(i);
               }
               int result=list.peekFirst();
               System.out.println(res[result]);
           }
    }
}
