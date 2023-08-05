package com.niuke.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author xujun
 * @Description   2799
 * @Date 2023/8/5 10:57
 */
public class CountCompleteSubarrays {

    public static void main(String[] args) {
        int[] nums=new int[]{1,3,1,2,2};
        int result = getResult2(nums);
        System.out.println(result);

    }

    /**
     * hashMap 去重复统计
     * @param nums
     * @return
     */
    public static int getResult(int[] nums){
        int result=0;
        int totalCount=0;
        Map<Integer,Integer> maps=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(!maps.containsKey(nums[i])){
                maps.put(nums[i],1);
                totalCount++;
            }else{
                Integer integer = maps.get(nums[i]);
                maps.put(nums[i],integer+1);
            }
        }
        for(int i=0;i<nums.length;i++){
            maps=new HashMap<>();
            maps.put(nums[i],1);
            int curCount=1;
            int j=i;
            while(j<nums.length){
                if(!maps.containsKey(nums[j])){
                   maps.put(nums[j],1);
                   curCount++;
                }
                /**
                 * 不重复的元素已经满足条件 后续的无需遍历 直接加上剩余元素的个数，跳出当前循环
                 */
                if(curCount==totalCount){
                    result+=(nums.length-j);
                    break;
                }
                j++;
            }
        }
        return result;
    }

    /**
     * 滑动窗口
     * @param nums
     * @return
     */
    public static int getResult2(int[] nums){
        int result=0;
        int totalCount=0;
        Set<Integer> maps=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(!maps.contains(nums[i])){
                maps.add(nums[i]);
                totalCount++;
            }
        }
        int[] indexs=new int[2001];
        int curLen=0;
        int start=0;
        int end=0;
        while(end<nums.length){
            /**
             * 当前元素没有被添加过 总长度+1
             */
            if(indexs[nums[end]]==0){
                curLen++;
            }
            /**
             * 当前元素的所在角标位+1
             */
             indexs[nums[end]]++;
            while(curLen==totalCount){
                /**
                 * 达到统计长度  后续元素直接可以遍历到尾部 长度为（数组长度-end)值
                 */
                result+=(nums.length-end);
                /**
                 * 当前元素所在角标位-1
                 */
                indexs[nums[start]]--;
                /**
                 * 如果角标位元素为0 说明移除该元素会导致总元素个数-1
                 */
                if(indexs[nums[start]]==0){
                    curLen--;
                }
                /**
                 * 移动start角标位再次判断结果是否满足
                 */
                start++;
            }
            end++;
        }
        return result;
    }

}
