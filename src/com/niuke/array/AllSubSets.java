package com.niuke.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @version v1.0.0
 * @Description
 * @Author xujun
 * @Since 1.0
 * @Date 2021/8/12
 **/
public class AllSubSets {
    static List<List<Integer>> results=new ArrayList<>();
    static List<Integer> result=new ArrayList<>();
    public static void main(String[] args) {
        getResult(new int[]{1,2,3},0);
        System.out.println(results);
    }
    public static void getResult(int[] nums,int start){
        results.add(new ArrayList<>(result));
        if(start>=nums.length){
            return;
        }
        for(int i=start;i<nums.length;i++){
            result.add(nums[i]);
            getResult(nums,i+1);
            result.remove(result.size()-1);
        }
    }
}
