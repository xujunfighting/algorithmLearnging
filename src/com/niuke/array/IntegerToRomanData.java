package com.niuke.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @version v1.0.0
 * @Description
 * @Author xujun
 * @Since 1.0
 * @Date 2021/7/5
 **/
public class IntegerToRomanData {
    public static void main(String[] args) {
        String result = getResult(4);
        System.out.println(result);

    }
    public static String getResult(int data){
        int values[]={1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] reps=new String[]{"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

        String res="";
        /**
         * 从大像小的遍历够减就添加相对应的罗马数字，尽量用大的罗马数字进行尝试，不够减在选择后续的数值
         */
        for(int i=0; i<13; i++){
            while(data>=values[i]){
                data -= values[i];
                res += reps[i];
            }
        }
        return res;
    }
}
