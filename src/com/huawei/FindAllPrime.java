package com.huawei;

public class FindAllPrime {
    public static void main(String[] args) {
         getResult(180);
    }
    public static void getResult(long val){
        for(int i=2;i<=val;i++){
            while (val%i==0){
                System.out.print(i+" ");
                val=val/i;
            }
        }

    }
}
