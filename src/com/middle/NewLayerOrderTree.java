package com.middle;

import com.zto.algorithm.TreeNode;

import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;

public class NewLayerOrderTree {
    public static void main(String[] args) {
        TreeNode node1= new TreeNode(1);
        TreeNode node2= new TreeNode(2);
        TreeNode node3= new TreeNode(3);
        TreeNode node4= new TreeNode(4);
        TreeNode node5= new TreeNode(5);
        node1.left=node2;
        node1.right=node3;
        node3.left=node4;
        node3.right=node5;
        ArrayList<ArrayList<Integer>> resutls=layerOrderTree(node1);
        System.out.println(resutls);
    }
    public static ArrayList<ArrayList<Integer>> layerOrderTree(TreeNode node){
        ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();

        if(node==null){
            return lists;
        }
        ArrayBlockingQueue<TreeNode> treeNodes = new ArrayBlockingQueue<TreeNode>(10);
        treeNodes.add(node);
        int count=1;
        int index=0;
        int nextCount=0;
        ArrayList<Integer> list= new ArrayList<>();
        while(!treeNodes.isEmpty()){
            TreeNode cur=treeNodes.poll();
            list.add(cur.getVal());
            System.out.println(cur.getVal());
            index++;
            if(cur.left!=null){
                treeNodes.add(cur.left);
                nextCount++;
            }
            if(cur.right!=null){
                treeNodes.add(cur.right);
                nextCount++;
            }
            if(count==index){
                lists.add(list);
                list=new ArrayList<>();
                count=nextCount;
                nextCount=0;
                index=0;
                System.out.println();
            }
        }
        return lists;
    }

}
