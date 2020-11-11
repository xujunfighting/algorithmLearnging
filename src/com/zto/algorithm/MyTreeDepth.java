package com.zto.algorithm;

/**
 * Created by xujun on 2018-10-18.
 */
public class MyTreeDepth {
    public static void main(String[] args){

    }
    public int getDepth(TreeNode node){
       if(node==null){
           return 0;
       } else if(node.left==null&&node.right==null){
           return 1;
       }
        int left=getDepth(node.left);
        int right=getDepth(node.right);
        return left>right?left+1:right+1;
    }
}
