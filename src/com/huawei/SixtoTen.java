package com.huawei;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SixtoTen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> arrays=new ArrayList<>();
        int count=0;
        while(scanner.hasNext()){
            arrays.add(scanner.next());
            if(count==0){
                break;
            }
            count++;
        }
        getResult(arrays);
    }
    public static void getResult(List<String> lists){

        for(String str:lists){
            int val=0;
            String result=str.substring(2);
            char[] chars = result.toCharArray();
            int index=0;
            for(int i=chars.length-1;i>=0;i--){
                if(chars[i]=='A'){
                    val+=10*Math.pow(16,index);
                }else if(chars[i]=='B'){
                    val+=11*Math.pow(16,index);
                }else if(chars[i]=='C'){
                    val+=12*Math.pow(16,index);
                }else if(chars[i]=='D'){
                    val+=13*Math.pow(16,index);
                }else if(chars[i]=='E'){
                    val+=14*Math.pow(16,index);
                }else if(chars[i]=='F'){
                    val+=15*Math.pow(16,index);
                }else{
                    val+=Integer.valueOf(chars[i]+"")*Math.pow(16,index);
                }
                index++;
            }
            System.out.println(val);
        }

    }
}
