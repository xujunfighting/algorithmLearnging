package com.zto.newYear;

/**
 * Created by xujun on 2019-01-09.
 */
public class DuckerSum {
    public static void main(String[] args){
       int result=getResult(0,2);
       System.out.print(result);
    }
    public static int getResult(int i,int result){
        if(i==7){
            return  result;
        }
        result=(result+1)*2;
        int val=getResult(i+1,result);
        return val;
    }
}
