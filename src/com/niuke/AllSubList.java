package com.niuke;

import java.util.ArrayList;

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
        int[] res=new int[]{1,2};
        getResult(res,0);
        System.out.println(lists);
    }
    public static ArrayList<ArrayList<Integer>> getResult(int[] res,int start){
        if(start>=res.length){
            lists.add(new ArrayList<>(list));
            return lists;
        }
        list.add(res[start]);
        start++;
        getResult(res,start);
        list.remove(list.size()-1);
        getResult(res,start);
        start--;
        return lists;
    }
}
