package com.niuke;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author xujun
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/12/30
 */
public class TransformString {
    private static final int index=32;
    public static void main(String[] args) {
          String res= " h i";
//
//        "SAMPLE A IS tHIS"
        String result = getResult(res);
        System.out.println(result);
    }
    public static String getResult(String res){
        if(res==null||res.length()==0){
            return res;
        }
        StringBuffer result=new StringBuffer();
        char[] resChars=res.toCharArray();
        List<Character> seperators=new ArrayList<>();

        for(int j=0;j<resChars.length;j++){

        }
        String[] strs=res.split(" ");
        for(int i=strs.length-1;i>=0;i--){
            char[] chars=strs[i].toCharArray();
            for(int j=0;j<chars.length;j++){
                if(chars[j]>='a'&&chars[j]<='z'){
                    result.append((char)(chars[j]- index));
                }else if(chars[j]>'A'&&chars[j]<='Z'){
                    result.append((char)(chars[j]+index));
                }
            }
            if(i!=strs.length-1) {
                result.append(' ');
            }
        }
        return result.toString();
    }
}
