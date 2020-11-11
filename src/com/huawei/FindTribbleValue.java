package com.huawei;

import java.util.Scanner;

public class FindTribbleValue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double res=getResult(scanner.nextInt());
        System.out.println(res);
    }
    public static double getResult(int m){
        double res=0;
        double start=0;
        double end=m/2;
        while(end-start>0.001){
            double middle=(start+end)/2;
            if(middle*middle*middle>m){
                end=middle;
            }else if(middle*middle*middle<m){
                start=middle;
            }
        }
         return Double.valueOf(String.format("%.1f",end));
    }
}
