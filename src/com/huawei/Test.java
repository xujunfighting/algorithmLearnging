package com.huawei;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;

public  class  Test {
    public static void main(String[] args) {
        System.out.println("请输入字符串:");
        String str = "";
        Scanner scan = new Scanner(System.in);
        str = scan.nextLine();
        printall(str);
        System.out.println(printall(str));
    }

    private static ArrayList<String> printall(String str) {
        ArrayList<String> result = new ArrayList<>();
        if (str == null || str.length() == 0) {
            return result;
        }
        char[] chars = str.toCharArray();
        //按字典顺序输出
        TreeSet<String> temp = new TreeSet<>();
        printallstr(chars, temp, 0);
        result.addAll(temp);
        return result;
    }

    private static void printallstr(char[] chars, TreeSet<String> temp, int index) {
        if (chars == null || chars.length == 0 || index < 0 || index > chars.length) {
            return;
        }

        if (index == chars.length - 1) {
            //递归的结束
            temp.add(String.valueOf(chars));
        } else {
            for (int i = index; i < chars.length; i++) {
                //把第一个字符和后面的字符交换
                swap(chars, i, index);
                //对后面的所有字符进行全排列
                printallstr(chars, temp, index + 1);
                //把第一个字符再换回来，方便再与其他字符交换
                swap(chars, i, index);
            }
        }
    }

    private static void swap(char[] chars, int i, int index) {
        char temp = chars[i];
        chars[i] = chars[index];
        chars[index] = temp;
    }
}