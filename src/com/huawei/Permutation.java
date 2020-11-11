package com.huawei;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Permutation {
    public static ArrayList<String> arrays=new ArrayList<>();
    public static char pre='1';
    public static void main(String[] args) {
        String test="aabc";
        Permutation(test);
        Collections.sort(arrays);
        System.out.println(arrays);
    }
    public static ArrayList<String> Permutation(String str) {
        return getResult(str.toCharArray(),0);
    }
    public static ArrayList<String> getResult(char[] res,int start){
        if(start==res.length-1){
            arrays.add(new String(res));
        }
        pre='1';
        for(int i=start;i<res.length;i++){
            if((i!=start&&res[i]==res[start])||pre==res[i]){
                continue;
            }
            pre=res[i];
            swap(res,i,start);
            getResult(res,start+1);
            swap(res,i,start);
        }
        return arrays;
    }

    public static void swap(char[] res,int p,int q){
        char swap=res[p];
        res[p]=res[q];
        res[q]=swap;
    }

}
