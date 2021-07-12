package com.niuke.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @version v1.0.0
 * @Description
 * @Author xujun
 * @Since 1.0
 * @Date 2021/7/8
 **/
public class FourNumSumTarget {
    static List<List<Integer>> lists=new ArrayList<>();
    static List<Integer> list=new ArrayList<>();
    static int cur=0;
    public static void main(String[] args) {
//        输入：nums = [1,0,-1,0,-2,2], target = 0
//        输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
        int[] nums=new int[]{1,0,-1,0,-2,2};
        getResultEnhance(nums, 0);
        System.out.println(lists);
    }
    public static List<List<Integer>> getResult(int[] res,int target){
        if(res.length==4){
            if(res[0]+res[1]+res[2]+res[3]==target){
                List<Integer> list=new ArrayList<>();
                list.add(res[0]);
                list.add(res[1]);
                list.add(res[2]);
                list.add(res[3]);
                lists.add(list);
                return lists;
            }else{
                return lists;
            }
        }
         Arrays.sort(res);

        int lastI=Integer.MIN_VALUE;
         for(int i=0;i<res.length-3;i++){

             if(lastI==res[i]){
                 continue;
             }
             lastI=res[i];
             int lastJ=Integer.MIN_VALUE;
             for(int j=i+1;j<res.length-2;j++){

                 if(lastJ==res[j]){
                     continue;
                 }
                 lastJ=res[j];
                 int start=j+1;
                 int end=res.length-1;
                 while(start<end){
                     if(res[i]+res[j]+res[start]+res[end]==target){
                          List<Integer> list=new ArrayList<>();
                          list.add(res[i]);
                          list.add(res[j]);
                          list.add(res[start]);
                          list.add(res[end]);
                          lists.add(list);
                          while(start<end&&res[start]==res[start+1]) start++;
                          while(start<end&&res[end-1]==res[end]) end--;
                          start++;
                          end--;
                     }else if(res[i]+res[j]+res[start]+res[end]>target){
                         end--;
                     }else if(res[i]+res[j]+res[start]+res[end]<target){
                         start++;
                     }
                 }
             }
         }
         return lists;
    }
    public  static List<List<Integer>> getResultEnhance(int[] nums,int target){
        Arrays.sort(nums);
        dfs(nums, target,0);
        return lists;
    }
    public static void dfs(int[] nums, int target, int begin){
        if(list.size() == 4){
            if(cur == target){
                lists.add(new ArrayList<>(list));
            }
            return;
        }

        for(int i = begin; i < nums.length; i++ ){
            /**
             * 假设list已经有三个元素 则需要保证还有遍历后续的元素 i的角标不能超过最后一位元素的角标
             * nums.length-1<i 超出角标直接跳出循环
             */
            if(nums.length-4+list.size() < i)return;
            /**
             * 遇到当前层次前后相同的元素表明已经添加过 直接跳过
             */
            if(begin != i && nums[i - 1] == nums[i])continue;
            if(i < nums.length - 1 && cur + nums[i] + (3 - list.size()) * nums[i + 1] > target)return;
            if(i < nums.length - 1 && cur + nums[i] + (3 - list.size()) * nums[nums.length - 1] < target)continue;
            cur += nums[i];
            list.add(nums[i]);
            dfs(nums, target, i + 1);
            list.remove(list.size() - 1);
            cur -= nums[i];
        }
    }
}
