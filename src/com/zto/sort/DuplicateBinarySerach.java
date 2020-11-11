package com.zto.sort;

import com.zto.common.Indexs;

/**
 * Created by xujun on 2018-11-26.
 */
public class DuplicateBinarySerach {
    public static void main(String[] args){
        int[] a=new int[]{1,2,3,3,4,4,4,4,4,5,6,7,8,9,10};
        Indexs indexs=new Indexs();
        indexs=search(indexs,a);

    }
    public static Indexs search(Indexs indexs,int[] a){
       int start=0;
       int  end=a.length-1;
       while(start<=end){
           int mid=(start+end)/2;

       }
        return null;
    }

}
