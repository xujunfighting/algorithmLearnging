package com.niuke;

import com.zto.algorithm.TreeNode;

import java.awt.image.AreaAveragingScaleFilter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @Description
 * @Author xujun
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/11/25
 */
public class LayerOrderTree {
    public static void main(String[] args) {
          TreeNode node1=new TreeNode(1);
          TreeNode node2=new TreeNode(2);
          TreeNode node3=new TreeNode(3);
          TreeNode node4=new TreeNode(4);
          node1.left=node2;
          node1.right=node3;
          node2.left=node4;
        ArrayList<ArrayList<Integer>> arrayLists = layerOrder(node1);
        System.out.println(arrayLists);

    }
    public static ArrayList<ArrayList<Integer>> layerOrder(TreeNode treeNode){
        ArrayList<ArrayList<Integer>> lists=new ArrayList<>();
        ArrayList<Integer> list=new ArrayList<>();
        if(treeNode==null){
            return lists;
        }
        int cur=1;
        int index=0;
        int next=0;
        Queue<TreeNode> queue=new LinkedBlockingQueue<>();
        queue.add(treeNode);
        while(!queue.isEmpty()){
            TreeNode node=queue.poll();
            index++;
            list.add(node.val);
            if(node.left!=null){
                next++;
                queue.add(node.left);
            }
            if(node.right!=null){
                next++;
                queue.add(node.right);
            }
            if(index==cur){
                index=0;
                cur=next;
                next=0;
                lists.add(new ArrayList<>(list));
                list=new ArrayList<>();
            }
        }
        return lists;
    }
}
