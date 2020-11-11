package com.zto.newYear;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by xujun on 2019-01-02.
 */
public class MaxMoveQueueValue {
    public static void main(String[] args){
        int[] a=new int[]{1,2,3,4,6,5,4,11,9,8};
        int size=3;
        method(a,size);
    }
    public static void method(int[] a,int size){
        int start=0;
        List<Integer> lists=new ArrayList<Integer>();
        LinkedList<Integer> res=new LinkedList<Integer>();
        while(start<a.length){
            if(!res.isEmpty()){
               if(res.size()>size-1){
                   res.pop();
               }
               while(!res.isEmpty()&&a[start]>a[res.getLast()]){
                   res.removeLast();
               }
            }
            res.add(start);
          if(start+1>=size){
              lists.add(a[res.peek()]);
          }
          start++;
        }
    }
}
