package com.niuke.array;


import java.util.ArrayList;
import java.util.List;

/**
 * @version v1.0.0
 * @Description
 * @Author xujun
 * @Since 1.0
 * @Date 2021/7/2
 **/
public class ConvertZorderString {
    public static void main(String[] args) {
       String s="abcd";
        String string = getString(s,3);
        System.out.println(string);
    }
    public static String getString(String s,int rowNums){
        String res="";
        List<String> lists=new ArrayList<>(rowNums);
        if(rowNums==1||s.length()==1){
            return s;
        }
        char[] chars = s.toCharArray();
        int index=0;
        if(rowNums==2){
            String sb1="";
            String sb2="";
            while (index<chars.length){
                if(index%2==0){
                    sb1+=chars[index]+"";
                }else{
                    sb2+=chars[index]+"";
                }
                index++;
            }
            return sb1+sb2;
        }

        boolean flag=true;

        for(int i=0;i<chars.length;i++){

            if(index==0){
                flag=true;
            }else if(index==rowNums){
                index=rowNums-2;
                flag=false;
            }
            if(flag) {
                String s1 = lists.get(index);
                s1+=chars[i]+"";
                lists.set(index,s1);
                index++;
            }else{
                String s1 = lists.get(index);
                s1+=chars[i]+"";
                lists.set(index,s1);
                index--;
            }
        }
        for(int i=0;i<rowNums;i++){
            res+=lists.get(i).toString();
        }
        return res;
    }
}
