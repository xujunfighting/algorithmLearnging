package com.niuke.array;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @version v1.0.0
 * @Description
 * @Author xujun
 * @Since 1.0
 * @Date 2021/7/6
 **/
public class TreeNumSumZero {
    static List<List<Integer>> lists=new ArrayList<>();
    static List<Integer> list=new ArrayList<>();

    public static void main(String[] args) {
       int[] res=new int[]{1,2,0,-1};
        List<List<Integer>> result = getResultEnhance(res);
        System.out.println(lists);
//        int res=-4^4^0;
//        int res1=-3^3^0;
//        System.out.println(res);
//        System.out.println(res1);

    }
    public static List<List<Integer>> getResult(int[] res){
        if(res.length<=2||res==null){
            return lists;
        }else if(res.length==3){
            if(res[0]+res[1]+res[2]!=0){
                return lists;
            }else{
                list.add(res[0]);
                list.add(res[1]);
                list.add(res[2]);
                lists.add(list);
                return  lists;
            }
        }
        //Arrays.sort(res);


        method(res,0,3,0);
        List<List<Integer>> collect=new ArrayList<>();
        if(lists.size()==0){
            return collect;
        }
        Collections.sort(lists, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                if(o1.get(0)>o2.get(0)){
                    return 1;
                }else if(o1.get(0)<o2.get(0)){
                    return -1;
                }else{
                    if(o1.get(1)>o2.get(1)){
                        return 1;
                    }else if(o1.get(1)<o2.get(1)){
                        return -1;
                    }
                    return 0;
                }
            }
        });

        int cur=0;
        int next=1;
        List<Integer> sets=new ArrayList<>();

        sets.add(cur);
        while(next<lists.size()){

            if(lists.get(cur).get(0)==lists.get(next).get(0)&&lists.get(cur).get(1)==lists.get(next).get(1)&&lists.get(cur).get(2)==lists.get(next).get(2)){
                cur=next;
                next=next+1;
                continue;
            }else{
               sets.add(next);
                cur=next;
                next=next+1;
            }

        }
        for(int index:sets){
            collect.add(lists.get(index));
        }
        return collect;
    }
    public static void method(int[] res,int start,int count,int sum){
        if(count==0){
            if(sum==0) {
                lists.add(new ArrayList<>(sort(list)));
            }
            return;
        }
        //int lastVisited=Integer.MIN_VALUE;
        for(int i=start;i<=res.length-count;i++){
//            if(res[i]==lastVisited){
//                continue;
//            }
            sum-=res[i];
            //lastVisited=res[i];
            list.add(res[i]);
            i++;
            count--;
            method(res,i,count,sum);
            i--;
            list.remove(list.size()-1);
            sum+=res[i];
            count++;
        }
    }
    public static List<Integer> sort(List<Integer> lists){
        List<Integer> collect = lists.stream().sorted(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(o1==o2){
                    return 0;
                }else if(o1>o2){
                    return 1;
                }else{
                    return -1;
                }
            }
        }).collect(Collectors.toList());
        return collect;
    }



    public static List<List<Integer>> getResultEnhance(int[] nums){
        /**
         * 固定开始位置的元素 双指针动态遍历后面的元素
         */
        List<List<Integer>> lists = new ArrayList<>(nums.length-2);
            //排序
            Arrays.sort(nums);
            //双指针
            int len = nums.length;
            for(int i = 0;i < len;++i) {
                /**
                 *遍历当前元素的最小值大于零 表明后面的元素的和都是大于零 直接返回遍历成功的结果集合
                 */
                if(nums[i] > 0) return lists;
                /**
                 * 对于排序好的元素相同的元素只会出现在相邻位置 遇到直接跳过
                 */
                if(i > 0 && nums[i] == nums[i-1]) continue;

                int curr = nums[i];
                int L = i+1, R = len-1;
                while (L < R) {
                    int tmp = curr + nums[L] + nums[R];
                    if(tmp == 0) {
                        /**
                         * 结果为0 加入结果集合
                         */
                        List<Integer> list = new ArrayList<>(3);
                        list.add(curr);
                        list.add(nums[L]);
                        list.add(nums[R]);
                        lists.add(list);
                        /**
                         * 跳过相同的元素
                         */
                        while(L < R && nums[L+1] == nums[L]) ++L;
                        while (L < R && nums[R-1] == nums[R]) --R;
                        ++L;
                        --R;
                    } else if(tmp < 0) {
                        /**
                         * 移动左指针 增大值
                         */
                        ++L;
                    } else {
                        /**
                         * 移动右指针 减小值
                         */
                        --R;
                    }
                }
            }
            return lists;
        }

}
