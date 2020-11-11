package com.huawei;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class Test2 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int k=scanner.nextInt();
        int n=scanner.nextInt();
        int m=scanner.nextInt();
        getResult(k,n,m);
    }
    public static void getResult(int k,int n,int m){
        List<Integer> res=new ArrayList<Integer> ();
        int count=0;
        while(k!=0){
            int v=k%m;
            res.add(v);
            k=k/m;
        }
        if(res.size()!=0) {
            for (int i : res) {
                if (i == n) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
