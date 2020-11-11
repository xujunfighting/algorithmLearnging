package com.zto.fightfortomorrow;

/**
 * Author xujun
 * Create date 2019-04-02.
 * desc:
 */
public class FiBI {
    public static void main(String[] args) {
        int res=getResult(5);
        System.out.println(res);
    }
    public static int getResult(int i){
        if(i==1||i==2){
            return 1;
        }
        return getResult(i-1)+getResult(i-2);
    }
    public static int getResult1(int i){
        if(i==1||i==2){
            return 1;
        }
        int res1=1;
        int res2=1;
        int res3=0;
        for(int j=3;j<=i;j++){
            res3=res1+res2;
            res1=res2;
            res2=res3;
        }
        return res3;
    }
}
