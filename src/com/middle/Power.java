package com.middle;

public class Power {
    public static void main(String[] args) {
        double res=Power(2,-3);
        System.out.println(res);
    }
    public static double Power(double base,int exponent){
        double result=1;
        boolean flag=true;
        if(base==0){
            return 0;
        }
        if(exponent==0){
            return base;
        }
        if(exponent<0){
            flag=false;
            exponent=-exponent;
        }
        for(int i=1;i<=exponent;i++){
            result*=base;
        }
        if(!flag){
            result=1.0/result;
        }
        return result;
    }
}
