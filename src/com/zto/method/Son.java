package com.zto.method;

/**
 * Author xujun
 * Create date 2019-04-04.
 * desc:
 */
public class Son extends Parent{
    int j=1;
    Son(){
        j=2;
    }
    {j=3;}
    @Override
    protected int getValue() {
        return j;
    }
}
