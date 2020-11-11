package com.zto.algorithm;

import java.util.HashMap;
import java.util.Set;

/**
 * Created by xujun on 2018-11-01.
 */
public class NumberMoreThanHalf {
    public static void main(String[] args){
         int[] a=new int[]{1,1,1,2,3,1,4,5,1,1,1};
         int result=getNumber(a);
        System.out.print(result);
    }
    public static int  getNumber(int[] a){
        HashMap<Integer,Integer> hash=new HashMap<Integer,Integer>();
        for(int i=0;i<a.length;i++){
            if(hash.containsKey(a[i])){
                int value=hash.get(a[i]);
                value++;
                hash.put(a[i],value);
            }else{
                hash.put(a[i],1);
            }
        }
        Set<Integer> sets=hash.keySet();
        for(Integer i:sets){
            if(hash.get(i)>a.length/2){
               return i;
            }
        }
        return 0;
    }
}
