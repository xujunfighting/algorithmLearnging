package com.zto.orderMethod;

import com.zto.algorithm.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Author xujun
 * Create date 2019-07-30.
 * desc:
 */
public class SumDataTreePath {
    private static List<Integer> list=new ArrayList<>();
    private static List<List<Integer>> lists=new ArrayList<>();
    public static void main(String[] args) {
        TreeNode node1=new TreeNode(1);
        TreeNode node2=new TreeNode(2);
        TreeNode node3=new TreeNode(3);
        TreeNode node4=new TreeNode(4);
        TreeNode node5=new TreeNode(5);
        TreeNode node6=new TreeNode(6);
        TreeNode node7=new TreeNode(7);
        TreeNode node8=new TreeNode(8);
        node1.left=node4;
        node1.right=node3;
        node4.left=node6;
        node4.right=node5;
        node1.right=node2;
        node2.left=node8;
        node2.right=node7;
        getSumTreeList(node1,11);
        print(lists);
    }

    private static void print(List<List<Integer>> lists) {
        for(List<Integer> list:lists){
            for(int i:list){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> getSumTreeList(TreeNode node,int sum){
        if(node==null){
           return lists;
        }
        if(sum-node.getVal()==0){
            list.add(node.getVal());
            lists.add(new ArrayList<Integer>(list));
            list.remove(list.size()-1);
            return lists;
        }
        sum=sum-node.getVal();
        list.add(node.getVal());
        getSumTreeList(node.left,sum);
        getSumTreeList(node.right,sum);
        list.remove(list.size()-1);
        return lists;
    }
}
