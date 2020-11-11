package com.middle;

import com.zto.algorithm.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class SumValueOfTreeNode {
    public static List<List<Integer>> lists = new ArrayList<>();
    public static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) {
        TreeNode treeNode1= new TreeNode(1);
        TreeNode treeNode2= new TreeNode(2);
        TreeNode treeNode3= new TreeNode(3);
        TreeNode treeNode33= new TreeNode(3);
        TreeNode treeNode22= new TreeNode(2);
        treeNode1.left=treeNode2;
        treeNode1.right=treeNode3;
        treeNode2.left=treeNode33;
        treeNode3.right=treeNode22;
        getResult(treeNode1,6);
        System.out.println(lists);
    }
    public static List<List<Integer>> getResult(TreeNode node,int sum){
        if(node!=null&&node.left==null&&node.right==null){
            if(sum-node.getVal()==0){
                list.add(node.getVal());
                lists.add(new ArrayList<>(list));
            }
            list.remove(list.size()-1);
            return lists;
        }
        if(node==null){
            return lists;
        }
        sum-=node.getVal();
        list.add(node.getVal());
        getResult(node.left,sum);
        getResult(node.right,sum);
        sum+=node.getVal();
        list.remove(list.size()-1);
        return lists;
    }
}
