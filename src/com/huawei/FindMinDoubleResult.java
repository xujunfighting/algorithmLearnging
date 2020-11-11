package com.huawei;

import java.util.Scanner;

public class FindMinDoubleResult {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int res=getResult(328, 7751);
        System.out.println(res);
    }
    public static int getResult(int a,int b){
         int max=(a>b)?a:b;
         int min=(a>b)?b:a;
         int r=0;
         while(max%min!=0){
             r=max%min;
             max=min;
             min=r;
         }
         return a*b/min;
    }
}
