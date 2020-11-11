package com.zto.newYear;

import com.zto.algorithm.TreeNode;

/**
 * Created by xujun on 2019-01-09.
 */
public class ReBuildTree {
    public static void main(String[] args){
       int[] pre=new int[]{1,6,4,5,3,8,9};
       int[] middle=new int[]{4,6,5,1,8,3,9};
       TreeNode node=rebuildTree(pre,middle,0,pre.length-1,0,middle.length-1);
    }
    public static TreeNode rebuildTree(int[] a,int[] b,int start1,int end1,int start2,int end2){
       int index=a[start1];
       TreeNode node=new TreeNode(index);
       int i=0;
       for(i=start2;i<=end2;i++){//在中序遍历中找到第一个数据
           if(index==b[i]){
               break;
           }
       }
       if(1+start2<=i) {
           node.left = rebuildTree(a, b, start1 + 1, start1+(i-start2), start2, i-1);
       }
       if(start1-start2+i+1<=end1) {
           node.right = rebuildTree(a, b, start1-start2+i+1, end1, i + 1, end2);
       }
       return node;
    }
}
