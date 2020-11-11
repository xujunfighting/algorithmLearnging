package com.zto.algorithm;

/**
 * Author xujun
 * Create date 2019-09-20.
 * desc:
 */

import java.text.DecimalFormat;
import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        double n = sc.nextInt();
        double res=100;
        double k=100;
        double  d=50;
        if(n==1){
            DecimalFormat df = new DecimalFormat("#.00");
            System.out.print(df.format(res)+","+df.format(d)+"");
        }else{
            for(int i=1;i<n;i++){
                k=k/2;
                res+=(k)*2;
                d=(d/2);
            }
            DecimalFormat df = new DecimalFormat("#.00");
            System.out.print(df.format(res)+","+df.format(d)+"");

        }

    }
}