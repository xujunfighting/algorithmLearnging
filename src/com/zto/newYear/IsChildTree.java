package com.zto.newYear;

import com.zto.algorithm.TreeNode;

/**
 * Created by xujun on 2019-01-28.
 */
public class IsChildTree {
    public static void main(String[] args){
        TreeNode node1=new TreeNode(1);
        TreeNode node2=new TreeNode(2);
        TreeNode node3=new TreeNode(3);
        TreeNode node4=new TreeNode(4);
        TreeNode node5=new TreeNode(5);
        TreeNode node6=new TreeNode(6);
        node1.left=node2;
        node1.right=node3;
        node2.left=node4;
        node2.right=node5;
        node5.left=node6;
        boolean result=isChildTree(node1,node2);
        System.out.println(result);
    }
    public static boolean isChildTree(TreeNode n1,TreeNode n2){
        if(n1==null&&n2==null){
            return true;
        }
        if(n1==null||n2==null){
            return false;
        }
        if(n1.getVal()==n2.getVal()){
           return getResult(n1,n2);
        }
       boolean l=isChildTree(n1.left,n2);
       boolean r=isChildTree(n1.right,n2);
       return l||r;
    }
    public static boolean getResult(TreeNode n1,TreeNode n2){
        if(n2==null){//当子树达到末尾直接返回true n1无论是否到达末尾都是true
            return true;
        }
        if(n1==null&&n2!=null){
            return false;
        }
        if(n1.getVal()!=n2.getVal()){
            return false;
        }
        return getResult(n1.left,n2.left)&&getResult(n1.right,n2.right);
    }
}
