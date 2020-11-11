package com.zto.algorithm;

/**
 * Author xujun
 * Create date 2019-09-20.
 * desc:
 */
import java.util.Scanner;
public class Main3 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str=sc.next();
        String[] sts=str.split(",");
        int[] ints=new int[sts.length];
        for(int i=0;i<ints.length;i++){
            ints[i]=Integer.parseInt(sts[i]);
        }
        int n1=ints[0];
        int n2=ints[1];

        for(int i=2;i<ints.length;i++){
            if(ints[i]>Math.min(n1,n2)||ints[i]>Math.max(n1,n2)){
                if(n1>n2){
                    n2=ints[i];
                }else{
                    n1=ints[i];
                }
            }
        }
        System.out.print(n1+","+n2);
    }
}
