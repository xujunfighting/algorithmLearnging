package com.zto.algorithm;

/**
 * Created by xujun on 2018-12-24.
 */
public class DepthTree {
    public static  void main(String[] args){
      TreeNode n1=new TreeNode(1);
      TreeNode n2=new TreeNode(1);
      TreeNode n3=new TreeNode(1);
      TreeNode n4=new TreeNode(1);
      TreeNode n5=new TreeNode(1);
      n1.left=n2;
      n1.right=n3;
      n2.left=n4;
      n2.right=n5;
      int depth=method(n1);
      System.out.print(depth);
    }
    public static int method(TreeNode n1){
      if(n1==null){
          return 0;
      }
      int left=method(n1.left);
      int right=method(n1.right);
      return left>right?left+1:right+1;
    }
}
