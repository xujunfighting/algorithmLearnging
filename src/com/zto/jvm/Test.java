package com.zto.jvm;

/**
 * Created by xujun on 2019-02-13.
 */
public class Test {
    public static void main(String[] args) {
//        String a=new String("a");//a在堆中重新创建
//        a.intern();
//        String b="a";//常量的引用
//        System.out.println(b==a);
//        String aa=new String("a")+new String("a");//在常量池中创建该对象
//        aa.intern();
//        String bb="aa";
//        System.out.println(bb==aa);
        String s0 = new StringBuilder().append("he").append("llo").toString();
        System.out.println(s0.intern() == s0);

        String s1 = new StringBuilder().append("ja").append("va").toString();
        System.out.println(s1.intern() == s1);
    }
}
