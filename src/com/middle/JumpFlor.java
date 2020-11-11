package com.middle;

public class JumpFlor {
    public static void main(String[] args) {
        int res=getResult(4);
        System.out.println(res);
    }
    public static int getResult(int n){
        if(n==1){
            return 1;
        }
        if(n==2){
            return 2;
        }
        int[] res= new int[n+1];
        res[1]=1;
        res[2]=2;
        for(int i=3;i<=n;i++){
            res[i]=res[i-1]+res[i-2];
        }
        return res[n];
    }
}
