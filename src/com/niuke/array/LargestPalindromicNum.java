package com.niuke.array;

public class LargestPalindromicNum {
    public static void main(String[] args) {
        String s2="7744912";
        String s="0000911";
        String s3="1234";
        String s4="100";
        String result = getResult(s4);

        System.out.println(result);
    }

    public static String getResult(String num){
        StringBuilder s=new StringBuilder();
        int[] args=new int[10];
        int[] indexs=new int[10];
        char[] chars = num.toCharArray();
        //计算每个元素出现的次数
        for(int i=0;i<chars.length;i++){
            args[Integer.valueOf(chars[i]+"")]++;
        }
        int index=args.length-1;
        //从后往前查找 出现次数大于等于2的元素 （贪心查找最大的元素的作为起始元素可以保证数值最大）
        while(index>=0){
            if(args[index]/2>0) {
                int curValue = args[index] / 2;
                indexs[index] = curValue;
                while (curValue > 0) {
                    args[index]--;
                    curValue--;
                    s.append(index);
                }
            }
            index--;
        }
        index=args.length-1;

        //拼接出现单次的最大元素
        while(index>=0){
            if(args[index]-indexs[index]>0){
                s.append(index);
                break;
            }
            index--;
        }
        index=0;
        //从前往后查找 出现次数大于等于2的元素
        while(index<args.length){
            if(indexs[index]>0) {
                int curValue = indexs[index];
                while (curValue > 0) {
                    curValue--;
                    s.append(index);
                }
            }
            index++;
        }
        int i=-1;
        String result=s.toString();
        while(i<s.length()-1&&s.charAt(i+1)=='0'){
            i++;
        }
        if(i==s.length()-1){
            return "0";
        }
        //去除元素前面出现的无效0字符
        if(i>=0){
            result =result.substring(i+1,result.length()-i-1);
        }
        return result;
    }
}
