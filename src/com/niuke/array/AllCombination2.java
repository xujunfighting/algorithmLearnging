package com.niuke.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @version v1.0.0
 * @Description
 * @Author xujun
 * @Since 1.0
 * @Date 2021/7/19
 **/
public class AllCombination2 {
    static List<Integer> list=new ArrayList<>();
    static List<List<Integer>> lists=new ArrayList<>();
    static int count=0;
    public static void main(String[] args) {
        int[] nums=new int[]{-1,0,-1,1,0,1,2};
        Arrays.sort(nums);
        getResult(nums,0);

        List<List<Integer>> collect = lists.stream().sorted(new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                if (o1.get(0) > o2.get(0)) {
                    return 1;
                } else if (o1.get(0) < o2.get(0)) {
                    return -1;
                } else {
                    if (o1.get(1) > o2.get(1)) {
                        return 1;
                    } else if (o1.get(1) < o2.get(1)) {
                        return -1;
                    } else {
                        if (o1.get(2) > o2.get(2)) {
                            return 1;
                        } else if (o1.get(2) < o2.get(2)) {
                            return -1;
                        } else {
                            if (o1.get(3) > o2.get(3)) {
                                return 1;
                            } else if (o1.get(3) < o2.get(3)) {
                                return -1;
                            } else {
                                if (o1.get(4) > o2.get(4)) {
                                    return 1;
                                } else if (o1.get(4) < o2.get(4)) {
                                    return -1;
                                } else {
                                    if (o1.get(5) > o2.get(5)) {
                                        return 1;
                                    } else if (o1.get(5) < o2.get(5)) {
                                        return -1;
                                    } else {
                                        if (o1.get(6) > o2.get(6)) {
                                            return 1;
                                        } else if (o1.get(6) < o2.get(6)) {
                                            return -1;
                                        } else {
                                            count++;
                                            return 0;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }).collect(Collectors.toList());
        System.out.println(count);
        System.out.println(collect);
    }
    public static void getResult(int[] nums,int start){
        if(start>=nums.length){
                list=new ArrayList<>(nums.length);
                for(int i=0;i<nums.length;i++){
                    list.add(nums[i]);
                }
                lists.add(new ArrayList<>(list));
                return;
        }
        List<Integer> used=new ArrayList<>();
        for(int i=start;i<nums.length;i++){
            /**
             * 基础序列为 0 1 2 0 -1 1 -1   交换3和4位置的元素得到的结果为  0 1 2 -1 0 1 -1
             * 交换3和6位置的元素为 0 1 2 -1 -1 1 0 后续元素替换同样可以得到 0 1 2 -1 0 1 -1  需要把和start交换过的相同的元素保存下来 如果已经交换过的值存在 则跳过相同的元素
             */
            if(i!=start&&nums[start]==nums[i]||used.contains(nums[i])){
                continue;
            }
            if(i!=start){
                used.add(nums[i]);
            }
            //System.out.println("交换的位置为"+i+" "+start);
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
