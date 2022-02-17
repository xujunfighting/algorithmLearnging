package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xujun
 * @date 2022-02-08
 **/
public class FibonacciMinumChoose {

    private static List<Integer> results = new ArrayList<>();
    private static List<Integer> count=new ArrayList<>();
    private static Integer minCount=Integer.MAX_VALUE;

    public static void main(String[] args) {
       getResult(19);
        System.out.println(minCount);
    }

    public static int getResult(int res) {
        if (res == 1) {
            return 1;
        }
        if (res == 2) {
            return 2;
        }
        results.add(1);
        results.add(1);
        int pre=1;
        int cur=1;
        int next=2;
        while(next<res){
            results.add(next);
            pre=cur;
            cur=next;
            next=pre+cur;
        }
        int[] reverse = reverse(results);
        getCount(res, reverse);
        return minCount;
    }

    private static List<Integer> getCount(int n,int[] arrays){
        if(n<0){
            return count;
        }
        if(n==0){
            minCount=count.size();
            return count;
        }

        for(int i=0;i<arrays.length;i++){
            n-=arrays[i];
            count.add(arrays[i]);
            getCount(n,arrays);
            if(minCount!=Integer.MAX_VALUE){
                return count;
            }
            count.remove(count.size()-1);
            n+=arrays[i];
        }
        return count;
    }

    private static int[] reverse(List<Integer> res){
        int[] revise=new int[res.size()];
        int index=0;
        for(int i=res.size()-1;i>=0;i--){
            revise[index++]=res.get(i);
        }
        return revise;
    }
}
