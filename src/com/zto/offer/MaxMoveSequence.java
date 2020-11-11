package com.zto.offer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xujun on 2018-12-27.
 */
public class MaxMoveSequence {
    public static int[] judege=new int[3];
    public static void main(String[] args){
        int[] a=new int[]{2,3,4,2,6,2,5,1};
        int size=3;
         List<Integer> results=method(a,size);
         print(results);
    }
    public static List<Integer> method(int[] a,int size){
        List<Integer> results=new ArrayList<>();
        int max=0;
        for(int i=0;i<a.length;i++){
            if(i<=2){
                if(max<a[i]){
                   max=a[i];
                }
                judege[2]=max;
                if(i==2){
                    results.add(judege[2]);
                }
            }else{

            }
        }
        return results;
    }
    public static void print(List<Integer> lists){
        for(int i=0;i<lists.size();i++){
            System.out.print(lists.get(i)+" ");
        }
    }
}
