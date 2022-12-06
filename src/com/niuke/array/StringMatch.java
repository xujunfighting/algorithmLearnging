package com.niuke.array;

public class StringMatch {

    public static void main(String[] args) {
       String s1="leetcode";
       String s2="code";
        int result = getResult(s1, s2);
        System.out.println(result);
    }

    /**
     * kmp实现
     * @param haystack
     * @param needle
     * @return
     */
    public static int getResult(String haystack, String needle){

        if(haystack.length()<needle.length()){
            return -1;
        }

        int i=0,j=0;
        int[] next=getNext(needle);
        while (i< haystack.length() && j<needle.length()){
            if (j==-1 || haystack.charAt(i)==needle.charAt(j)){
                i++;
                j++;
            }else {
                j=next[j];
            }
        }
        if (j==needle.length())
            return i-j;
        else
            return -1;

    }

    private static int[] getNext(String sub){
        int[] next=new int[sub.length()+1];
        int i=0;
        int j=-1;
        next[0]=-1;
        while (i<sub.length()){
            if (j==-1 || sub.charAt(i) == sub.charAt(j)){
                System.out.println("cur i:"+(++i));
                System.out.println("cur j:"+(++j));
                next[i]=j;
            }else {
                System.out.println("position j is:"+j);
                j=next[j];
            }
        }
        return next;

    }
}
