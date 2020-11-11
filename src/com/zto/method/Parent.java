package com.zto.method;

/**
 * Author xujun
 * Create date 2019-04-04.
 * desc:
 */
public class Parent {
    int i=1;
    Parent(){
        System.out.println(i);
        int x=getValue();
        System.out.println(x);
    }
    {i=2;}
    protected int getValue() {
        return i;
    }
}
