package com.zto.newYear;

/**
 * Created by xujun on 2019-01-15.
 */
public class DPtest {
    public static void main(String[] args){
        int result=method(10);
        System.out.print(result);
    }
    public static int  method(int result){
        if(result<=1){
            return 2;
        }
        if(result==2){
            return 1;
        }
        if(result==3){
            return 1;
        }
        if(result==4){
            return 1;
        }
        return min(method(result-2)+1,method(result-3)+1,method(result-4)+1);
    }
    public static int min(int a,int b,int c){
        int min=0;
        if(a<b){
            min=a;
        }else{
            min=b;
        }
        if(c<min){
            min=c;
        }
        return min;
    }
}
