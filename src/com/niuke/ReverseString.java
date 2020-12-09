package com.niuke;

/**
 * @Description
 * @Author xujun
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/12/4
 */
public class ReverseString {
    private static StringBuffer sb=new StringBuffer();
    public static void main(String[] args) {
         String str="hroqtnxcpwajjxlupboggjxotaamiyzaudhixpcjkzchyeivnfwgmzwpnbkvyzmxbjqsolohpdyzamkwzvtzwtofwgvqwcliltyazmubnovdhrhbmkoguwgomydtbaxgi";
         getResult(str.toCharArray(),0);
        System.out.println(sb.toString());
    }
    public static void getResult(char[] chars,int index){
       if(index>=chars.length){
           return;
       }
       getResult(chars,index+1);
       sb.append(chars[index]);
    }
}
