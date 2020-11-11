package com.zto.offer;

/**
 * Created by xujun on 2018-12-27.
 */
public class HanNouTower {
    public static  void main(String[] args){
        int n=3;
        method(n,"A","B","C");
    }
    public static void method(int n,String a,String b,String c){
        if(n==1){
           println(a,c);
        }else{
           method(n-1,a,c,b);
           println(a,c);
           method(n-1,b,a,c);
        }
    }
    public static void println(String a,String b){
        System.out.println(a+"----->"+b);
    }
}
