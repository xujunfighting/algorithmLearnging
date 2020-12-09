package com.niuke;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Description
 * @Author xujun
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/12/4
 */
public class AllPermutation {
    private static ArrayList<ArrayList<Integer>> lists=new ArrayList<>();
    private static ArrayList<Integer> list=new ArrayList<>();
    public static void main(String[] args) {
        int[] ints=new int[]{1,2,3};
       getResult(ints,0);
        System.out.println(lists);
    }
    public static ArrayList<ArrayList<Integer>> getResult(int[] ints,int index){
        if(index>=ints.length){
            list=new ArrayList<>();
            for(int i=0;i<ints.length;i++){
                list.add(ints[i]);
            }
            lists.add(new ArrayList<>(list));
            return lists;
        }
        for(int i=index;i<ints.length;i++){
            swap(ints,i,index);
            getResult(ints,index+1);
            swap(ints,i,index);
        }
        return lists;
    }
    public static void swap(int[] ints,int p,int q){
        int temp=ints[p];
        ints[p]=ints[q];
        ints[q]=temp;
    }
}
