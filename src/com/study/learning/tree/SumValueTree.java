package com.study.learning.tree;

import com.zto.algorithm.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Author xujun
 * Create date 2020-01-05.
 * desc:
 */
public class SumValueTree {
    private static List<List<Integer>> results = new ArrayList<>();
    private static List<Integer> res= new ArrayList<>();
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(2);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(4);
        TreeNode node7 = new TreeNode(7);
        node1.left=node2;
        node1.right=node3;
        node2.left=node4;
        node2.right=node5;
        node3.left=node6;
        node3.right=node7;
        method(node1,7);
        System.out.println("end");
    }
    public static void method(TreeNode node,int sum){
        if(node==null){
            return;
        }else if(node.right==null&&node.left==null&&node.getVal()==sum){
            res.add(node.getVal());
            results.add(new ArrayList<Integer>(res));
            res.remove(res.size()-1);
            return;
        }
        sum -=node.getVal();
        res.add(node.getVal());
        method(node.left,sum);
        method(node.right,sum);
        sum +=node.getVal();
        res.remove(res.size()-1);
    }
}
