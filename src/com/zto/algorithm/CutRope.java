package com.zto.algorithm;

/**
 * Created by xujun on 2018-12-19.
 */
public class CutRope {
    public static void main(String[] args){
       int length=5;
       int result=method(5);
       System.out.print(result);
    }
    public static int method(int length){
        if(length==0){
            return 0;
        }
        if(length==1){
            return 1;
        }
        if(length==2){
            return 1;
        }
        if(length==3){
            return 2;
        }
        int pas[]=new int[length+1];
        pas[0]=0;
        pas[1]=1;
        pas[2]=2;
        pas[3]=2;
        int result=0;
        for(int i=4;i<=length;i++){
            for(int j=1;j<=(length/2);j++){
                int current=pas[j]*pas[i-j];
                if(current>result)result=current;
            }
            pas[i]=result;
        }
        return result;
    }
}
