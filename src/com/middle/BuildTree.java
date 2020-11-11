package com.middle;

import com.zto.algorithm.TreeNode;

public class BuildTree {
    public static void main(String[] args) {
        int[] pre=new  int[]{1,2,4,7,3,5,6,8};
        int[] mid=new int[]{4,7,2,1,5,3,8,6};
        TreeNode head=buildTree(pre,mid,0,pre.length-1,0,mid.length-1);
        System.out.println(head);
    }
    public static TreeNode buildTree(int[] a,int[] b,int start1,int end1,int start2,int end2){
         if(start1>end1||start2>end2||start1>=a.length||end1<0||start2>=b.length||end2<0){
             return null;
         }
         int index=a[start1];
         TreeNode head=new TreeNode(index);
         int index2=start2;
         for(int i=start2;i<=end2;i++){
             if(b[i]==index){
                 index2=i;
             }
        }
         head.left=buildTree(a,b,start1+1,start1+(index2-start2),start2,index2-1);
         head.right=buildTree(a,b,start1+(index2-start2)+1,end1,index2+1,end2);
         return head;
    }
}
