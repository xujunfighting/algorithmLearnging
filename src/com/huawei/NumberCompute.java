package com.huawei;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NumberCompute {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        ArrayList<Integer> arrayList=new ArrayList<>();
        while(scanner.hasNext()){
            arrayList.add(scanner.nextInt());
        }
        getResult(arrayList);
    }

    public static void getResult(List<Integer> list){
        int count1=0;//用于统计非负数个数
        int count2=0;//用于统计负数个数
        double result=0;
        for(int i:list){
            if(i<0) {
                count2++;
            }else{
                count1++;
                result+=i;
            }
        }
        System.out.println(count2);
        if(result==0){
            System.out.println(result);
        }else{
            System.out.println(String.format("%.1f",result/count1));
        }
    }
}
