package com.niuke;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * @Description
 * 二分法 元素可以采用选和不选
 * 构建一颗满二叉树
 * @Author xujun
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/11/26
 */
public class AllSubList {
    static ArrayList<ArrayList<Integer>> lists=new ArrayList<ArrayList<Integer>>();
    static ArrayList<Integer> list=new ArrayList<>();
    public static void main(String[] args) {
        int[] res=new int[]{1,2,3,4,5};
        getResult2(res,2);
        //getResult(res,0);
        Collections.sort(lists, new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
               if(o1.size()>o2.size()){
                   return 1;
               }else if(o1.size()<o2.size()){
                   return -1;
               }else{
                  int sum1=o1.stream().reduce(0,(x,y)->{return x+y;});
                  int sum2=o2.stream().reduce(0,(x,y)->{return x+y;});
                  return sum1>sum2?1:(sum1<sum2?-1:0);
               }
            }
        });
        System.out.println(lists);
    }
    public static ArrayList<ArrayList<Integer>> getResult(int[] res,int start){
        if(start>=res.length){
            lists.add(new ArrayList<>(list));
            return lists;
        }
        list.add(res[start]);
        start++;
        //添加当前元素
        getResult(res,start);
        //移除当前元素
        list.remove(list.size()-1);
        getResult(res,start);
        start--;
        return lists;
    }
    public static ArrayList<ArrayList<Integer>> getResult2(int[] res,int start){
        if(start<=-1){
            lists.add(new ArrayList<>(list));
            list=new ArrayList<>();
            return lists;
        }
        start--;
        getResult2(res,start);
        start++;
        list.add(res[start]);
        start--;
        getResult2(res,start);
        start++;
        return lists;
    }
}
