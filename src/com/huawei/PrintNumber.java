package com.huawei;

public class PrintNumber {
    public static void main(String[] args) {
        print(4);
    }
    public static void print(int n){
        for(int i=1;i<=n;i++){
            for(int j=n-i;j>0;j--){
                System.out.print(" ");
            }
            for(int v=1;v<2*i;v++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
