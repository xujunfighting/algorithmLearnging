package com.zto.newYear;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by xujun on 2019-01-29.
 */
public class MyNewMaxSequence {
    public static void main(String[] args){
        int[] a=new int[]{2,3,4,2,6,2,5,1};
        List<Integer> lists=new ArrayList<Integer>();
        lists=method(a,lists,3);
        print(lists);
    }
    public static List<Integer> method(int[] a,List<Integer> lists,int size){
        int i=0;
        LinkedList<Integer> linkedList=new LinkedList<>();

        while(i<a.length){
           if(!linkedList.isEmpty()&&i-linkedList.peekLast()>size-1){//当list中的元素内容超过三个时需要弹出元素
               linkedList.removeLast();
           }
           while(!linkedList.isEmpty()&&a[i]>a[linkedList.peekFirst()]){
               linkedList.remove();
           }
           linkedList.addFirst(i);
           if(i>=size-1) {
               lists.add(a[linkedList.peekLast()]);
           }
            i++;
        }
        return lists;
    }
    public static void print(List<Integer> lists){
        for(int i:lists){
            System.out.println(i+"");
        }
    }
}
