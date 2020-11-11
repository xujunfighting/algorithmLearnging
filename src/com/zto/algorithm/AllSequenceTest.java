package com.zto.algorithm;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by xujun on 2018-08-30.
 */
public class AllSequenceTest {
  public static void main(String[] args){
      String  res=new String();
      Scanner scanner=new Scanner(System.in);
      res=scanner.nextLine();
      char[] chars=res.toCharArray();
      if(chars==null||chars.length==1){
          System.out.print(chars[0]);
      }else{
          permutation(chars,0);
      }
  }
    public static void swap(char[] arr,int idx1,int idx2){
        char temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }
    public static void permutation(char[] arr,int index){
        if(index == arr.length){
          System.out.print(new String(arr)+" ");
          System.out.println();
        }
        else{
            for(int i = index;i<arr.length;i++){
                System.out.println("i:"+i+" index:"+index+" ");
                swap(arr,i,index);
                permutation(arr,index+1);
                swap(arr,i,index);
            }
        }
    }
}
