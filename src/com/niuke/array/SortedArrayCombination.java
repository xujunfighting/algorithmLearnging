package com.niuke.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @version v1.0.0
 * @Description
 * @Author xujun
 * @Since 1.0
 * @Date 2021/8/11
 **/
public class SortedArrayCombination {
    static List<List<Integer>> results=new ArrayList<>();
    static List<Integer> res=new ArrayList<>();
    public static void main(String[] args) {
        int n=4;
        int[] array=new int[n];
        for(int i=0;i<n;i++){
            array[i]=i+1;
        }
        int k=2;
        getAllCombination(array,0,2);
        System.out.println(results);
    }
    public static void getAllCombination(int[] arrays,int start,int k){

        if(k==0){
            results.add(new ArrayList<>(res));
            return;
        }
        for(int i=start;i<arrays.length;i++){
            res.add(arrays[i]);
            getAllCombination(arrays,i+1,k-1);
            res.remove(res.size()-1);
        }
    }
}
