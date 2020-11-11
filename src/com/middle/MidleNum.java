package com.middle;

import java.util.LinkedList;

public class MidleNum {

    private static int count=0;
    private static LinkedList<Integer> list=new LinkedList<>();
    public static void main(String[] args) {
        Insert(1);
        Double median1 = getMedian();
        Insert(10);
        Double median2 = getMedian();
        Insert(5);
        Double median3 = getMedian();
        Insert(4);
        Double median4 = getMedian();
        System.out.println(median4);
    }
    public static void Insert(Integer num){
        count++;
        if(list.size()==0){
            list.add(num);
            return;
        }
        int index=1;
        if(list.getFirst()>num){
            list.addFirst(num);
        }else if(list.getLast()<num){
            list.addLast(num);
        }else{
           while(index<count&&list.get(index)<num){
               index++;
           }
           list.add(index,num);
        }

    }
    public static Double getMedian(){
        if(count%2==0){
            return (list.get(count/2-1)*1.0+list.get(count/2)*1.0)/2;
        }else{
            return list.get(count/2)*1.0;
        }
    }
}
