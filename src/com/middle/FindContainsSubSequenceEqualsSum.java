package com.middle;

import java.util.ArrayList;

public class FindContainsSubSequenceEqualsSum {
    static ArrayList<ArrayList<Integer>> res=new ArrayList<>();
    static ArrayList<Integer> result=new ArrayList<>();
    public static void main(String[] args) {
          ArrayList<ArrayList<Integer>> listArrayList=FindContinuousSequence(3);
         System.out.println(listArrayList);
    }
    public static ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        int start=1;
        int end=2;
        while(start<end){
            if((start+end)*(end-start+1)==2*sum){
                result=new ArrayList<>();
                for(int i=start;i<=end;i++){
                    result.add(i);
                }
                res.add(result);
                start++;
                end++;
            }else if((start+end)*(end-start+1)>2*sum){
                 start++;
            }else{
                end++;
            }
        }
        return res;
    }
}
