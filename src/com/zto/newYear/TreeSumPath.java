package com.zto.newYear;

import com.zto.algorithm.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xujun on 2019-01-08.
 */
public class TreeSumPath {
    private static List<List<Integer>> lists=new ArrayList<>();
    private static List<Integer> list=new ArrayList<>();
    public static void main(String[] args){
        TreeNode node1=new TreeNode(1);
        TreeNode node6=new TreeNode(6);
        TreeNode node3=new TreeNode(3);
        TreeNode node5=new TreeNode(5);
        TreeNode node4=new TreeNode(4);
        TreeNode node8=new TreeNode(8);
        TreeNode node9=new TreeNode(9);
        node1.left=node6;
        node1.right=node3;
        node6.left=node4;
        node6.right=node5;
        node3.left=node8;
        node3.right=node9;
        method(node1,list,12);
    }
    public static void method(TreeNode node,List<Integer> list,int val){
       if(node.right==null&&node.left==null){
           int value=node.getVal();
           val-=value;
           list.add(value);
           if(val==0){
               List<Integer> ints=new ArrayList<>(list);
               lists.add(ints);
           }
           list.remove(list.size()-1);
           return;
       }
       int value=node.getVal();
       list.add(value);
       method(node.left,list,val-value);
       method(node.right,list,val-value);
       list.remove(list.size()-1);
    }
}
