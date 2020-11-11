package com.zto.java8;

import java.util.Arrays;

/**
 * Author xujun
 * Create date 2019-04-02.
 * desc:
 */
public class Test1 {
    public static void main(String[] args) {
        String[] s=new String[]{"123","123",null,"123"};
        Arrays.asList(s).stream().filter(x->{
            return x!=null;
        });
    }
}
