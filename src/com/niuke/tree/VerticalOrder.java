package com.niuke.tree;


import com.zto.algorithm.TreeNode;

import java.util.*;

/**
 * @version v1.0.0
 * @Description
 * @Author xujun
 * @Since 1.0
 * @Date 2021/8/9
 **/
public class VerticalOrder {
    static List<Map<Integer,List<Integer>>> lists=new ArrayList<>();
    static List<List<Integer>> results=null;
    public static void main(String[] args) {
//         TreeNode n1=new TreeNode(0);
//         TreeNode n2=new TreeNode(8);
//         TreeNode n3=new TreeNode(1);
//         TreeNode n4=new TreeNode(3);
//         TreeNode n5=new TreeNode(2);
//         TreeNode n6=new TreeNode(4);
//         TreeNode n7=new TreeNode(5);
//         TreeNode n8=new TreeNode(7);
//         TreeNode n9=new TreeNode(6);
//         n1.left=n2;
//         n1.right=n3;
//         n3.left=n4;
//         n3.right=n5;
//         n4.right=n6;
//         n6.right=n8;
//         n5.left=n7;
//         n7.left=n9;
//        TreeNode n0=new TreeNode(0);
//        TreeNode n10=new TreeNode(10);
//        TreeNode n1=new TreeNode(1);
//        TreeNode n2=new TreeNode(2);
//        TreeNode n4=new TreeNode(4);
//        TreeNode n3=new TreeNode(3);
//        TreeNode n5=new TreeNode(5);
//        TreeNode n6=new TreeNode(6);
//        TreeNode n7=new TreeNode(7);
//        TreeNode n9=new TreeNode(9);
//        TreeNode n8=new TreeNode(8);
//        TreeNode n11=new TreeNode(11);
//        TreeNode n12=new TreeNode(12);
//
//        n0.left=n10;
//        n0.right=n1;
//        n1.left=n2;
//        n1.right=n4;
//        n2.left=n3;
//        n2.right=n5;
//        n3.left=n6;
//        n6.left=n8;
//        n8.left=n12;
//        n5.left=n7;
//        n5.right=n9;
//        n9.right=n11;


        //[0,7,1,null,10,2,null,11,null,3,14,13,null,null,4,null,null,null,null,12,5,null,null,6,9,8]
        TreeNode n0=new TreeNode(0);
        TreeNode n7=new TreeNode(7);
        TreeNode n1=new TreeNode(1);
        TreeNode n10=new TreeNode(10);
        TreeNode n2=new TreeNode(2);
        TreeNode n3=new TreeNode(3);
        TreeNode n14=new TreeNode(14);
        TreeNode n13=new TreeNode(13);
        TreeNode n4=new TreeNode(4);
        TreeNode n12=new TreeNode(12);
        TreeNode n5=new TreeNode(5);
        TreeNode n6=new TreeNode(6);
        TreeNode n9=new TreeNode(9);
        TreeNode n8=new TreeNode(8);
        n0.left=n7;
        n0.right=n1;
        n7.right=n10;
        n10.left=n3;
        n10.right=n14;
        n1.left=n2;
        n2.left=n13;
        n3.right=n4;
        n4.left=n12;
        n4.right=n5;
        n5.left=n6;
        n5.right=n9;
        n6.left=n8;
//         int left=getLeftWidth(n0)-1;
//         int right=getRightWidth(n0)-1;
        /**
         * 提前设置二叉树的宽度列表 默认是设置100宽度
         */
        for(int i=0;i<100;i++){
             lists.add(null);
         }
        /**
         * 假设根节点的宽度值为50
         */
        int depth=getVerticalOrderTree(n0,50,1);
         results=new ArrayList<>(lists.size());
         for(int i=0;i<lists.size();i++){
             int curLevel=1;
             Map<Integer,List<Integer>> maps=lists.get(i);
             if(maps==null){
                 continue;
             }
             List<Integer> levels=new ArrayList<>();
             /**
              * 从深度为1开始遍历 深度越少的元素放在前面
              */
             for(int j=curLevel;j<=depth;j++){
                 if(maps.get(j)!=null){
                     /**
                      * 深度相同的元素 从大到小排序
                      */
                     List<Integer> result=maps.get(j);
                     Collections.sort(result);
                     levels.addAll(result);
                 }
             }
             results.add(levels);
         }
        System.out.println(results);
    }

    public static int getLeftWidth(TreeNode node){
      if(node==null){
          return 0;
      }
      int Lleft=getLeftWidth(node.left);
      int Rleft=0;
      if(node.right!=null&&node.right.left!=null) {
         Rleft = getLeftWidth(node.right.left.left);
      }
      return Math.max(Lleft,Rleft)+1;
    }
    public static int getRightWidth(TreeNode node){
        if(node==null){
            return 0;
        }
        int LRight=0;
        if(node.left!=null&&node.left.right!=null) {
            LRight = getRightWidth(node.left.right.right);
        }
        int RRight=getRightWidth(node.right);
        return Math.max(LRight,RRight)+1;
    }

    public static int   getVerticalOrderTree(TreeNode node,int curIndex,int curDepth){
        if(node==null){
            return 0;
        }
        /**
         * 遍历左边的节点二叉树的宽度值减一 深度值加一
         */
       int leftLevel=getVerticalOrderTree(node.left,curIndex-1,curDepth+1);
        System.out.println(node.val);
        Map<Integer,List<Integer>> list=null;
        /**
         * 判断在该宽度位置的节点的map是否存在 存在直接获取 不存在创建一个新的map，并将该map放到lists指定的宽度位置
         */
            if(lists.get(curIndex-1)==null){
                list = new HashMap<>();
                lists.set(curIndex-1,list);

            }else{
                list=lists.get(curIndex-1);
            }

        /**
         * 给单个Map添加元素 level->lists 层号->集合
         */
          if(list.get(curDepth)==null){
              List<Integer> integers=new ArrayList<>();
              integers.add(node.val);
              list.put(curDepth,integers);
          }else{
              List<Integer> integers = list.get(curDepth);
              integers.add(node.val);
          }
        /**
         * 遍历右边的节点二叉树的宽度值加一 深度值加一
         */
        int rightlevel=  getVerticalOrderTree(node.right,curIndex+1,curDepth+1);
        /**
         * 遍历的同时计算树的深度值
         */
        return Math.max(leftLevel,rightlevel)+1;

    }

}
