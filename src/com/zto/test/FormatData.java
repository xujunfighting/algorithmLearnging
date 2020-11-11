package com.zto.test;

import java.text.DecimalFormat;

/**
 * Created by xujun on 2018-12-19.
 */
public class FormatData {
    public static void main(String[] args){
        Long data=10000L;
        DecimalFormat df = new DecimalFormat("#,###");
        System.out.print(df.format(data));
    }

}
