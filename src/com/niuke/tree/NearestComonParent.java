package com.niuke.tree;

import com.zto.algorithm.TreeNode;

/**
 * @author xujun
 * @Description
 * @create 2021-09-03 1:36 PM
 **/
public class NearestComonParent {
   static TreeNode result=null;
    /**
     * 公共父节点根据后续遍历在两个节点之后
     * @param args
     */
    public static void main(String[] args) {
      TreeNode n1=new TreeNode(1);
      TreeNode n2=new TreeNode(2);
      TreeNode n3=new TreeNode(3);
      TreeNode n4=new TreeNode(4);
      TreeNode n5=new TreeNode(5);
      TreeNode n6=new TreeNode(6);
      n1.left=n2;
//      n1.right=n3;
//      n3.left=n4;
//      n4.left=n5;
//      n3.right=n6;
      getResult(n1,n1,n2);
      System.out.println(result.val);
    }
    public static TreeNode getResult(TreeNode treeNode, TreeNode p, TreeNode q){
        if(treeNode==null){
            return null;
        }
        if(treeNode.val==p.val||treeNode.val==q.val){
            result=treeNode;
            return treeNode;
        }
        TreeNode left=getResult(treeNode.left,p,q);
        TreeNode right=getResult(treeNode.right,p,q);
        if(left!=null&&right!=null)
        {
            /**
             * 左右节点之间不存在父子关系
             * 后续遍历当前节点为左右子树的根
             */
            result=treeNode;
        }
        if(left==null&&right!=null){
            /**
             * 右节点为父节点
             */
            result=right;
        }
        if(left!=null&&right==null){
            /**
             * 左节点为父节点
             */
            result=left;
        }
        if(left==null&&right==null){
            return null;
        }else if(left!=null&&right==null){
            return left;
        }else if(left==null&&right!=null){
            return right;
        }else {
            return treeNode;
        }
    }
}
