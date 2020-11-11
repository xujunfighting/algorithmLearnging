package com.zto.method;

/**
 * Author xujun
 * Create date 2019-04-04.
 * desc:
 */
public class Test2 {
    static Test2 test=new Test2();
    static {
        System.out.println("1");
    }
    {
        System.out.println("2");
    }
    Test2(){
        System.out.println("3");
        System.out.println("a="+a+",b="+b);
    }
    public static void print(){
        System.out.println("4");
    }
    int a=110;
    static int b=112;

    public static void main(String[] args) {
        print();
    }
}
