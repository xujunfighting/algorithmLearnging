package com.niuke.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @version v1.0.0
 * @Description
 * @Author xujun
 * @Since 1.0
 * @Date 2021/7/19
 **/
public class AllCombination {

     static List<Integer> list=new ArrayList<>();
     static List<List<Integer>> lists=new ArrayList<>();
    public static void main(String[] args) {
        int[] nums=new int[]{1,1,2};
        getResult(nums,0);
        System.out.println(lists);
    }
    public static void getResult(int[] nums,int start){
        if(start>=nums.length){
            list=new ArrayList<>();
            for(int i=0;i<nums.length;i++){
                list.add(nums[i]);
            }
            lists.add(new ArrayList<>(list));
            return;
        }
        for(int i=start;i<nums.length;i++){
            swap(nums,start,i);
            getResult(nums,start+1);
            swap(nums,start,i);
        }
    }
    public static void swap(int[] nums,int p,int q){
        int swap=nums[p];
        nums[p]=nums[q];
        nums[q]=swap;
    }
}
